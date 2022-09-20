
package com.cab.service;

import com.cab.dao.IProductDAO;
import com.cab.dao.ISalesDAO;
import com.cab.dao.ITransportDAO;
import com.cab.dao.ProductDAO;
import com.cab.dao.SalesDAO;
import com.cab.dao.TransportDAO;
import com.cab.models.Customer;
import com.cab.models.Driver;
import com.cab.models.Order;
import com.cab.models.ProductCompressed;
import com.cab.models.SalesDetail;
import com.cab.models.SalesObject;
import com.cab.models.VData;
import com.cab.models.Vehicle;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class SalesLogic implements ISalesLogic{

    @Override
    public int RegisterNewCustomerInSystem(Customer customer) {
       ISalesDAO salesDAO = new SalesDAO();
       return salesDAO.RegisterCustomer(customer);      
    }

    @Override
    public boolean LogSales(SalesObject salesObject) {
        boolean result= false;
        ISalesDAO salesDAO = new SalesDAO();
        int SalesHeaderId = salesDAO.LogSalesHeader(salesObject);
        
        if(SalesHeaderId > 0)
        {
            for (int i = 0; i < salesObject.getProductDetails().size() ; i++) {
               SalesDetail temp =salesObject.getProductDetails().get(i);
               temp.setSalesId(SalesHeaderId);
               result =salesDAO.LogSalesDetails(temp)&& salesDAO.UpdateStoresAfterSales(salesObject.getProductDetails().get(i).getProduct(),salesObject.getProductDetails().get(i).getQuantity(),salesObject.getBranch());
               if(!result)
               {
                   break;
               }
            }
        }
        else{
            return result;
        }
        return result;
    }

    @Override
    public ArrayList<Customer> GetCustomersAlreadyIn() {
        ISalesDAO salesDAO = new SalesDAO();
        return salesDAO.GetAllCustomers();
    }

    @Override
    public ArrayList<ProductCompressed> GetProductsBranchStoresHas(int branchId) {
        ISalesDAO salesDAO = new SalesDAO();
        return salesDAO.GetAllProductsUnderBranch(branchId);    
    }

    @Override
    public boolean UpdateStoresAfterReceived(int product, float amount, int branch) {
        ISalesDAO salesDAO = new SalesDAO();
        return salesDAO.UpdateStoresAfterReceived(product,  amount,  branch);
    }

    @Override
    public boolean CreateStores(int product, float amount, int branch) {
        ISalesDAO salesDAO = new SalesDAO();
        return salesDAO.CreateStores(product,  amount,  branch);
    }

    @Override
    public boolean UpdateCustomerInSystem(Customer customer) {
        ISalesDAO salesDAO = new SalesDAO();
        return salesDAO.UpdateCustomer(customer);
    }

    @Override
    public boolean RemoveCustomerFromSystem(int customer) {
        ISalesDAO salesDAO = new SalesDAO();
        return salesDAO.RemoveCustomer(customer);
    }

    @Override
    public ArrayList<Order> GetAllOrders() {
        ISalesDAO salesDAO = new SalesDAO();
        return salesDAO.GetAllOrders();
    }

    @Override
    public int CreateOrder(Order order) {
        ISalesDAO salesDAO = new SalesDAO();
        return salesDAO.CreateOrder(order);
    
    }

    @Override
    public ArrayList<VData> GetVehicles(String start,  String end, String date, String vtype, int branch) {
       ISalesDAO salesDAO = new SalesDAO();
       ITransportDAO transportDAO = new TransportDAO();
       ArrayList<VData> vdata = new ArrayList<VData>();
       
      // ArrayList<Vehicle> vehicles = transportDAO.GetAllVehiclesUnderBranchFree(branch);
      ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
      vehicles.add(transportDAO.GetVehicleById(14));
       if(vehicles.size() > 0){
       int d = transportDAO.GetDriverForVehicle(vehicles.get(0).getId());
       ArrayList<Driver> drivers = transportDAO.GetAllDriversUnderBranch(branch);
       if(d == 0 && drivers.size() < 1) return vdata;
       int randomNum = ThreadLocalRandom.current().nextInt(3500, 10000 + 1);
       Driver sdriver= drivers.get(0);
       System.out.println("d for -"+d);
        for (Driver driver : drivers) {
            if(driver.getId() == d){
                sdriver = driver;
                break;
            }
        }
      VData data = new VData(start, end,date,vtype,sdriver.getFullName(), sdriver.getContact(), vehicles.get(0).getPlate(),randomNum, sdriver.getId());     
      vdata.add(data);
      }
       
      return vdata;
    }
    
}
