
package com.cab.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter(urlPatterns = "*.sales")
public class RouteFilter implements Filter {

    public void destroy() {
    	
    }

    public void doFilter(ServletRequest servletRequest,
            ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        if (request.getSession().getAttribute("name") != null) {
            System.out.println("-"+servletRequest.toString()+" -"+servletResponse.toString());
            chain.doFilter(servletRequest, servletResponse);
        } else {
            request.getRequestDispatcher("/LoginServlet.sales").forward(servletRequest,servletResponse);
        }
    }

    public void init(FilterConfig arg0) throws ServletException {
    }

}