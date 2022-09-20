
package com.cab.controller;

import com.cab.models.Branch;
import com.cab.models.SystemUser;
import com.cab.service.BranchLogic;
import com.cab.service.IBranchLogic;
import com.cab.service.IUserLogic;
import com.cab.service.UserLogic;
import com.cab.utils.CUD_Response;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet.sales"})
public class UserServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String id =request.getParameter("id");
        String username = request.getParameter("username");
        String branch =request.getParameter("branch");
        String address = request.getParameter("address");
        String userType =request.getParameter("type");
        String nic = request.getParameter("nic");
        String email =request.getParameter("email");
        String phone = request.getParameter("contact");
        String password = request.getParameter("password"); 
        String salt = request.getParameter("salt");
        if(action.equals("CreateUser"))
        {
            IUserLogic userLogic = new UserLogic();
            SystemUser systemUser = new SystemUser(0,username,email,password,Integer.parseInt(branch),phone,"",userType,nic,address);
            CUD_Response CUDresponse = new CUD_Response (userLogic.RegisterUserinSystem(systemUser));
            
            response.setContentType("application/json");
            // Get the printwriter object from response to write the required json object to the output stream      
            PrintWriter out = response.getWriter();
            // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
            out.print(new Gson().toJson(CUDresponse));
            out.flush();
        }
        if(action.equals("EditUser"))
        {
            IUserLogic userLogic = new UserLogic();
            SystemUser systemUser = new SystemUser(Integer.parseInt(id),username,email,password,Integer.parseInt(branch),phone,salt,userType,nic,address);
            CUD_Response CUDresponse = new CUD_Response (userLogic.UpdateUserinSystem(systemUser));
            
            response.setContentType("application/json");
            // Get the printwriter object from response to write the required json object to the output stream      
            PrintWriter out = response.getWriter();
            // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
            out.print(new Gson().toJson(CUDresponse));
            out.flush();
        }
        if(action.equals("DeleteUser"))
        {
            IUserLogic userLogic = new UserLogic();
            //SystemUser systemUser = new SystemUser(Integer.parseInt(id),username,email,password,Integer.parseInt(branch),phone,"",userType);
            CUD_Response CUDresponse = new CUD_Response (userLogic.RemoveUserFromSystem(Integer.parseInt(id)));
            
            response.setContentType("application/json");
            // Get the printwriter object from response to write the required json object to the output stream      
            PrintWriter out = response.getWriter();
            // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
            out.print(new Gson().toJson(CUDresponse));
            out.flush();
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
