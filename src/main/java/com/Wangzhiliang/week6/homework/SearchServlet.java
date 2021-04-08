package com.Wangzhiliang.week6.homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SearchServlet",value = "/search")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txt =request.getParameter("txt");
        String type =request.getParameter("search");
        if(txt==null) response.sendRedirect("index.jsp");
        else {
            if(type.equals("baidu"))
                response.sendRedirect("https://www.baidu.com/s?wd="+txt);
            else if(type.equals("bing"))
                response.sendRedirect("https://cn.bing.com/search?q="+txt);
            else if(type.equals("google"))
                response.sendRedirect("https://www.google.com/search?q="+txt);
        }
    }
}
