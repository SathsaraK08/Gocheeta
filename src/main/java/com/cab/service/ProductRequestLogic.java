
package com.cab.service;

import com.cab.dao.*;
import com.cab.models.Branch;
import com.cab.models.Product;
import com.cab.models.ProductRequest;
import com.cab.models.ProductRequestDetail;
import com.cab.models.SalesDetail;
import com.cab.utils.MailSender;

import java.util.ArrayList;


public class ProductRequestLogic implements IProductRequestLogic{

    @Override
    public boolean LogRequests(ProductRequest pr) {
       boolean result= false;
        IProductRequestDAO productRequestDAO = new ProductRequestDAO();
        int HeaderId = productRequestDAO.CreateProductRequestHeader(pr);
        
        if(HeaderId > 0)
        {
            for (int i = 0; i < pr.getObjs().size() ; i++) {
               ProductRequestDetail temp = pr.getObjs().get(i);
               temp.setRequestId(HeaderId);
               result =productRequestDAO.CreateProductRequestDetail(temp);
               if(!result)
               {
                   break;
               }
            }
        }
        else{
            return result;
        }
        return result;   
    }

    @Override
    public ArrayList<ProductRequest> GetRequestsByBranch(int i) {
       IProductRequestDAO productRequestDAO = new ProductRequestDAO();
       IProductDAO productDAO = new ProductDAO();
       IBranchDAO branchDAO = new BranchDAO();
       ITransportDAO transportDAO = new TransportDAO();
       ArrayList<ProductRequest> list= productRequestDAO.GetProductRequestsUnderBranch(i);
        for (int j = 0; j < list.size(); j++) {
            list.get(j).setObjs(productRequestDAO.GetProductRequestsDetaisUnderRequest(list.get(j).getId()));
            list.get(j).setSourceBranchObj(branchDAO.GetBranchById(list.get(j).getSourceBranch()));
            list.get(j).setVehicleObj(transportDAO.GetVehicleById(list.get(j).getVehicle()));
            
           for (int j2 = 0; j2 < list.get(j).getObjs().size(); j2++) {
                        
//
               ArrayList<Product> listObjs=new ArrayList<Product>();
               int temp=list.get(j).getObjs().get(j2).getProductId();
               
               listObjs.add(productDAO.GetProductById( temp));
               list.get(j).getObjs().get(j2).setProductObj(  listObjs  );
           }
           
        }
       return list;
    }

    @Override
    public ArrayList<ProductRequest> GetRequestsByBranchReceived(int i) {
       IProductRequestDAO productRequestDAO = new ProductRequestDAO();
       IProductDAO productDAO = new ProductDAO();
       IBranchDAO branchDAO = new BranchDAO();
       ITransportDAO transportDAO = new TransportDAO();
       ArrayList<ProductRequest> list= productRequestDAO.GetProductRequestsUnderBranchReceived(i);
        for (int j = 0; j < list.size(); j++) {
            list.get(j).setObjs(productRequestDAO.GetProductRequestsDetaisUnderRequest(list.get(j).getId()));
            list.get(j).setSourceBranchObj(branchDAO.GetBranchById(list.get(j).getDestinationBranch()));
            list.get(j).setVehicleObj(transportDAO.GetVehicleById(list.get(j).getVehicle()));
            
           for (int j2 = 0; j2 < list.get(j).getObjs().size(); j2++) {
               ArrayList<Product> listObjs=new ArrayList<Product>();
               listObjs.add(productDAO.GetProductById(list.get(j).getObjs().get(j2).getProductId()) );
               list.get(j).getObjs().get(j2).setProductObj(  listObjs  );
           }
           
        }
       return list;
    }

    @Override
    public boolean UpdateProductRequestHeader(String status, int id, int vehic1) {
       IProductRequestDAO productRequestDAO = new ProductRequestDAO();
       return productRequestDAO.UpdateProductRequestHeader(status, id, vehic1); 
    }

   

    @Override
    public boolean StateRequest(int ProductRequest, int SourceBranch, int DestBrnch) {
         IProductRequestDAO productRequestDAO = new ProductRequestDAO();
         IBranchDAO branchDAO= new BranchDAO();
         IProductDAO productDAO = new ProductDAO();
       ISalesDAO salesDAO = new SalesDAO();
       Branch brnch= branchDAO.GetBranchById(SourceBranch);
       Branch dest =branchDAO.GetBranchById(DestBrnch);
       String EmailContent="Your Product Request is Accepted By "+brnch.getName();
       boolean result = false;
       ArrayList<ProductRequestDetail> details=productRequestDAO.GetProductRequestsDetaisUnderRequest(ProductRequest);
        for (int i = 0; i < details.size(); i++) {
           Product product=productDAO.GetProductById(details.get(i).getProductId());
           EmailContent= EmailContent+ "\r\n"+product.getProductName() +" -"+ details.get(i).getQty()+ product.getMeasure();
            if( salesDAO.RetreiveAvailableQuantity(SourceBranch, details.get(i).getProductId()) > details.get(i).getQty())
           {
               result = true;
           }
           else
           {
               result = false;
               break;
           }
        }
        if(result) MailSender.sendMailTextContent(dest.getEmail(), EmailContent, "Product Status Changed");
        return result;
    }

   
}
