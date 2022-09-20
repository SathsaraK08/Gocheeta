
package com.cab.dao;

import java.util.ArrayList;

import com.cab.models.*;


public interface IProductDAO {
    
    boolean CreateProductType(ProductType productType);
    boolean UpdateProductType(ProductType productType);
    boolean DeleteProductType(int productType);
    ProductType GetTypeById(int id);
    ArrayList<ProductType> GetAllTypes();
    
    int CreateProduct(Product product);
    boolean UpdateProductDetails(Product product);
    boolean DeleteProduct(int product);
    Product GetProductById(int id);
    ArrayList<Product> GetProductsUnderBranch(int branchId);
    ArrayList<Product> GetAllProducts(int branch);
    ArrayList<Product> GetAllProductsNew();
    
    int CreateUpdateReturn(Return ReturnObj);
    ArrayList<ReturnsSummary> GetReturnsByProducts();
}
