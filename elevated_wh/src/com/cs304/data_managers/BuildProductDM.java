package com.cs304.data_managers;
import java.util.ArrayList;

import com.cs304.data_objects.Build_Product;
/**
 * Created by tyh0 on 2016-11-21.
 */
public class BuildProductDM {


    ArrayList<Build_Product> build_products;
    ConnectionManager cm;

    public BuildProductDM() {
        build_products = null;
        cm = new ConnectionManager();
    }

}
