
package com.cab.controller;

import com.cab.models.Branch;
import com.cab.models.Driver;
import com.cab.models.Vehicle;
import com.cab.service.BranchLogic;
import com.cab.service.IBranchLogic;
import com.cab.service.ITransportLogic;
import com.cab.service.TransportLogic;
import com.cab.utils.CUD_Response;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "TransportServlet", urlPatterns = {"/TransportServlet.sales"})
public class TransportServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TransportServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TransportServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        int UserBranch = Integer.parseInt(request.getSession().getAttribute("Branch").toString());
       
        String action = request.getParameter("action");
        String id =request.getParameter("id");
        String plate = request.getParameter("plate");
        String chassis =request.getParameter("chassis");
        String kms = request.getParameter("mileage");
        String status =request.getParameter("status");
        String fuel = request.getParameter("fuel");
        String transmission =request.getParameter("trnsmission");
        String branch = request.getParameter("branch");
        String driver = request.getParameter("driver");
        String date= request.getParameter("adate");
        
        String fullName = request.getParameter("fullname");
        String address = request.getParameter("address");
        String nic = request.getParameter("nic");
        String contact = request.getParameter("contact");
        String vehicleId = request.getParameter("vehicle");
        
        if(driver != null)
        {
        if(driver.trim().length()< 1)   driver = "0";
        }
        else if(driver == null)
        {
           driver = "0";
        }
        
        if(vehicleId != null)
        {
        if(vehicleId.trim().length()< 1)   vehicleId = "0";
        }
        else if(vehicleId == null)
        {
           vehicleId = "0";
        }
        
        
        
        if(action.equals("CreateVehicle"))
        {
            ITransportLogic transportLogic = new TransportLogic();
            Vehicle vehicle = new Vehicle(0,plate,chassis,Float.parseFloat(kms),fuel, transmission,Integer.parseInt(branch),0,Integer.parseInt(driver),date );
            CUD_Response CUDresponse = new CUD_Response (transportLogic.RegisterVehicleInSystem(vehicle));
            
            response.setContentType("application/json");
            // Get the printwriter object from response to write the required json object to the output stream      
            PrintWriter out = response.getWriter();
            // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
            out.print(new Gson().toJson(CUDresponse));
            out.flush();
        }
        if(action.equals("EditVehicle"))
        {
            ITransportLogic transportLogic = new TransportLogic();
            Vehicle vehicle = new Vehicle(Integer.parseInt(id),plate,chassis,Float.parseFloat(kms),fuel, transmission,Integer.parseInt(branch),0 ,Integer.parseInt(driver),date);
            CUD_Response CUDresponse = new CUD_Response (transportLogic.UpdateVehicleProfile(vehicle));
            
            response.setContentType("application/json");
            // Get the printwriter object from response to write the required json object to the output stream      
            PrintWriter out = response.getWriter();
            // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
            out.print(new Gson().toJson(CUDresponse));
            out.flush();
        }
        if(action.equals("DeleteVehicle"))
        {
            ITransportLogic transportLogic = new TransportLogic();
            //Vehicle vehicle = new Vehicle(Integer.parseInt(id),plate,chassis,Float.parseFloat(kms),fuel, transmission,Integer.parseInt(branch),0 ,Integer.parseInt(driver));
            CUD_Response CUDresponse = new CUD_Response (transportLogic.DeleteVehicleFromSystem(Integer.parseInt(id)));
            
            response.setContentType("application/json");
            // Get the printwriter object from response to write the required json object to the output stream      
            PrintWriter out = response.getWriter();
            // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
            out.print(new Gson().toJson(CUDresponse));
            out.flush();
        }
        if(action.equals("CreateDriver"))
        {
            ITransportLogic transportLogic = new TransportLogic();
            Driver driverObj = new Driver(0, fullName,address,nic,contact,Integer.parseInt(branch),Integer.parseInt(vehicleId));
            CUD_Response CUDresponse = new CUD_Response (transportLogic.RegisterDriverInSystem(driverObj));
            
            response.setContentType("application/json");
            // Get the printwriter object from response to write the required json object to the output stream      
            PrintWriter out = response.getWriter();
            // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
            out.print(new Gson().toJson(CUDresponse));
            out.flush();
        }
        if(action.equals("EditDriver"))
        {
            ITransportLogic transportLogic = new TransportLogic();
            Driver driverObj = new Driver(Integer.parseInt(id), fullName,address,nic,contact,Integer.parseInt(branch),Integer.parseInt(vehicleId));
            CUD_Response CUDresponse = new CUD_Response (transportLogic.UpdateDriverProfile(driverObj));
            
            response.setContentType("application/json");
            // Get the printwriter object from response to write the required json object to the output stream      
            PrintWriter out = response.getWriter();
            // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
            out.print(new Gson().toJson(CUDresponse));
            out.flush();
        }
        
        if(action.equals("DeleteDriver"))
        {
            ITransportLogic transportLogic = new TransportLogic();
            //Vehicle vehicle = new Vehicle(Integer.parseInt(id),plate,chassis,Float.parseFloat(kms),fuel, transmission,Integer.parseInt(branch),0 ,Integer.parseInt(driver));
            CUD_Response CUDresponse = new CUD_Response (transportLogic.DeleteDriverFromSystem(Integer.parseInt(id)));
            
            response.setContentType("application/json");
            // Get the printwriter object from response to write the required json object to the output stream      
            PrintWriter out = response.getWriter();
            // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
            out.print(new Gson().toJson(CUDresponse));
            out.flush();
        }
        
        if(action.equals("GetFreeVehicles"))
        {
            ITransportLogic transportLogic = new TransportLogic();
            //Vehicle vehicle = new Vehicle(Integer.parseInt(id),plate,chassis,Float.parseFloat(kms),fuel, transmission,Integer.parseInt(branch),0 ,Integer.parseInt(driver));
            response.setContentType("application/json");
            // Get the printwriter object from response to write the required json object to the output stream      
            PrintWriter out = response.getWriter();
            // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
            out.print(new Gson().toJson(transportLogic.GetFreeVehiclesUnderBranch(UserBranch)));
            out.flush();
        }
        
        if(action.equals("GetVehicleForDriver"))
        {
            ITransportLogic transportLogic = new TransportLogic();
            //Vehicle vehicle = new Vehicle(Integer.parseInt(id),plate,chassis,Float.parseFloat(kms),fuel, transmission,Integer.parseInt(branch),0 ,Integer.parseInt(driver));
            response.setContentType("application/json");
            // Get the printwriter object from response to write the required json object to the output stream      
            PrintWriter out = response.getWriter();
            // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
            out.print(new Gson().toJson(transportLogic.GetVehicleForDriver(Integer.parseInt(driver))));
            out.flush();
        }
        
        if(action.equals("GetDriverForVehicle"))
        {
            ITransportLogic transportLogic = new TransportLogic();
            //Vehicle vehicle = new Vehicle(Integer.parseInt(id),plate,chassis,Float.parseFloat(kms),fuel, transmission,Integer.parseInt(branch),0 ,Integer.parseInt(driver));
            response.setContentType("application/json");
            // Get the printwriter object from response to write the required json object to the output stream      
            PrintWriter out = response.getWriter();
            // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
            out.print(new Gson().toJson(transportLogic.GetDriverForVehicle(Integer.parseInt(vehicleId))));
            out.flush();
        }
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
