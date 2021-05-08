package com.Wangzhiliang.week3.homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(value = "/register")
public class RegisterServlet extends HttpServlet {

    Connection con = null;

    public void init() throws ServletException {
        String url = getServletConfig().getServletContext().getInitParameter("url");
        String driver = getServletConfig().getServletContext().getInitParameter("driver");
        String username = getServletConfig().getServletContext().getInitParameter("username");
        String password = getServletConfig().getServletContext().getInitParameter("password");
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String username = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String gender = req.getParameter("sex");
        String birthday = req.getParameter("date");


        try {
            String sql1="insert into usertab(username,password,email,gender,birthday) VALUES (?,?,?,?,?);";

            PreparedStatement pstmt =con.prepareStatement(sql1);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            pstmt.setString(3,email);
            pstmt.setString(4,gender);
            pstmt.setDate(5, Date.valueOf(birthday));
            int result = pstmt.executeUpdate();
            if(result==1) System.out.println("OK");
            else System.out.println("ERROR");

//            String sql = "select * from usertab";
//            ResultSet rs = con.createStatement().executeQuery(sql);
//            out.println("<html>");
//            out.println("<body>");
//            while (rs.next()){
//                out.println("<table border=\\\"1\\\">");
//                out.println("<tr>");
//                out.println("<th>ID: "+rs.getString(1)+"</th>");
//                out.println("<th>UserName: "+rs.getString(2)+"</th>");
//                out.println("<th>Password: "+rs.getString(3)+"</th>");
//                out.println("<th>Email: :"+rs.getString(4)+"</th>");
//                out.println("<th>Gender:"+rs.getString(5)+"</th>");
//                out.println("<th>BirthDay:"+rs.getString(6)+"</th>");
//                out.println("</tr>");
//                out.println("</table>");
//            }
//            out.println("</body>");
//            out.println("<html>");

            resp.sendRedirect("login");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/register.jsp").forward(req,resp);
    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
