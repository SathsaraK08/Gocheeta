
package com.cab.dao;

import java.util.ArrayList;

import com.cab.models.SystemUser;


public interface IUserDAO {
    SystemUser GetUserById(int Id);
    SystemUser GetUserByEmailPassword(String Email, String Password);
    ArrayList<SystemUser> GetUsersUnderBranch(int branchId);
    boolean UpdateUserDetails(SystemUser systemUser);
    int CreateUserDetails(SystemUser systemUser);
    boolean DeleteUserDetails(int userId);
}
