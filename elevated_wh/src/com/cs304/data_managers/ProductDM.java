package com.cs304.data_managers;
import com.cs304.data_objects.*;
import java.util.ArrayList;
import java.sql.ResultSet;

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

    public int addNewProductToWarehouse(String name, String size, String unit, String price) {
        String sqlCmd = "insert into Product(prodID, prodName, prodSize, prodUnit, prodPrice, stockProduct) "+
                "values(product_counter.nextval,\'" + name + "\'," + size + ",\'" + unit + "\'," + price+")";
        cm.connectToDb();
        int result = cm.executeStatement(sqlCmd);
        return result;
    }

    public int addProductStock(String prodID, String quantity) {
        String sqlCmd = "UPDATE Product SET stockProduct = stockProduct + " + quantity + "WHERE prodID=" + prodID;
        cm.connectToDb();
        int result = cm.executeStatement(sqlCmd);
        return result;
    }

    



}
