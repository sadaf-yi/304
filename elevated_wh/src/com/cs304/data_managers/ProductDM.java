package com.cs304.data_managers;
import java.util.ArrayList;

import com.cs304.data_objects.Product;

/**
 * Created by tyh0 on 2016-11-20.
 */
public class ProductDM {
    ArrayList<Product> prods;
    ConnectionManager cm;
    public ProductDM() {
        prods = null;
        cm = new ConnectionManager();
    }
}
