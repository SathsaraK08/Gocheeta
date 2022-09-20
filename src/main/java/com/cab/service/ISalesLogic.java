
package com.cab.service;

import java.util.ArrayList;

import com.cab.models.Customer;
import com.cab.models.Order;
import com.cab.models.ProductCompressed;
import com.cab.models.SalesObject;
import com.cab.models.VData;


public interface ISalesLogic {
    
    int RegisterNewCustomerInSystem(Customer customer);
    boolean UpdateCustomerInSystem(Customer customer);
    boolean RemoveCustomerFromSystem(int customer);
    boolean LogSales(SalesObject salesObject);
    ArrayList<Customer> GetCustomersAlreadyIn();
    ArrayList<ProductCompressed> GetProductsBranchStoresHas(int branchId);  
    
    boolean UpdateStoresAfterReceived(int product, float amount, int branch);
    boolean CreateStores(int product, float amount, int branch);
    
    public ArrayList<Order> GetAllOrders();
    int CreateOrder(Order order);
    
    ArrayList<VData> GetVehicles(String start,  String end, String date, String vtype, int branch);
    
}
