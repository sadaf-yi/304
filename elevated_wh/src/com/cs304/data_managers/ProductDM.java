package com.cs304.data_managers;
import com.cs304.data_objects.*;

import java.sql.SQLException;
import java.util.ArrayList;



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
     * HELPER:  decrease stock product
     * @param prodID
     * @param quantity
     * @return
     */
    public void decreaseProductStock(String prodID, String quantity) {
        String sqlCmd = "UPDATE Product SET stockProduct = stockProduct - " + quantity + "WHERE prodID=" + prodID;
        cm.connectToDb();
        int result = cm.executeStatement(sqlCmd);
    }


    /**
     * HELPER:  increases products in filled for relationship
     * @param prodID
     * @param quantity
     * @return
     */
    public void increaseProdsOfFilled_For(String prodID, String quantity) {
        String sqlCmd = "UPDATE Filled_For SET numFilled = numFilled + " + quantity + "WHERE prodID=" + prodID;
        cm.connectToDb();
        int result = cm.executeStatement(sqlCmd);
    }

    /**
     * Reserve product
     * @param prodID
     * @param orderID
     * @param quantity
     * @return
     */


    public String[][] reserveProducts(String prodID,String orderID,  String quantity) {
        decreaseProductStock( prodID,  quantity);
        increaseProdsOfFilled_For( prodID, quantity);
        filledForDM.insertNewFilledFor(prodID, orderID, quantity, "0");
        String sqlQuery = "SELECT * FROM Filled_For ";

        String[][] results = new String[0][0];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }



     public String[][] getStockProduct(String prodID) {
         String[][] recipeResult = new String[0][0];

         String sqlQuery = "SELECT stockProduct FROM Product WHERE prodID = " + prodID;

         String[][] results = new String[0][1];
         try {
             results = cm.submitQuery(sqlQuery);
         } catch (SQLException e) {
             e.printStackTrace();

         }
         System.out.println(results);
         return results;
     }
    /**
     * gives the list of all products
     * @param
     * @return
     */
    public String[][] listAllProducts() {

        String sqlQuery = "SELECT * FROM Product";

        String[][] results = new String[0][0];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }


}
