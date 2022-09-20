
package com.cab.dao;

import java.util.ArrayList;

import com.cab.models.Customer;
import com.cab.models.Order;
import com.cab.models.ProductCompressed;
import com.cab.models.SalesDetail;
import com.cab.models.SalesObject;


public interface ISalesDAO {
    
    int RegisterCustomer(Customer customer);
    boolean UpdateCustomer(Customer customer);
    boolean RemoveCustomer(int customerId);
    ArrayList<Customer> GetAllCustomers();
    ArrayList<ProductCompressed> GetAllProductsUnderBranch(int branch);
    int LogSalesHeader(SalesObject salesObject);
    boolean LogSalesDetails(SalesDetail salesDetail);
    boolean UpdateStoresAfterSales(int product, float amount, int branch);
    boolean UpdateStoresAfterReceived(int product, float amount, int branch);
    boolean CreateStores(int product, float amount, int branch);
    boolean UpdateStores(int product, float amount, int branch);
    int RetreiveAvailableQuantity(int branch , int product);
    
    int CreateOrder(Order order);
    ArrayList<Order> GetAllOrders();
}
