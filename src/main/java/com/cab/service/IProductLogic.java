
package com.cab.service;

import java.util.ArrayList;

import com.cab.models.Product;
import com.cab.models.ProductType;
import com.cab.models.Return;
import com.cab.models.ReturnsSummary;


public interface IProductLogic {
    
    boolean CreateProductType(ProductType productType);
    boolean UpdateProductType(ProductType productType);
    boolean DeleteProductType(int productType);
    ProductType GetTypeById(int id);
    ArrayList<ProductType> GetAllTypes();
    
    boolean CreateProduct(Product product);
    boolean EditProductBasicDetails(Product product);
    boolean DeleteProductFromStores(int productType);
    ArrayList<Product> GetAllProducts(int branchId);
    ArrayList<Product> GetAllProductsUnderBranch(int branchId);
    
    int CreateUpdateReturn(Return ReturnObj);
    ArrayList<ReturnsSummary> GetReturnsByProducts();
    ArrayList<Product> GetAllProductsNew();
}
