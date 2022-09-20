
package com.cab.service;

import com.cab.dao.BranchDAO;
import com.cab.dao.IBranchDAO;
import com.cab.dao.ITransportDAO;
import com.cab.dao.IUserDAO;
import com.cab.dao.TransportDAO;
import com.cab.dao.UserDAO;
import com.cab.models.Branch;
import com.cab.models.DualBranchLocation;

import java.util.ArrayList;


public class BranchLogic implements IBranchLogic{

    @Override
    public boolean CreateSubBranch(Branch branch) {
        IBranchDAO branchDAO = new BranchDAO();
        return branchDAO.CreateBranch(branch);
    }

    @Override
    public ArrayList<Branch> GetAllSubBranch() {
        IBranchDAO branchDAO = new BranchDAO();
        return branchDAO.GetAllSubBranches();    
    }

    @Override
    public boolean UpdateSubBranch(Branch branch) {
       IBranchDAO branchDAO = new BranchDAO();
       return branchDAO.EditBranch(branch);
    }

    @Override
    public boolean DeleteSpecificSubBranch(int id) {
       IBranchDAO branchDAO = new BranchDAO();
       return branchDAO.DeleteBranch(id);
    }

    @Override
    public Branch GetBranchById(int id) {
       IBranchDAO branchDAO = new BranchDAO();
       Branch  branch= branchDAO.GetBranchById(id);
       ITransportDAO trnsportDAO = new TransportDAO();      
       branch.setVehicles(trnsportDAO.GetAllVehiclesUnderBranch(id));
       return branch;
    }

    @Override
    public ArrayList<Branch> GetAllBranchesExceptMe(int i) {
        IBranchDAO branchDAO = new BranchDAO();
        return branchDAO.GetAllBranchesExceptMe(i);  
    }

    @Override
    public ArrayList<DualBranchLocation> GetLocationsForRequestId(int i) {
        IBranchDAO branchDAO = new BranchDAO();
        return branchDAO.GetLocationsForRequestId(i); 
    }
    
}
