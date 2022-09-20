
package com.cab.dao;

import java.util.ArrayList;

import com.cab.models.*;


public interface IBranchDAO {
    
    boolean CreateBranch(Branch branch);
    boolean DeleteBranch(int branchId);
    boolean EditBranch(Branch branch);
    ArrayList<Branch>  GetAllSubBranches();
    ArrayList<Branch>  GetAllBranchesExceptMe(int me);
    Branch GetBranchById(int branchId);
    ArrayList<DualBranchLocation> GetLocationsForRequestId(int id);
    
}
