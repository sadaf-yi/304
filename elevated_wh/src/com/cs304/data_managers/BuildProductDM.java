package com.cs304.data_managers;
import com.cs304.data_objects.*;
import java.util.ArrayList;
import java.sql.ResultSet;
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
