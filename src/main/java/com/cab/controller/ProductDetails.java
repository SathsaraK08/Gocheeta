
package com.cab.controller;

import com.cab.models.Return;
import com.cab.service.IProductLogic;
import com.cab.service.ISalesLogic;
import com.cab.service.ProductLogic;
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


@WebServlet(name = "ProductDetails", urlPatterns = {"/ProductDetails.sales"})
public class ProductDetails extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductDetails</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductDetails at " + request.getContextPath() + "</h1>");
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
        request.setAttribute("Products", salesLogic.GetProductsBranchStoresHas(UserBranch));
        
        request.getRequestDispatcher("/WEB-INF/views/productDetails.jsp").forward(request, response);
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
        String qty = request.getParameter("aqty");       
        String amount =request.getParameter("amount");
        
        
        String description = request.getParameter("description");
        String stock =request.getParameter("stock");
        String product = request.getParameter("product");
        String measure =request.getParameter("measure");
        //String phone = request.getParameter("contact");
        Return ReturnObj= new Return(0,UserBranch,Integer.parseInt(id),Integer.parseInt(amount));
        if(action.equals("LogReturns"))
        {
            IProductLogic productLogic = new ProductLogic();                       
            response.setContentType("application/json");
            // Get the printwriter object from response to write the required json object to the output stream      
            PrintWriter out = response.getWriter();
            Return returnLogObj = (Return)ReturnObj.getCloneObject();
            out.print(new Gson().toJson(new CUD_Response(productLogic.CreateUpdateReturn(returnLogObj)> 0)));
            out.flush();
        }
        
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
