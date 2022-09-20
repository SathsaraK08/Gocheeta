
package com.cab.service;

import java.util.ArrayList;

import com.cab.models.SystemUser;


public interface IUserLogic {
    
    SystemUser getUserById(int Id);
    SystemUser getUserByEmailPassword(String Email, String Password);
    ArrayList<SystemUser> GetAllUsersUnderBranch(int branchId);
    boolean RemoveUserFromSystem(int UserId);
    boolean RegisterUserinSystem(SystemUser systemUser);
    boolean UpdateUserinSystem(SystemUser systemUser);
}
