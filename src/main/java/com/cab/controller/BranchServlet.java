
package com.cab.controller;

import com.cab.models.Branch;
import com.cab.models.Order;
import com.cab.service.BranchLogic;
import com.cab.service.IBranchLogic;
import com.cab.service.IProductRequestLogic;
import com.cab.service.ISalesLogic;
import com.cab.service.ITransportLogic;
import com.cab.service.IUserLogic;
import com.cab.service.ProductRequestLogic;
import com.cab.service.SalesLogic;
import com.cab.service.TransportLogic;
import com.cab.service.UserLogic;
import com.cab.utils.CUD_Response;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "BranchServlet", urlPatterns = {"/BranchServlet.sales"})
public class BranchServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BranchServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BranchServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int UserBranch = Integer.parseInt(request.getSession().getAttribute("Branch").toString());
        String branchId =request.getParameter("branch");
        String BranchType = request.getSession().getAttribute("BType").toString();
        String UserType = request.getSession().getAttribute("Type").toString();
        System.out.println("Object values "+BranchType+UserType);
        if((BranchType.equals("Head") && UserType.equals("Administrator")) || (UserBranch==Integer.parseInt(branchId) && UserType.equals("Administrator")) ){
        String oid = request.getParameter("oid");
        IBranchLogic branchLogic = new BranchLogic();
        ITransportLogic transportLogic = new TransportLogic();
        IUserLogic userLogic = new UserLogic();
        IProductRequestLogic productRequestLogic = new ProductRequestLogic();
        ISalesLogic salesLogic = new SalesLogic();
        ArrayList<Order> lst = salesLogic.GetAllOrders();
        request.setAttribute("systemUsers", userLogic.GetAllUsersUnderBranch(Integer.parseInt(branchId)));
        request.setAttribute("drivers", transportLogic.GetDriversUnderBranch(Integer.parseInt(branchId)));
        request.setAttribute("vehicles", transportLogic.GetVehiclesUnderBranch(Integer.parseInt(branchId)));
        request.setAttribute("branch_detail", branchLogic.GetBranchById(Integer.parseInt(branchId)));
        request.setAttribute("free_drivers", transportLogic.GetFreeDriverUnderBranch(Integer.parseInt(branchId)));
        request.setAttribute("vehicles_noD", transportLogic.GetAllVehiclesUnderBranchHasNoDriver(Integer.parseInt(branchId)));
        request.setAttribute("own_requests", productRequestLogic.GetRequestsByBranch(Integer.parseInt(branchId)));
        request.setAttribute("r_requests", productRequestLogic.GetRequestsByBranchReceived(Integer.parseInt(branchId)));
        request.setAttribute("orders", lst);
        if(oid != null )
        {
           ArrayList<com.cab.models.ProductRequest> secondList = new ArrayList<com.cab.models.ProductRequest>();

                for( com.cab.models.ProductRequest item : productRequestLogic.GetRequestsByBranch(Integer.parseInt(branchId))) { 
                // or equalsIgnoreCase or whatever your conditon is
                if (item.getId() == Integer.parseInt(oid)  ) {
                // do something 
                secondList.add(item);
                }
                } 
           
           request.setAttribute("own_request", secondList);
        }
        request.getRequestDispatcher("/WEB-INF/views/branch.jsp").forward(request, response);
        }
        else
        {
            request.getRequestDispatcher("/WEB-INF/views/error404.jsp").forward(request, response);
        }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        String action = request.getParameter("action");
        String id =request.getParameter("id");
        String name = request.getParameter("name");
        String city =request.getParameter("city");
        String address = request.getParameter("address");
        String longtitude =request.getParameter("long");
        String latitude = request.getParameter("lati");
        String email =request.getParameter("email");
        String phone = request.getParameter("contact");
        
        
                
                
        String branchid = request.getParameter("branch");
        
        Branch branch = new Branch(0,name,city,longtitude, latitude,address, phone,email, "Sub");
        if(action.equals("oidget"))
        {
            IProductRequestLogic productRequestLogic = new ProductRequestLogic();
            ArrayList<com.cab.models.ProductRequest> secondList = new ArrayList<com.cab.models.ProductRequest>();

                for( com.cab.models.ProductRequest item : productRequestLogic.GetRequestsByBranch(Integer.parseInt(branchid))) { 
                // or equalsIgnoreCase or whatever your conditon is
                if (item.getId() == Integer.parseInt(id)  ) {
                // do something 
                secondList.add(item);
                }
                } 
   
            response.setContentType("application/json");
            // Get the printwriter object from response to write the required json object to the output stream      
            PrintWriter out = response.getWriter();
            // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
            out.print(new Gson().toJson(secondList));
            out.flush();
        }
        
        if(action.equals("ridget"))
        {
            IProductRequestLogic productRequestLogic = new ProductRequestLogic();
            ArrayList<com.cab.models.ProductRequest> secondList = new ArrayList<com.cab.models.ProductRequest>();

                for( com.cab.models.ProductRequest item : productRequestLogic.GetRequestsByBranchReceived(Integer.parseInt(branchid))) { 
                // or equalsIgnoreCase or whatever your conditon is
                if (item.getId() == Integer.parseInt(id)  ) {
                // do something 
                secondList.add(item);
                }
                } 
   
            response.setContentType("application/json");
            // Get the printwriter object from response to write the required json object to the output stream      
            PrintWriter out = response.getWriter();
            // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
            out.print(new Gson().toJson(secondList));
            out.flush();
        }
        
        
        
        if(action.equals("CreateBranch"))
        {
            IBranchLogic branchLogic = new BranchLogic();
            
            CUD_Response CUDresponse = new CUD_Response (branchLogic.CreateSubBranch((Branch)branch.getCloneObject()));
            
            response.setContentType("application/json");
            // Get the printwriter object from response to write the required json object to the output stream      
            PrintWriter out = response.getWriter();
            // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
            out.print(new Gson().toJson(CUDresponse));
            out.flush();
        }
        if(action.equals("EditBranch"))
        {
            IBranchLogic branchLogic = new BranchLogic();
            branch.setId(Integer.parseInt(id));
            CUD_Response CUDresponse = new CUD_Response (branchLogic.UpdateSubBranch((Branch)branch.getCloneObject()));
            
            response.setContentType("application/json");
            // Get the printwriter object from response to write the required json object to the output stream      
            PrintWriter out = response.getWriter();
            // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
            out.print(new Gson().toJson(CUDresponse));
            out.flush();
        }
        if(action.equals("DeleteBranch"))
        {
            IBranchLogic branchLogic = new BranchLogic();
            CUD_Response CUDresponse = new CUD_Response (branchLogic.DeleteSpecificSubBranch(Integer.parseInt(id)));
            
            response.setContentType("application/json");
            // Get the printwriter object from response to write the required json object to the output stream      
            PrintWriter out = response.getWriter();
            // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
            out.print(new Gson().toJson(CUDresponse));
            out.flush();
        }
        
        if(action.equals("GetLocations"))
        {
            IBranchLogic branchLogic = new BranchLogic();
            //Branch branch = new Branch(0,name,city,longtitude, latitude,address, phone,email, "Sub");
            
            response.setContentType("application/json");
            // Get the printwriter object from response to write the required json object to the output stream      
            PrintWriter out = response.getWriter();
            // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
            out.print(new Gson().toJson(branchLogic.GetLocationsForRequestId(Integer.parseInt(id))));
            out.flush();
        }
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
