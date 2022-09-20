
package com.cab.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cab.service.BranchLogic;
import com.cab.service.IBranchLogic;


@WebServlet(name = "BranchListServlet", urlPatterns = {"/BranchListServlet.sales"})
public class BranchListServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BranchListServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BranchListServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String BranchType = request.getSession().getAttribute("BType").toString();
        String UserType = request.getSession().getAttribute("Type").toString();
        System.out.println("Object values "+BranchType+UserType);
        if(BranchType.equals("Head") && UserType.equals("Administrator")){
            IBranchLogic branchLogic = new BranchLogic();       
            request.setAttribute("branches", branchLogic.GetAllSubBranch());
            request.getRequestDispatcher("/WEB-INF/views/branchList.jsp").forward(request, response);
        }
        else
        {
            request.getRequestDispatcher("/WEB-INF/views/error404.jsp").forward(request, response);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
