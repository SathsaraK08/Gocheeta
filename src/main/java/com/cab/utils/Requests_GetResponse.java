
package com.cab.utils;

import java.util.ArrayList;

import com.cab.models.Branch;
import com.cab.models.Customer;
import com.cab.models.Product;
import com.cab.models.ProductCompressed;


public class Requests_GetResponse {
      private ArrayList<Product> products;
      private ArrayList<Branch> branches;

    public Requests_GetResponse(ArrayList<Product> products, ArrayList<Branch> branches) {
        this.products = products;
        this.branches = branches;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public void setBranches(ArrayList<Branch> branches) {
        this.branches = branches;
    }
      
      
}
