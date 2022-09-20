
package com.cab.controller;

import com.cab.models.Customer;
import com.cab.service.IProductRequestLogic;
import com.cab.service.ISalesLogic;
import com.cab.service.ProductRequestLogic;
import com.cab.service.SalesLogic;
import com.cab.utils.CUD_Response;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CustomerServlet", urlPatterns = {"/CustomerServlet.sales"})
public class CustomerServlet extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CustomerServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CustomerServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int UserBranch = Integer.parseInt(request.getSession().getAttribute("Branch").toString());
        String BranchType = request.getSession().getAttribute("BType").toString();
        String UserType = request.getSession().getAttribute("Type").toString();
        
        if(UserType.equals("Administrator")){
            ISalesLogic salesLogic = new SalesLogic();
            request.setAttribute("Customers", salesLogic.GetCustomersAlreadyIn());
            request.getRequestDispatcher("/WEB-INF/views/customer.jsp").forward(request, response);
        }
        else
        {
            request.getRequestDispatcher("/WEB-INF/views/error404.jsp").forward(request, response);
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int UserBranch = Integer.parseInt(request.getSession().getAttribute("Branch").toString());
        
        String action = request.getParameter("action");
        
        String id =request.getParameter("id");
        // customer
        String name = request.getParameter("name");
        String nic =request.getParameter("nic");
        String email = request.getParameter("email");
        String address =request.getParameter("address");
        String phone = request.getParameter("phone");
        
        ISalesLogic salesLogic = new SalesLogic(); 
        Customer customer = new Customer(0,name,address,nic,email,phone);
        if(action.equals("CreateCustomer"))
        {
            
            
            CUD_Response CUDresponse = new CUD_Response (salesLogic.RegisterNewCustomerInSystem((Customer)customer.getCloneObject())> 0);
            
            response.setContentType("application/json");
            // Get the printwriter object from response to write the required json object to the output stream      
            PrintWriter out = response.getWriter();
            // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
            out.print(new Gson().toJson(CUDresponse));
            out.flush();
        }
        if(action.equals("UpdateCustomer"))
        {
            
            
            Customer CustomerObj = (Customer)customer.getCloneObject();
            CustomerObj.setId(Integer.parseInt(id));
            CUD_Response CUDresponse = new CUD_Response (salesLogic.UpdateCustomerInSystem(CustomerObj));
            
            response.setContentType("application/json");
            // Get the printwriter object from response to write the required json object to the output stream      
            PrintWriter out = response.getWriter();
            // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
            out.print(new Gson().toJson(CUDresponse));
            out.flush();
        }
        if(action.equals("DeleteCustomer"))
        {           
            //Customer customer = new Customer();
            CUD_Response CUDresponse = new CUD_Response (salesLogic.RemoveCustomerFromSystem(Integer.parseInt(id)));
            
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
