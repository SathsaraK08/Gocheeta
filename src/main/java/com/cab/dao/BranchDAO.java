
package com.cab.dao;

import com.cab.models.Branch;
import com.cab.models.DualBranchLocation;
import com.cab.models.SystemUser;
import com.cab.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class BranchDAO implements IBranchDAO{

    PreparedStatement pst = null;
    ResultSet rs = null;
    Connection connection = null;
    boolean status = false;
    @Override
    public boolean CreateBranch(Branch branch) {
        
        boolean result=false;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("INSERT INTO branch ( `name`, `city`, `address`, `type`, `phone`, `email`, `longtitude`, `latitude`) VALUES (?, ?,?,?,?, ?, ? , ?);");
            pst.setString(1, branch.getName());
            pst.setString(2, branch.getCity());
            pst.setString(3, branch.getAddress());
            pst.setString(4, branch.getType());
            pst.setString(5, branch.getContact());
            pst.setString(6, branch.getEmail());
            pst.setString(7, branch.getLongtitude());
            pst.setString(8, branch.getLatitude());
           
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
    public boolean DeleteBranch(int branchId) {
        boolean result=false;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("Delete from branch where `Id` = ?;");
            
            pst.setInt(1, branchId);
           
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
    public boolean EditBranch(Branch branch) {
         boolean result=false;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("Update branch set  `name` =?, `city`=?, `address`=?, `type`=?, `phone`=?, `email`=?, `longtitude`=?, `latitude`=? where `Id`=?;");
            pst.setString(1, branch.getName());
            pst.setString(2, branch.getCity());
            pst.setString(3, branch.getAddress());
            pst.setString(4, branch.getType());
            pst.setString(5, branch.getContact());
            pst.setString(6, branch.getEmail());
            pst.setString(7, branch.getLongtitude());
            pst.setString(8, branch.getLatitude());
            pst.setInt(9, branch.getId());
            
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
    public ArrayList<Branch> GetAllSubBranches() {
        ArrayList<Branch> result= new ArrayList<Branch>();
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("Select * from branch where type='Sub';");
            
           
            rs = pst.executeQuery();
            int count = 0;
 
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String city = rs.getString(3);
                String address = rs.getString(4);
                String type = rs.getString(5);
                String phone = rs.getString(6);
                String email = rs.getString(7);
                String longtitude = rs.getString(8);
                String latitude = rs.getString(9);
            
                result.add(new Branch(id,name,city,longtitude, latitude,address, phone,email,type));

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
    public Branch GetBranchById(int branchId) {
        ArrayList<Branch> result= new ArrayList<Branch>();
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("Select * from branch where Id=?;");
            pst.setInt(1, branchId);
           
            rs = pst.executeQuery();
            int count = 0;
 
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String city = rs.getString(3);
                String address = rs.getString(4);
                String type = rs.getString(5);
                String phone = rs.getString(6);
                String email = rs.getString(7);
                String longtitude = rs.getString(8);
                String latitude = rs.getString(9);
            
                result.add(new Branch(id,name,city,longtitude, latitude,address, phone,email,type));

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
         if(result.size() > 0) return result.get(0);
         else return null;
    }

    @Override
    public ArrayList<Branch> GetAllBranchesExceptMe(int me) {
       ArrayList<Branch> result= new ArrayList<Branch>();
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("Select * from branch where Id !=?;");
            pst.setInt(1,me);
           
            rs = pst.executeQuery();
            int count = 0;
 
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String city = rs.getString(3);
                String address = rs.getString(4);
                String type = rs.getString(5);
                String phone = rs.getString(6);
                String email = rs.getString(7);
                String longtitude = rs.getString(8);
                String latitude = rs.getString(9);
            
                result.add(new Branch(id,name,city,longtitude, latitude,address, phone,email,type));

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
    public ArrayList<DualBranchLocation> GetLocationsForRequestId(int id) {
       ArrayList<DualBranchLocation> result= new ArrayList<DualBranchLocation>();
      
       String lati1="" ,long1="",lati2="" ,long2 ="";
                 
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("select longtitude, latitude from branch inner join product_request on branch.Id= product_request.source_branch  where product_request.Id = ?;");
            pst.setInt(1,id);
           
            rs = pst.executeQuery();
            int count = 0;
 
            while (rs.next()){
                
                 lati1 = rs.getString(1);
                 long1 = rs.getString(2);
                
               
            } 
            
            pst = connection.prepareStatement("select longtitude, latitude from branch inner join product_request on branch.Id= product_request.destination_branch   where product_request.Id = ?;");
            pst.setInt(1,id);
           
            rs = pst.executeQuery();
            
            while (rs.next()){
                
                 lati2 = rs.getString(1);
                 long2 = rs.getString(2);
            } 
            DualBranchLocation obj= new  DualBranchLocation(lati1 ,long1,lati2 ,long2);
            result.add(obj);
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
