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
                "values(product_counter.nextval,\'" + name + "\'," + size + ",\'" + unit + "\'," +price+", 0)";
        int result = cm.executeStatement(sqlCmd);
        return result;
    }

    public int addProductStock(String prodID, String quantity) {
        String sqlCmd = "UPDATE Product SET stockProduct = stockProduct + " + quantity + " WHERE prodID=" + prodID;
        int result = cm.executeStatement(sqlCmd);
        return result;
    }

    /**
     * deletes products by prodID
     * @param prodID
     * @return
     */

    public int deleteProductbyID(String prodID) {
        String sqlCmd = "DELETE FROM Product WHERE prodID=" + prodID;
        int result = cm.executeStatement(sqlCmd);
        return result;
    }

    /**
     * find the cheapest item
     * @param
     * @return
     */

    public String[][] cheapestProd() {
        String sqlQuery = "SELECT a.prodID, a.prodName, a.prodPrice FROM Product a, Product b GROUP BY a.prodID, a.prodName, a.prodPrice HAVING a.prodPrice = MIN(b.prodPrice)";
        String[][] results = new String[0][0];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    /**
     * find the most expensive item
     * @param
     * @return
     */

    public String[][] mostExpensiveProd() {
        String sqlQuery = "SELECT a.prodID, a.prodName, a.prodPrice FROM Product a, Product b GROUP BY a.prodID, a.prodName, a.prodPrice HAVING a.prodPrice = MAX(b.prodPrice)";
        String[][] results = new String[0][0];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    /**
     * find the cheapest product and their recipe ID
     * @param
     * @return
     */

    public String[][] CheapestProdplusRecID() {
        String sqlQuery = "SELECT a.prodID, a.prodName, a.recID, a.prodPrice FROM Recipe4Product a, Recipe4Product b GROUP BY a.prodID, a.prodPrice, a.prodName, a.recID HAVING a.prodPrice = MIN(b.prodPrice)";
        String[][] results = new String[0][0];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    /**
     * find the most expensive product and their recipe ID
     * @param
     * @return
     */

    public String[][] mostExpensiveProdplusRecID() {
        String sqlQuery = "SELECT a.prodID, a.prodName, a.recID, a.prodPrice FROM Recipe4Product a, Recipe4Product b GROUP BY a.prodID, a.prodPrice, a.prodName, a.recID HAVING a.prodPrice = MAX(b.prodPrice)";
        String[][] results = new String[0][0];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }



    /**
     * give the recipe information for a particular prodID
     * @param prodID
     * @return
     */
    public  String[][] listProdRecProc(String prodID) {

        String[][] recipeResult = new String[0][0];

        String sqlQuery = "SELECT recID, recName, prodecure FROM Recipe4Product WHERE prodID =" + prodID;

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
        int result = cm.executeStatement(sqlCmd);
    }

    /**
     * Reserve product
     */
    /**
     * gives recipe information and product information for a particular ProdID
     * @param prodID
     * @return
     */

    public String[][] getRecInfor4Prod(String prodID,String orderID,  String quantity) {
        decreaseProductStock( prodID,  quantity);
        increaseProdsOfFilled_For( prodID, quantity);
        filledForDM.insertNewFilledFor(prodID, orderID, quantity, "0");
        String sqlQuery = "SELECT * FROM Filled_For WHERE prodID =" + prodID;

        String[][] results = new String[0][0];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
