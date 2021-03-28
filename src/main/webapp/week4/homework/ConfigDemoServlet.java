package com.Wangzhiliang.week4.homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConfigDemoServlet",value = "/config",
    initParams = {
        @WebInitParam(name = "name",value = "王志良"),
        @WebInitParam(name = "studentId",value = "2019211001000822")
    }
)
public class ConfigDemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String name = getServletConfig().getInitParameter("name");
        String studentId = getServletConfig().getInitParameter("studentId");
        out.println("<html>");
        out.println("<body>");
        out.println("<h1 align=center>name:"+name+"</h1>");
        out.println("<h1 align=center>studentId:"+studentId+"</h1>");
        out.println("</body>");
        out.println("<html>");
    }
}
