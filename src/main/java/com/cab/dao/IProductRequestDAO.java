
package com.cab.dao;

import java.util.ArrayList;

import com.cab.models.ProductRequest;
import com.cab.models.ProductRequestDetail;


public interface IProductRequestDAO {
   int  CreateProductRequestHeader(ProductRequest productRequest);
   boolean  UpdateProductRequestHeader(String status, int id, int vehicle);
   boolean  CreateProductRequestDetail(ProductRequestDetail productRequestDetail);
   ArrayList<ProductRequest> GetProductRequestsUnderBranch(int branch);
   ArrayList<ProductRequest> GetProductRequestsUnderBranchReceived(int branch);
   ArrayList<ProductRequestDetail> GetProductRequestsDetaisUnderRequest(int request);
}
