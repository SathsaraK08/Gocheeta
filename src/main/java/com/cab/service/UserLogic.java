
package com.cab.service;

import com.cab.dao.IUserDAO;
import com.cab.dao.UserDAO;
import com.cab.models.SystemUser;
import com.cab.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UserLogic implements IUserLogic {
    
   
    
    @Override
    public SystemUser getUserById(int Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SystemUser getUserByEmailPassword(String Email, String Password) {
        IUserDAO userDAO = new UserDAO();
        return userDAO.GetUserByEmailPassword(Email, Password);
    }

    @Override
    public ArrayList<SystemUser> GetAllUsersUnderBranch(int branchId) {
        IUserDAO userDAO = new UserDAO();
        return userDAO.GetUsersUnderBranch(branchId);
    }

    @Override
    public boolean RemoveUserFromSystem(int UserId) {
       IUserDAO userDAO = new UserDAO();
       return userDAO.DeleteUserDetails(UserId); 
    }

    @Override
    public boolean RegisterUserinSystem(SystemUser systemUser) {
       IUserDAO userDAO = new UserDAO();
       return userDAO.CreateUserDetails(systemUser) > 0;    
    }

    @Override
    public boolean UpdateUserinSystem(SystemUser systemUser) {
       IUserDAO userDAO = new UserDAO();
       return userDAO.UpdateUserDetails(systemUser);   
    }
    
}
