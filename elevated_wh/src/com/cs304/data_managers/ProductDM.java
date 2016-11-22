package com.cs304.data_managers;
import com.cs304.data_objects.*;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by tyh0 on 2016-11-20.
 */


    public class ProductDM {
    ArrayList<Product> prods;
    ConnectionManager cm;
    private BuildProductDM build_product;
    private FilledForDM filledForDM;

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



    /**
     * give the recipe information for a particular prodID
     * @param prodID
     * @return
     */
    public  String[][] listProdRecProc(String prodID) {

        String[][] recipeResult = new String[0][0];

        String sqlQuery = "SELECT recID, recName, prodecure FROM Recipe4Product";

        String[][] results = new String[0][0];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return results;
    }

    /**
     * gives recipe information and product information for a particular ProdID
     * @param prodID
     * @return
     */

    public  String[][] getRecInfor4Prod(String prodID) {

        String sqlQuery = "SELECT * FROM Recipe4Product WHERE prodID =" + prodID;

        String[][] results = new String[0][0];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }




}
