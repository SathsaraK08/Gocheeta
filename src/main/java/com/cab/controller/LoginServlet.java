
package com.cab.controller;

import com.cab.models.Branch;
import com.cab.models.SystemUser;
import com.cab.service.BranchLogic;
import com.cab.service.IBranchLogic;
import com.cab.service.IUserLogic;
import com.cab.service.UserLogic;
import com.cab.utils.CUD_Response;
import com.cab.utils.MailSender;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet.sales"})
public class LoginServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request,HttpServletResponse response)
    		throws ServletException, IOException {
        String BranchType=null, UserType=null;
        String signup =request.getParameter("sign");
        if(request.getSession().getAttribute("BType") != null){
         BranchType = request.getSession().getAttribute("BType").toString();
         UserType = request.getSession().getAttribute("Type").toString();
        }
        if(UserType != null && BranchType != null ){
            int UserBranch = Integer.parseInt(request.getSession().getAttribute("Branch").toString());
            if(UserType.equals("Administrator"))
                  response.sendRedirect(request.getContextPath() + "/BranchServlet.sales?branch="+UserBranch);
                else
                  response.sendRedirect(request.getContextPath() + "/Sales.sales");  
        }
        else
        {
            if(signup != null)
                request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
            else 
                request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }
        
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String n = request.getParameter("name");
        String p = request.getParameter("password");
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
        if(action != null && action.equals("CreateUser"))
        {
            IUserLogic userLogic = new UserLogic();
            SystemUser systemUser = new SystemUser(0,username,email,password,Integer.parseInt(branch),phone,"",userType,nic,address);
            CUD_Response CUDresponse = new CUD_Response (userLogic.RegisterUserinSystem(systemUser));
            
          /*  response.setContentType("application/json");
            // Get the printwriter object from response to write the required json object to the output stream      
            PrintWriter out = response.getWriter();
            // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
            out.print(new Gson().toJson(CUDresponse));
            out.flush(); */
           request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(
                    request, response);
        }
        else{ 
        IUserLogic userLogic = new UserLogic();
        SystemUser user =userLogic.getUserByEmailPassword(n, p);
        if(user != null){
                System.out.println("Entere to Zone");
                IBranchLogic branchLogic = new BranchLogic();
                Branch userBranch= branchLogic.GetBranchById(user.getBranchId());
//             RequestDispatcher rd = request.getRequestDispatcher("todo.jsp");
//             rd.forward(request,response);
        	request.getSession().setAttribute("name",n);
                request.getSession().setAttribute("Branch",user.getBranchId());
                request.getSession().setAttribute("Type",user.getUserType());
                request.getSession().setAttribute("User",user.getId());
                request.getSession().setAttribute("Name",user.getUsername());
                request.getSession().setAttribute("BType",userBranch.getType());
		String originalUrl = request.getRequestURL().toString();
		String baseUrl = originalUrl.substring(0, originalUrl.length() - request.getRequestURI().length()) + request.getContextPath();
		if(user.getUserType().equals("Administrator"))
                  response.sendRedirect(baseUrl + "/BranchServlet.sales?branch="+user.getBranchId());
                else
                  response.sendRedirect(baseUrl + "/Sales.sales");  
        }
        else{
            request.setAttribute("errorMessage", "Invalid Credentials!");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(
                    request, response);
        }
        }

    }
}
