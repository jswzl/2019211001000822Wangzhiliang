package com.Wangzhiliang.week5.homework;

import com.Wangzhiliang.dao.UserDao;
import com.Wangzhiliang.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {

    Connection con = null;
    @Override
    public void init() throws ServletException {
//        String url = getServletConfig().getServletContext().getInitParameter("url");
//        String driver = getServletConfig().getServletContext().getInitParameter("driver");
//        String username = getServletConfig().getServletContext().getInitParameter("username");
//        String password = getServletConfig().getServletContext().getInitParameter("password");
//        try {
//            Class.forName(driver);
//            con = DriverManager.getConnection(url,username,password);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        con = (Connection) getServletContext().getAttribute("con");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        PrintWriter out=response.getWriter();

        UserDao userDao = new UserDao();
        try {
            User user= userDao.findByUsernamePassword(con,username,password);
            if(user!=null) {

                String rememberMe=request.getParameter("rememberMe");
                if(rememberMe!=null && rememberMe.equals("1")){
                    Cookie usernameCookie=new Cookie("cUsername",user.getUsername());
                    Cookie passwordCookie=new Cookie("cPassword",user.getPassword());
                    Cookie rememberMeCookie=new Cookie("cRememberMe",rememberMe);

                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);
                    rememberMeCookie.setMaxAge(5);

                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);
                }
                HttpSession session = request.getSession();
                System.out.println("Session id" + session.getId());
                session.setAttribute("user",user);
                //request.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }
            else {
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


//        try {
//            String sql="select * from usertab where username=? and password=?";
//            PreparedStatement ps=con.prepareStatement(sql);
//            ps.setString(1,username);
//            ps.setString(2,password);
//            ResultSet rs=ps.executeQuery();
//            if(rs.next()) {
////                out.println("Login Success!!!");
////                out.println("Welcome, "+username);
//                request.setAttribute("id",rs.getInt("id"));
//                request.setAttribute("username",rs.getString("username"));
//                request.setAttribute("password",rs.getString("password"));
//                request.setAttribute("email",rs.getString("email"));
//                request.setAttribute("gender",rs.getString("gender"));
//                request.setAttribute("birthday",rs.getString("birthday"));
//                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
//            }
//            else{
//                request.setAttribute("message","Username or Password Error!!!");
//                request.getRequestDispatcher("login.jsp").forward(request,response);
//
//            }
//
////                out.println("Username or Password Error!!!");
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
