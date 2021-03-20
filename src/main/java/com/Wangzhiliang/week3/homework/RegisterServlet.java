package com.Wangzhiliang.week3.homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String gender = req.getParameter("sex");
        String date = req.getParameter("date");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1 align=center>"+"Name: "+username+"</h1>");
        out.println("<h1 align=center>"+"password: "+password+"</h1>");
        out.println("<h1 align=center>"+"email: "+email+"</h1>");
        out.println("<h1 align=center>"+"gender: "+gender+"</h1>");
        out.println("<h1 align=center>"+"date: "+date+"</h1>");
        out.println("</body>");
        out.println("<html>");
    }
}
