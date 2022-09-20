
package com.cab.dao;

import com.cab.models.Branch;
import com.cab.models.Customer;
import com.cab.models.Order;
import com.cab.models.ProductCompressed;
import com.cab.models.SalesDetail;
import com.cab.models.SalesObject;
import com.cab.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;


public class SalesDAO implements ISalesDAO{
    PreparedStatement pst = null;
    ResultSet rs = null;
    Connection connection = null;
    boolean status = false;
    
    @Override
    public int RegisterCustomer(Customer customer) {
        int result=0;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("INSERT INTO customer ( `name`, `address`, `NIC`, `contact`, `email`) VALUES ( ?,?,?,?, ?);", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, customer.getName());
            pst.setString(2, customer.getAddress());
            pst.setString(3, customer.getNic());
            pst.setString(4, customer.getPhone());
            pst.setString(5, customer.getEmail());
            
           int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                rs = pst.getGeneratedKeys();
                if (rs.next()) {
                  result = rs.getInt(1);                 
                }
                
            }  
        }
        catch (Exception e) {
            e.printStackTrace();
            
        }

        finally {
        	if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           
        }
        return result;
    }

    @Override
    public ArrayList<Customer> GetAllCustomers() {
       ArrayList<Customer> result= new ArrayList<Customer>();
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("Select * from customer;");
            
           
            rs = pst.executeQuery();
            int count = 0;
 
            while (rs.next()){
                int id = rs.getInt(1);
                String nic = rs.getString(2);
                String name = rs.getString(3);
                String address = rs.getString(4);
                String email = rs.getString(5);
                String phone = rs.getString(6);
                           
                result.add(new Customer(id,name,address,nic,email,phone));

            } 
        }
        catch (Exception e) {
            e.printStackTrace();
            
        }

        finally {
        	if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           
        }
        return result;
    }

    @Override
    public int LogSalesHeader(SalesObject so) {
       int result= 0;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("INSERT INTO sales ( `branch`, `customer`, `datetime`, `amount`, `payment`) VALUES (?, ?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, so.getBranch());
            pst.setInt(2, so.getCustomer());
            pst.setDate(3, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            pst.setFloat(4, so.getAmount());
            pst.setString(5, so.getPaymentMethod());
           
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                rs = pst.getGeneratedKeys();
                if (rs.next()) {
                  result = rs.getInt(1);                 
                }
                
            }  
        }
        catch (Exception e) {
            e.printStackTrace();
            
        }

        finally {
        	if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           
        }
        return result;
    }

    @Override
    public boolean LogSalesDetails(SalesDetail sd) {
        boolean result=false;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("INSERT INTO sales_detail ( `sales`, `product`, `quantity`, `amount`) VALUES (?, ?,?,?);");
            pst.setInt(1, sd.getSalesId());
            pst.setInt(2, sd.getProduct());
            pst.setFloat(3, sd.getQuantity());
            pst.setFloat(4, sd.getAmount());
            
           
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                result= true;
            }  
        }
        catch (Exception e) {
            e.printStackTrace();
            result = false;
        }

        finally {
        	if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           
        }
        return result;
    }

    @Override
    public ArrayList<ProductCompressed> GetAllProductsUnderBranch(int id) {
        ArrayList<ProductCompressed> result= new ArrayList<ProductCompressed>();
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("select T1.product, T1.quantity, T2.Name, T2.UnitPrice, T2.Measure from gocheeta.stores as T1 inner join gocheeta.product T2 on  T1.product= T2.Id where T1.branch =?;");
            pst.setInt(1, id);
           
            rs = pst.executeQuery();
            int count = 0;
 
            while (rs.next()){
                int pid = rs.getInt(1);
                int qty = rs.getInt(2);
                String name = rs.getString(3);
                float uprice = rs.getFloat(4);
                String measure = rs.getString(5);
                           
                result.add(new ProductCompressed(pid,name,uprice,measure,qty));

            } 
        }
        catch (Exception e) {
            e.printStackTrace();
            
        }

        finally {
        	if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           
        }
        return result;    
    }

    @Override
    public boolean UpdateStoresAfterSales(int product, float amount, int branch) {
        System.out.println("value-"+product+" -"+amount+" -"+branch);
        boolean result=false;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("Update stores set  `quantity` =(quantity- ?) where `branch`=? and `product`=?;");
            pst.setFloat(1, amount);
            pst.setInt(2, branch);
            pst.setInt(3, product);
            
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                result= true;
            }  
        }
        catch (Exception e) {
            e.printStackTrace();
            result = false;
        }

        finally {
        	if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           
        }
        return result;
    }

    @Override
    public boolean UpdateStoresAfterReceived(int product, float amount, int branch) {
       boolean result=false;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("Update stores set  `quantity` =(quantity+ ?) where `branch`=? and `product`=?;");
            pst.setFloat(1, amount);
            pst.setInt(2, branch);
            pst.setInt(3, product);
            
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                result= true;
            }  
        }
        catch (Exception e) {
            e.printStackTrace();
            result = false;
        }

        finally {
        	if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           
        }
        return result;
    }

    @Override
    public boolean CreateStores(int product, float amount, int branch) {
        boolean result=false;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("insert into stores (`quantity`, `branch`, `product`) values(?,?,?) ;");
            pst.setFloat(1, amount);
            pst.setInt(2, branch);
            pst.setInt(3, product);
            
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                result= true;
            }  
        }
        catch (Exception e) {
            e.printStackTrace();
            result = false;
        }

        finally {
        	if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           
        }
        return result;
    }

    @Override
    public boolean UpdateStores(int product, float amount, int branch) {
        boolean result=false;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("Update stores set  `quantity` = ? where `branch`=? and `product`=?;");
            pst.setFloat(1, amount);
            pst.setInt(2, branch);
            pst.setInt(3, product);
            
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                result= true;
            }  
        }
        catch (Exception e) {
            e.printStackTrace();
            result = false;
        }

        finally {
        	if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           
        }
        return result;
    }

    @Override
    public boolean UpdateCustomer(Customer customer) {
        boolean result=false;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("Update customer set `name`=?, `address`=?, `NIC`=?, `contact`=?, `email`=? where `Id`=?;");
            pst.setString(1, customer.getName());
            pst.setString(2, customer.getAddress());
            pst.setString(3, customer.getNic());
            pst.setString(4, customer.getPhone());
            pst.setString(5, customer.getEmail());
            pst.setInt(6, customer.getId());            
           
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                result= true;
            }  
        }
        catch (Exception e) {
            e.printStackTrace();
            result = false;
        }

        finally {
        	if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           
        }
        return result;
    }

    @Override
    public boolean RemoveCustomer(int customerId) {
        boolean result=false;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("Delete from customer where `Id`=?;");
            
            pst.setInt(1, customerId);            
           
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                result= true;
            }  
        }
        catch (Exception e) {
            e.printStackTrace();
            result = false;
        }

        finally {
        	if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           
        }
        return result;
    }

    @Override
    public int RetreiveAvailableQuantity(int branch, int product) {
        int result= 0;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("select quantity from stores where product = ? and branch =?;");
            pst.setInt(1, product);
            pst.setInt(2, branch);
           
            rs = pst.executeQuery();
            int count = 0;
 
            while (rs.next()){
                result = rs.getInt(1);
            } 
        }
        catch (Exception e) {
            e.printStackTrace();
            
        }

        finally {
        	if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           
        }
        System.out.println("amount here -"+result);
        System.out.println("values here -"+branch +","+product);
        return result;
    }

    @Override
    public int CreateOrder(Order order) {
        int result=0;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("INSERT INTO orders ( `name`, `driver`, `contact`, `dcontact`, `date`, `pick`, `dest`, `vtype`, `did`, `charge`) VALUES ( ?,?,?,?,?, ?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, order.getName());
            pst.setString(2, order.getDriver());
            pst.setString(3, order.getContact());
            pst.setString(4, order.getDcontact());
            pst.setDate(5,new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            pst.setString(6, order.getPick());
            pst.setString(7, order.getDest());
            pst.setString(8, order.getVtype());
            pst.setInt(9, order.getDid());
            pst.setDouble(10, order.getCharge());
            
           int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                rs = pst.getGeneratedKeys();
                if (rs.next()) {
                  result = rs.getInt(1);                 
                }
                
            }  
        }
        catch (Exception e) {
            e.printStackTrace();
            
        }

        finally {
        	if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           
        }
        return result;
    }

    @Override
    public ArrayList<Order> GetAllOrders() {
     ArrayList<Order> result= new ArrayList<Order>();
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("Select * from orders;");
            
           
            rs = pst.executeQuery();
            int count = 0;
 
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String driver = rs.getString(3);
                String contact = rs.getString(4);
                String dcontact = rs.getString(5);
                String date = rs.getDate(6).toString();
                String pick = rs.getString(7);
                String dest = rs.getString(8);
                String vtype = rs.getString(9);
                int did = rs.getInt(10);
                double charge = rs.getDouble(11);
                           
                result.add(new Order(id,name,driver,contact, dcontact, date, pick, dest, vtype, did,charge));

            } 
        }
        catch (Exception e) {
            e.printStackTrace();
            
        }

        finally {
        	if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           
        }
        return result;   
    }
    
}
