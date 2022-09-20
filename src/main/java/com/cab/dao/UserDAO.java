
package com.cab.dao;

import com.cab.models.SystemUser;
import com.cab.utils.DBConnection;
import com.cab.utils.PasswordHash;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO implements IUserDAO {
    PreparedStatement pst = null;
    ResultSet rs = null;
    Connection connection = null;
    boolean status = false;
    
    @Override
    public SystemUser GetUserById(int Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SystemUser GetUserByEmailPassword(String Email, String Password) {
        SystemUser systemUser = null;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("SELECT * FROM systemuser WHERE Email=?");
            pst.setString(1, Email);
            //pst.setString(2, Password);

            rs = pst.executeQuery();
            int i = 1;
            while (rs.next()) {
              if(i == 1)
              {
                systemUser =new SystemUser(rs.getInt(1),rs.getString(2),rs.getString(5),rs.getString(3), rs.getInt(4),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
                break;
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
        if(systemUser != null)
        {
            if(PasswordHash.getInstance().verifyUserPassword(Password, systemUser.getPassword(), systemUser.getSalt())  )
            return systemUser;     
        }
        
        return null;
        
    }

    @Override
    public ArrayList<SystemUser> GetUsersUnderBranch(int branchId) {
       ArrayList<SystemUser> systemUsers = new ArrayList<SystemUser>();
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("SELECT * FROM systemuser WHERE UserType=?");
            pst.setString(1, "Sales");
            //pst.setString(2, Password);

            rs = pst.executeQuery();
            int i = 1;
            while (rs.next()) {
              
               SystemUser systemUser =new SystemUser(rs.getInt(1),rs.getString(2),rs.getString(5),rs.getString(3), rs.getInt(4),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
               systemUsers.add(systemUser);
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
        
          return systemUsers;   
    
    }

    @Override
    public boolean UpdateUserDetails(SystemUser systemUser) {
       boolean result=false;
        try
        {
            
            //String Password = PasswordHash.getInstance().generateSecurePassword(systemUser.getPassword(), systemUser.getSalt());
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("Update systemuser set `UserName`=?,  `BranchId`=?, `Email`=?, `Contact`=?, `Salt`=?, `UserType`=?, NIC=?, Address=? where `Id`=?;");
            pst.setString(1, systemUser.getUsername());
            
            pst.setInt(2, systemUser.getBranchId());
            pst.setString(3, systemUser.getEmail());
            pst.setString(4, systemUser.getContact());
            pst.setString(5, systemUser.getSalt());
            pst.setString(6, systemUser.getUserType());
            pst.setString(7, systemUser.getNIC());
            pst.setString(8, systemUser.getAddress());
            pst.setInt(9, systemUser.getId());
            ;
           
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
    public int CreateUserDetails(SystemUser systemUser) {
       int result=0;
        try
        {
            String Salt = PasswordHash.getInstance().getSalt(10);
            String Password = PasswordHash.getInstance().generateSecurePassword(systemUser.getPassword(), Salt);
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("INSERT INTO systemuser ( `UserName`, `Password`, `BranchId`, `Email`, `Contact`, `Salt`, `UserType`,`NIC`, `Address`) VALUES (?, ?,?,?,?, ?, ?,?,?);", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, systemUser.getUsername());
            pst.setString(2, Password);
            pst.setInt(3, systemUser.getBranchId());
            pst.setString(4, systemUser.getEmail());
            pst.setString(5, systemUser.getContact());
            pst.setString(6, Salt);
            pst.setString(7, systemUser.getUserType());
            pst.setString(8, systemUser.getNIC());
            pst.setString(9, systemUser.getAddress());
           
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
    public boolean DeleteUserDetails(int userid) {
      boolean result=false;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("Delete from systemuser where `Id` = ?;");
            
            pst.setInt(1, userid);
           
            int rowsProcessed = pst.executeUpdate();
            if (rowsProcessed > 0) {
                result= true;
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
