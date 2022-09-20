
package com.cab.dao;

import com.cab.models.Branch;
import com.cab.models.Product;
import com.cab.models.ProductType;
import com.cab.models.Return;
import com.cab.models.ReturnsSummary;
import com.cab.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductDAO implements IProductDAO {
    
    PreparedStatement pst = null;
    ResultSet rs = null;
    Connection connection = null;
    boolean status = false;
    
    @Override
    public boolean CreateProductType(ProductType productType) {
         boolean result=false;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("INSERT INTO product_type ( `product_type`,`description`) VALUES (?,?);");
            pst.setString(1, productType.getType());
            pst.setString(2, productType.getDescription());
           
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
              
                
                  result = true;                 
                
            
            }  
        }
        catch (Exception e) {
            e.printStackTrace();
            
        }

        finally {
        	if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           
        }
        return result;
    }

    @Override
    public boolean UpdateProductType(ProductType productType) {
        boolean result=false;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("Update product_type set  `product_type` =?, `description`=? where `Id`=?;");
            pst.setString(1, productType.getType());
            pst.setString(2, productType.getDescription());
            pst.setInt(3, productType.getId());
            
            
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                result= true;
            }  
        }
        catch (Exception e) {
            e.printStackTrace();
            result = false;
        }

        finally {
        	if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           
        }
        return result;  
    }

    @Override
    public boolean DeleteProductType(int productType) {
        boolean result=false;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("Delete from product_type where `Id` = ?;");
            
            pst.setInt(1, productType);
           
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                result= true;
            }  
        }
        catch (Exception e) {
            e.printStackTrace();
            result = false;
        }

        finally {
        	if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           
        }
        return result;
    }

    @Override
    public ProductType GetTypeById(int id) {
       ArrayList<ProductType> result= new ArrayList<ProductType>();
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("Select * from product_type where Id=?;");
            pst.setInt(1, id);
           
            rs = pst.executeQuery();
            int count = 0;
 
            while (rs.next()){
                int Typeid = rs.getInt(1);
                String type = rs.getString(2);
                String desc = rs.getString(3);
            
                result.add(new ProductType(Typeid,type,desc));

            } 
        }
        catch (Exception e) {
            e.printStackTrace();
            
        }

        finally {
        	if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           
        }
        if(result.size()> 0)return result.get(0);
        else return null;
    }

    @Override
    public ArrayList<ProductType> GetAllTypes() {
        ArrayList<ProductType> result= new ArrayList<ProductType>();
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("Select * from product_type;");
            
           
            rs = pst.executeQuery();
            int count = 0;
 
            while (rs.next()){
                int Typeid = rs.getInt(1);
                String type = rs.getString(2);
                String desc = rs.getString(3);
            
                result.add(new ProductType(Typeid,type,desc));

            } 
        }
        catch (Exception e) {
            e.printStackTrace();
            
        }

        finally {
        	if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           
        }  
        return result;
    }

    @Override
    public int CreateProduct(Product product) {
        int result=0;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("INSERT INTO product ( `Name`,`Description`,`TypeId`,`UnitPrice`,`Measure`) VALUES (?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, product.getProductName());
            pst.setString(2, product.getDescription());
            pst.setInt(3, product.getTypeId());
            pst.setFloat(4, product.getUnitPrice());
            pst.setString(5, product.getMeasure());
           
            int rowsInserted = pst.executeUpdate();
            
            if (rowsInserted > 0) {
                rs = pst.getGeneratedKeys();
                if (rs.next()) {
                  result = rs.getInt(1);                 
                }
                
            } 
        }
        catch (Exception e) {
            e.printStackTrace();
            
        }

        finally {
        	if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           
        }
        return result;
    }

    @Override
    public boolean UpdateProductDetails(Product product) {
     boolean result=false;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("Update product set  `Name`=?,`Description`=?,`TypeId`=?,`UnitPrice`=?,`Measure`=? where `Id`=?;");
            pst.setString(1, product.getProductName());
            pst.setString(2, product.getDescription());
            pst.setInt(3, product.getTypeId());
            pst.setFloat(4, product.getUnitPrice());
            pst.setString(5, product.getMeasure());
            pst.setInt(6, product.getId());
            
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                result= true;
            }  
        }
        catch (Exception e) {
            e.printStackTrace();
            result = false;
        }

        finally {
        	if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           
        }
        return result;    
    }

    @Override
    public boolean DeleteProduct(int id) {
        boolean result=false;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("Delete from product where `Id` = ?;");
            
            pst.setInt(1, id);
           
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                result= true;
            }  
        }
        catch (Exception e) {
            e.printStackTrace();
            result = false;
        }

        finally {
        	if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           
        }
        return result;
    }

    @Override
    public Product GetProductById(int i) {
        System.out.println("product Id -"+ i);
        Product result= null;
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("select t1.*, t2.product_type from product t1 inner join product_type t2 on t1.TypeId = t2.Id where t1.Id=?;");
             pst.setInt(1, i);
           
            rs = pst.executeQuery();
            int count = 1;
 
            while (rs.next()){
                if(count==1){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String descripton = rs.getString(3);
                int typeId = rs.getInt(4);
                float unitPrice = rs.getFloat(5);
                String measure = rs.getString(6);
                String typeName = rs.getString(7);
            
                result =new Product(id,typeId,name,descripton,unitPrice,measure,typeName);
                }
            } 
        }
        catch (Exception e) {
            e.printStackTrace();
            
        }

        finally {
        	if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           
        }  
        return result;
    
    }

    @Override
    public ArrayList<Product> GetProductsUnderBranch(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Product> GetAllProducts(int branch) {
        ArrayList<Product> result= new ArrayList<Product>();
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("select t1.*, t2.product_type, t3.quantity from product t1 inner join product_type t2 on t1.TypeId = t2.Id inner join stores t3 on t1.Id = t3.product where t3.branch = ?;");
            pst.setInt(1, branch);
           
            rs = pst.executeQuery();
            int count = 0;
 
            while (rs.next()){
                
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String descripton = rs.getString(3);
                int typeId = rs.getInt(4);
                float unitPrice = rs.getFloat(5);
                String measure = rs.getString(6);
                String typeName = rs.getString(7);
                Product productobj = new Product(id,typeId,name,descripton,unitPrice,measure,typeName);
                productobj.setAvailbleUnits(rs.getInt(8));
                result.add(productobj);

            } 
        }
        catch (Exception e) {
            e.printStackTrace();
            
        }

        finally {
        	if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           
        }  
        return result;
    }

    @Override
    public int CreateUpdateReturn(Return ReturnObj) {
         int result=0;
        try
        {
            String query ="CALL PrcReturns(?,?,?);";
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement(query);
            pst.setInt(1, ReturnObj.getBranch());
            pst.setInt(2, ReturnObj.getProduct());
            pst.setInt(3, ReturnObj.getQty());
            
           
            result = pst.executeUpdate();
            
        }
        catch (Exception e) {
            e.printStackTrace();
            
        }

        finally {
        	if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           
        }
        return result;
    }

    @Override
    public ArrayList<ReturnsSummary> GetReturnsByProducts() {
        ArrayList<ReturnsSummary> result= new ArrayList<ReturnsSummary>();
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("select distinct T1.product, sum(T1.qty), T2.Name from returns T1 inner join product T2 on T1.product= T2.Id group by T1.product;");
            //pst.setInt(1, branch);
           
            rs = pst.executeQuery();
            int count = 0;
 
            while (rs.next()){
                String productName = rs.getString(3);
                int product = rs.getInt(1);
                int qty = rs.getInt(2);
                
                ReturnsSummary returnObj = new ReturnsSummary(product,qty,productName);
                result.add(returnObj);

            } 
        }
        catch (Exception e) {
            e.printStackTrace();
            
        }

        finally {
        	if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           
        }  
        return result;
    }

    @Override
    public ArrayList<Product> GetAllProductsNew() {
        ArrayList<Product> result= new ArrayList<Product>();
        try
        {
            
            connection = DBConnection.getInstance().connection;        
            pst = connection.prepareStatement("select t1.*, t2.product_type from product t1 inner join product_type t2 on t1.TypeId = t2.Id ;");
            
           
            rs = pst.executeQuery();
            int count = 0;
 
            while (rs.next()){
                
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String descripton = rs.getString(3);
                int typeId = rs.getInt(4);
                float unitPrice = rs.getFloat(5);
                String measure = rs.getString(6);
                String typeName = rs.getString(7);
                Product productobj = new Product(id,typeId,name,descripton,unitPrice,measure,typeName);
                //productobj.setAvailbleUnits(rs.getInt(8));
                result.add(productobj);

            } 
        }
        catch (Exception e) {
            e.printStackTrace();
            
        }

        finally {
        	if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           
        }  
        return result;
    }
    
}
