
package com.cab.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.cab.models.Branch;
import com.cab.models.Customer;
import com.cab.models.Order;
import com.cab.models.ProductType;
import com.cab.models.SalesDetail;
import com.cab.models.SalesObject;
import com.cab.service.BranchLogic;
import com.cab.service.IBranchLogic;
import com.cab.service.IProductLogic;
import com.cab.service.ISalesLogic;
import com.cab.service.ProductLogic;
import com.cab.service.SalesLogic;
import com.cab.utils.CUD_Response;
import com.cab.utils.MailSender;
import com.cab.utils.Sales_GetResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


@WebServlet(name = "Sales", urlPatterns = {"/Sales.sales"})
public class Sales extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int UserBranch = Integer.parseInt(request.getSession().getAttribute("Branch").toString());
        String uname = request.getSession().getAttribute("Name").toString();
        String BranchType = request.getSession().getAttribute("BType").toString();
        String UserType = request.getSession().getAttribute("Type").toString();
      
        String action = request.getParameter("action");
        String type = request.getParameter("type");
        String start =request.getParameter("start");
        String end = request.getParameter("end");
        String date =request.getParameter("date");
        
        ISalesLogic salesLogic = new SalesLogic();
        ArrayList<Order> lst = salesLogic.GetAllOrders();
        ArrayList<Order> lst_final = new ArrayList<Order>();
        for (Order order : lst) {
            if(order.getName().equalsIgnoreCase(uname)){
                lst_final.add(order);
            }
        }
        
        if(!BranchType.equals("Head")){ 
            IBranchLogic branchLogic = new BranchLogic();  
            IProductLogic productLogic = new ProductLogic();
            request.setAttribute("products", branchLogic.GetAllSubBranch());
            request.setAttribute("orders", lst_final);
            request.getRequestDispatcher("/WEB-INF/views/sales.jsp").forward(request, response);
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
        String uname = request.getSession().getAttribute("Name").toString();
        String action = request.getParameter("action");
        System.out.println("action -"+action);
        String type = request.getParameter("type");
        String start =request.getParameter("start");
        String end = request.getParameter("end");
        String date =request.getParameter("date");
        String driver =request.getParameter("driver");
        String con =request.getParameter("contact");
        String dcon =request.getParameter("dcon");
        String did =request.getParameter("did");
        String chg =request.getParameter("chg");
        ISalesLogic salesLogic = new SalesLogic();
        if(action != null && action.equals("morder"))
        {
            Order order= new Order(0, uname, driver, con, dcon, date, start, end, type, Integer.parseInt(did), Double.parseDouble(chg));
            CUD_Response CUDresponse = new CUD_Response (salesLogic.CreateOrder(order)> 0);
            
            response.setContentType("application/json");
            // Get the printwriter object from response to write the required json object to the output stream      
            PrintWriter out = response.getWriter();
            // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
            out.print(new Gson().toJson(CUDresponse));
            out.flush();
        }
        
        else{
        System.out.println(salesLogic.GetVehicles(start, end, date, type, UserBranch).get(0).getDriver()+" - elements there");
        request.setAttribute("v", salesLogic.GetVehicles(start, end, date, type, UserBranch));
        request.setAttribute("orders", salesLogic.GetAllOrders());
        ArrayList<Order> lst = salesLogic.GetAllOrders();
        ArrayList<Order> lst_final = new ArrayList<Order>();
        for (Order order : lst) {
            if(order.getName().equalsIgnoreCase(uname)){
                lst_final.add(order);
            }
        }
        request.setAttribute("orders", lst_final);
       /* response.setContentType("application/json");
            // Get the printwriter object from response to write the required json object to the output stream      
        PrintWriter out = response.getWriter();
        out.print("result added");
        out.flush();*/
       request.getRequestDispatcher("/WEB-INF/views/sales.jsp").forward(request, response);
        }
       
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
