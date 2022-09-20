
package com.cab.dao;

import com.cab.models.Customer;
import com.cab.models.ProductRequest;
import com.cab.models.ProductRequestDetail;
import com.cab.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;


public class ProductRequestDAO implements IProductRequestDAO{
    PreparedStatement pst = null;
    ResultSet rs = null;
    Connection connection = null;
    boolean status = false;
    @Override
    public int CreateProductRequestHeader(ProductRequest productRequest) {
       int result= 0;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("INSERT INTO product_request ( `source_branch`, `destination_branch`, `date`, `status`,`user`) VALUES (?, ?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, productRequest.getSourceBranch());
            pst.setInt(2, productRequest.getDestinationBranch());
            pst.setDate(3, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            pst.setString(4, "Pending");
            //pst.setInt(5, null);
            pst.setInt(5, productRequest.getUser());
           
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
    public boolean CreateProductRequestDetail(ProductRequestDetail productRequestDetail) {
        boolean result=false;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("INSERT INTO product_request_detail ( `request`, `product`, `qty`) VALUES (?, ?,?);");
            pst.setInt(1, productRequestDetail.getRequestId());
            pst.setInt(2, productRequestDetail.getProductId());
            pst.setFloat(3, productRequestDetail.getQty());
            
            
           
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
    public ArrayList<ProductRequest> GetProductRequestsUnderBranch(int branch) {
      ArrayList<ProductRequest> result= new ArrayList<ProductRequest>();
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("SELECT T1.*, T2.name FROM   product_request as T1 inner join branch T2 on T1.source_branch = T2.Id where destination_branch=?;");
            pst.setInt(1, branch);
           
            rs = pst.executeQuery();
            int count = 0;
 
            while (rs.next()){
                int id = rs.getInt(1);
                int sourcebranch = rs.getInt(2);
                int destBranch = rs.getInt(3);
                String date = rs.getString(4);
                String status = rs.getString(5);
                int vehicle = rs.getInt(6);
                int user = rs.getInt(7);
                String sourcebranchName = rs.getString(8);
                //String vehiclePlate = rs.getString(9);
                
                result.add(new ProductRequest(id,sourcebranch,destBranch,date,status,vehicle,user));

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
    public ArrayList<ProductRequestDetail> GetProductRequestsDetaisUnderRequest(int request) {
      ArrayList<ProductRequestDetail> result= new ArrayList<ProductRequestDetail>();
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("SELECT * FROM  product_request_detail  where request=?;");
            pst.setInt(1, request);
           
            rs = pst.executeQuery();
            int count = 0;
 
            while (rs.next()){
                int id = rs.getInt(1);
                int product = rs.getInt(3);
                int requestId = rs.getInt(2);
                float qty = rs.getFloat(4);
                            
                result.add(new ProductRequestDetail(id,requestId,product,qty));
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
    public ArrayList<ProductRequest> GetProductRequestsUnderBranchReceived(int branch) {
        ArrayList<ProductRequest> result= new ArrayList<ProductRequest>();
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("SELECT T1.*, T2.name FROM   product_request as T1 inner join branch T2 on T1.source_branch = T2.Id where source_branch=?;");
            pst.setInt(1, branch);
           
            rs = pst.executeQuery();
            int count = 0;
 
            while (rs.next()){
                int id = rs.getInt(1);
                int sourcebranch = rs.getInt(2);
                int destBranch = rs.getInt(3);
                String date = rs.getString(4);
                String status = rs.getString(5);
                int vehicle = rs.getInt(6);
                int user = rs.getInt(7);
                String sourcebranchName = rs.getString(8);
                //String vehiclePlate = rs.getString(9);
                
                result.add(new ProductRequest(id,sourcebranch,destBranch,date,status,vehicle,user));

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
    public boolean UpdateProductRequestHeader(String status, int id, int vehicle) {
         boolean result=false;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            
            pst = connection.prepareStatement("call requestStatusUpdate(?,?,?) ;");
            pst.setString(3, status);
            pst.setInt(2, vehicle);
            pst.setInt(1, id);
            
            pst.executeUpdate();  
            result= true;
              
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
    
    
}
