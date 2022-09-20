
package com.cab.controller;

import com.cab.models.Branch;
import com.cab.models.SalesDetail;
import com.cab.service.BranchLogic;
import com.cab.service.IBranchLogic;
import com.cab.service.IProductLogic;
import com.cab.service.IProductRequestLogic;
import com.cab.service.ProductLogic;
import com.cab.service.ProductRequestLogic;
import com.cab.utils.CUD_Response;
import com.cab.utils.MailSender;
import com.cab.utils.Requests_GetResponse;
import com.cab.utils.Sales_GetResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ProductRequest", urlPatterns = {"/ProductRequest.sales"})
public class ProductRequest extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductRequest</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductRequest at " + request.getContextPath() + "</h1>");
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
        
        if(UserType.equals("Administrator") && !BranchType.equals("Head")){ 
            IProductLogic productLogic = new ProductLogic();       
            request.setAttribute("types", productLogic.GetAllTypes());
            request.setAttribute("products", productLogic.GetAllProducts(UserBranch));
            request.getRequestDispatcher("/WEB-INF/views/productRequest.jsp").forward(request, response);
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
        int User = Integer.parseInt(request.getSession().getAttribute("User").toString());
        
        String action = request.getParameter("action");
        String id =request.getParameter("id");
        String type = request.getParameter("type");
        String Status = request.getParameter("status");
        
        // request
        String sourcebranch = request.getParameter("source_branch");
        String vehicle = request.getParameter("vehicle");
        String objs= request.getParameter("objs");
        
        
        String content = request.getParameter("content");
        String to= request.getParameter("to");
        
        IProductLogic productLogic = new ProductLogic();
        IProductRequestLogic productRLogic = new ProductRequestLogic();
        IBranchLogic branchLogic = new BranchLogic();
        
        Branch me= branchLogic.GetBranchById(UserBranch);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        if(action.equals("GetAllProductsWithBranches"))
        {
                                   
            response.setContentType("application/json");
            // Get the printwriter object from response to write the required json object to the output stream      
            PrintWriter out = response.getWriter();
            // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
            Requests_GetResponse obj =new Requests_GetResponse(productLogic.GetAllProductsNew(),branchLogic.GetAllBranchesExceptMe(UserBranch));
            out.print(new Gson().toJson(obj));
            out.flush();
        }
        
        if(action.equals("CreateProductRequest"))
        {
            
            Type pRequestListType = new TypeToken<ArrayList<com.cab.models.ProductRequestDetail>>(){}.getType();
            ArrayList<com.cab.models.ProductRequestDetail> pRequestDetails = new Gson().fromJson(objs, pRequestListType);       
            response.setContentType("application/json");
            // Get the printwriter object from response to write the required json object to the output stream      
            PrintWriter out = response.getWriter();
            // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
            com.cab.models.ProductRequest ProductRequestobj = new com.cab.models.ProductRequest(0,Integer.parseInt(sourcebranch),UserBranch,"","Pending",0,User);
            ProductRequestobj.setObjs(pRequestDetails);
            CUD_Response cudr =new CUD_Response(productRLogic.LogRequests(ProductRequestobj) && MailSender.sendMailTextContent(to,me.getName()+" "+content, "Product Request on "+dateFormat.format(date)));
            out.print(new Gson().toJson(cudr));
            out.flush();
        }
        
        if(action.equals("GetAllProductRequests"))
        {
                                   
            response.setContentType("application/json");
            // Get the printwriter object from response to write the required json object to the output stream      
            PrintWriter out = response.getWriter();
            // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
            com.cab.models.ProductRequest ProductRequestobj =new com.cab.models.ProductRequest();
            out.print(new Gson().toJson(productRLogic.LogRequests(ProductRequestobj)));
            out.flush();
        }
        
        if(action.equals("ChangeRequestStatus"))
        {
                                   
            response.setContentType("application/json");
            // Get the printwriter object from response to write the required json object to the output stream      
            PrintWriter out = response.getWriter();
            // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
            com.cab.models.ProductRequest ProductRequestobj =new com.cab.models.ProductRequest();
            if(vehicle == null || vehicle.trim().length() <1 ) vehicle ="0";
            if(Status.equals("Approved"))
            {  
                boolean intermediate = productRLogic.StateRequest(Integer.parseInt(id) ,UserBranch, Integer.parseInt(sourcebranch));
               if(intermediate)
               {
                   CUD_Response cudr =new CUD_Response(productRLogic.UpdateProductRequestHeader(Status,Integer.parseInt(id),Integer.parseInt(vehicle)));
                   out.print(new Gson().toJson(cudr));
                   out.flush();
               }
               else
               {
                   CUD_Response cudr =new CUD_Response(false);
                   out.print(new Gson().toJson(cudr));
                   out.flush();
               }
            }
            else
            {
                CUD_Response cudr =new CUD_Response(productRLogic.UpdateProductRequestHeader(Status,Integer.parseInt(id),Integer.parseInt(vehicle)));
                out.print(new Gson().toJson(cudr));
                out.flush();
            }
        }
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
