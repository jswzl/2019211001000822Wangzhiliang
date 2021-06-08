package com.Wangzhiliang.lab2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


@WebFilter(filterName = "WzlFilter")
public class WangzhiliangFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("WangZhiLiangFilter -- before chain");
        chain.doFilter(req, resp);
        System.out.println("WangZhiLiangFilter -- after chain");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
