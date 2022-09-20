
package com.cab.dao;

import com.cab.models.Branch;
import com.cab.models.Driver;
import com.cab.models.Vehicle;
import com.cab.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class TransportDAO implements ITransportDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;
    Connection connection = null;
    boolean status = false;
    
    @Override
    public int CreateVehicle(Vehicle vehicle) {
       int result= 0;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("INSERT INTO vehicle ( `plate_number`, `chassis_number`, `mileage`, `fuel`, `transmission`, `branch`, `status`,`adate`) VALUES (?, ?,?,?,?, ?, ?,?);", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, vehicle.getPlate());
            pst.setString(2, vehicle.getChassisNo());
            pst.setFloat(3, vehicle.getMileage());
            pst.setString(4, vehicle.getFuel());
            pst.setString(5, vehicle.getTransmission());
            pst.setInt(6, vehicle.getBranch());
            pst.setInt(7, vehicle.getStatus());
            pst.setString(8, vehicle.getAdate());
            
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
    public boolean DeleteVehicle(int branchId) {
       boolean result=false;
        try
        {
            this.DeleteAppropiateAssignmentOfVehicleDriver(branchId, 0);
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("Delete from vehicle where `Id` = ?;");
            
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
    public boolean EditVehicle(Vehicle vehicle) {
         boolean result=false;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("Update vehicle set  `plate_number` =?, `chassis_number`=?, `mileage`=?, `fuel`=?, `transmission`=?, `branch`=?, `status`=? , `adate`=? where `Id`=?;");
            pst.setString(1, vehicle.getPlate());
            pst.setString(2, vehicle.getChassisNo());
            pst.setFloat(3, vehicle.getMileage());
            pst.setString(4, vehicle.getFuel());
            pst.setString(5, vehicle.getTransmission());
            pst.setInt(6, vehicle.getBranch());
            pst.setInt(7, vehicle.getStatus());
            pst.setString(8, vehicle.getAdate());
            pst.setInt(9, vehicle.getId());            
            
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
    public ArrayList<Vehicle> GetAllVehiclesUnderBranch(int branchId) {
        ArrayList<Vehicle> result= new ArrayList<Vehicle>();
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("Select * from vehicle where branch=?;");
            pst.setInt(1, branchId);
           
            rs = pst.executeQuery();
            int count = 0;
 
            while (rs.next()){
                int id = rs.getInt(1);
                String plate = rs.getString(2);
                String chassis = rs.getString(3);
                float mileage = rs.getFloat(4);
                String fuel = rs.getString(5);
                String trnsmission = rs.getString(6);
                int branch = rs.getInt(7);
                int status = rs.getInt(8);
                String date = rs.getString(9);
            
                result.add(new Vehicle(id,plate, chassis,mileage,fuel,trnsmission,branch,status,0,date));

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
    public ArrayList<Vehicle> GetAllVehiclesUnderBranchFree(int branchId) {
       ArrayList<Vehicle> result= new ArrayList<Vehicle>();
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("Select * from vehicle where branch=? and status = 0;");
            pst.setInt(1, branchId);
           
            rs = pst.executeQuery();
            int count = 0;
 
            while (rs.next()){
                int id = rs.getInt(1);
                String plate = rs.getString(2);
                String chassis = rs.getString(3);
                float mileage = rs.getFloat(4);
                String fuel = rs.getString(5);
                String trnsmission = rs.getString(6);
                int branch = rs.getInt(7);
                int status = rs.getInt(8);
                String date = rs.getString(9);
            
                result.add(new Vehicle(id,plate, chassis,mileage,fuel,trnsmission,branch,status,0,date));

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
    public ArrayList<Vehicle> GetAllVehiclesUnderBranchHasNoDriver(int branchId) {
       ArrayList<Vehicle> result= new ArrayList<Vehicle>();
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("SELECT * FROM vehicle as T1 where T1.branch=? and not exists\n" +
            "(select * from vehicle_intersect as T2 where T1.Id = T2.vehicle);");
            pst.setInt(1, branchId);
           
            rs = pst.executeQuery();
            int count = 0;
 
            while (rs.next()){
                int id = rs.getInt(1);
                String plate = rs.getString(2);
                String chassis = rs.getString(3);
                float mileage = rs.getFloat(4);
                String fuel = rs.getString(5);
                String trnsmission = rs.getString(6);
                int branch = rs.getInt(7);
                int status = rs.getInt(8);
                String date = rs.getString(9);
            
                result.add(new Vehicle(id,plate, chassis,mileage,fuel,trnsmission,branch,status, 0, date));

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
    public Vehicle GetVehicleById(int branchId) {
      ArrayList<Vehicle> result= new ArrayList<Vehicle>();
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("Select * from vehicle where Id=? ;");
            pst.setInt(1, branchId);
           
            rs = pst.executeQuery();
            int count = 0;
 
            while (rs.next()){
                int id = rs.getInt(1);
                String plate = rs.getString(2);
                String chassis = rs.getString(3);
                float mileage = rs.getFloat(4);
                String fuel = rs.getString(5);
                String trnsmission = rs.getString(6);
                int branch = rs.getInt(7);
                int status = rs.getInt(8);
                String date = rs.getString(9);
            
                result.add(new Vehicle(id,plate, chassis,mileage,fuel,trnsmission,branch,status, 0,date));

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
        if(result.size() >0 ) return result.get(0); 
        else return null;
    }
    
    public boolean DeleteAppropiateAssignmentOfVehicleDriver( int vehicleId, int driverId)
    {
        boolean result=false;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("DELETE FROM vehicle_intersect WHERE vehicle=? and Id !=0 or driver =? and Id !=0;");
            
            pst.setInt(1, vehicleId);
            pst.setInt(2, driverId);
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
    public int AssignDriver(int branchId, int vehicleId, int driverId) {
        int result= 0;
        DeleteAppropiateAssignmentOfVehicleDriver(vehicleId,driverId);
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("INSERT INTO vehicle_intersect ( `vehicle`, `driver`, `branch`) VALUES (?, ?,?);");
            pst.setInt(1,vehicleId );
            pst.setInt(2, driverId);
            pst.setInt(3, branchId);
            
           
            result = pst.executeUpdate();
            
              
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
    public int CreateDriverProfile(Driver driver) {
         int result= 0;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("INSERT INTO driver ( `full_name`, `address`, `contact`, `nic`, `branch_id`) VALUES (?, ?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, driver.getFullName());
            pst.setString(2, driver.getAddress());
            pst.setString(3, driver.getContact());
            pst.setString(4, driver.getNIC());
            pst.setInt(5, driver.getBranchId());
            
           
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
    public boolean DeleteDriverProfile(int driverId) {
    boolean result=false;
        try
        {
            this.DeleteAppropiateAssignmentOfVehicleDriver(0, driverId);
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("Delete from driver where Id = ?;");
            
            pst.setInt(1, driverId);
           
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
    public boolean EditDriver(Driver driver) {
        boolean result=false;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("Update driver set  `full_name`=?, `address`=?, `contact`=?, `nic`=?, `branch_id`=? where `Id`=?;");
            pst.setString(1, driver.getFullName());
            pst.setString(2, driver.getAddress());
            pst.setString(3, driver.getContact());
            pst.setString(4, driver.getNIC());
            pst.setInt(5, driver.getBranchId());
            pst.setInt(6, driver.getId());
            
            
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
    public ArrayList<Driver> GetAllDriversUnderBranch(int branchId) {
         ArrayList<Driver> result= new ArrayList<Driver>();
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("SELECT * FROM driver where branch_id=?;");
            pst.setInt(1, branchId);
           
            rs = pst.executeQuery();
            int count = 0;
 
            while (rs.next()){
                int id = rs.getInt(1);
                String fullname = rs.getString(2);
                String address = rs.getString(3);
                String contact = rs.getString(4);
                String nic = rs.getString(5);               
                int branch = rs.getInt(6);
     
                result.add(new Driver(id,fullname,address,nic,contact,branch));

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
    public ArrayList<Driver> GetAllDriversUnderBranchHasNoVehicle(int branchId) {
       // SELECT * FROM sales.driver as T1 where not exists (select * from gocheeta.vehicle_intersect as T2 where T1.Id = T2.driver) ;
        ArrayList<Driver> result= new ArrayList<Driver>();
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("SELECT * FROM sales.driver as T1 where T1.branch_id=? and not exists (select * from gocheeta.vehicle_intersect as T2 where T1.Id = T2.driver);");
            pst.setInt(1, branchId);
           
            rs = pst.executeQuery();
            int count = 0;
 
            while (rs.next()){
                int id = rs.getInt(1);
                String fullname = rs.getString(2);
                String address = rs.getString(3);
                String contact = rs.getString(4);
                String nic = rs.getString(5);               
                int branch = rs.getInt(6);
     
                result.add(new Driver(id,fullname,address,nic,contact,branch));

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
    public Driver GetBranchById(int branchId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int GetVehicleForDriver(int id) {
       int result= 0;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("Select T2.vehicle from  vehicle_intersect T2  where T2.driver=?;");
            pst.setInt(1, id);
           
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
         return result;
    }

    @Override
    public int GetDriverForVehicle(int id) {
        int result= 0;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("Select T2.driver from  gocheeta.vehicle_intersect T2  where T2.vehicle=?;");
            pst.setInt(1, id);
           
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
         return result;
    }
    
}
