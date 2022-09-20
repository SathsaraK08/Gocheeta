
package com.cab.service;

import java.util.ArrayList;

import com.cab.models.Branch;
import com.cab.models.DualBranchLocation;


public interface IBranchLogic {
    
   boolean CreateSubBranch(Branch branch);
   ArrayList<Branch> GetAllSubBranch();
   boolean UpdateSubBranch(Branch branch);
   boolean DeleteSpecificSubBranch(int branchId);
   Branch GetBranchById(int id);
   ArrayList<Branch> GetAllBranchesExceptMe(int me);
   ArrayList<DualBranchLocation> GetLocationsForRequestId(int id);
}
