package com.cs304.data_managers;
import com.cs304.data_objects.Product;

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
        String sqlCmd = "insert into Product(prodID, prodName, prodSize, prodUnit, prodPrice, stockProduct) " +
                "values(product_counter.nextval,\'" + name + "\'," + size + ",\'" + unit + "\'," + price + ", 0)";
        int result = cm.executeStatement(sqlCmd);
        return result;
    }

    public int addProductStock(String prodID, String quantity) {

        // TODO: Make logic changes
        String sqlCmd = "UPDATE Product SET stockProduct = stockProduct + " + quantity + " WHERE prodID=" + prodID;
        int result = cm.executeStatement(sqlCmd);
        return result;
    }

    /**
     * deletes products by prodID
     *
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
     *
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
     *
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
     *
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
     *
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
     *
     * @param prodID
     * @return
     */
    public String[][] listProdRecProc(String prodID) {

        String[][] recipeResult = new String[0][0];

        String sqlQuery = "SELECT prodID, recID, recName, procedure FROM Recipe4Product WHERE prodID =" + prodID;

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
     *
     * @param prodID
     * @param quantity
     * @return
     */
    public int decreaseProductStock(String prodID, String quantity) {
        String sqlCmd = "UPDATE Product SET stockProduct = stockProduct - " + quantity + "WHERE prodID=" + prodID;
        int result = cm.executeStatement(sqlCmd);
        return result;
    }

    /**
     * Reserve product
     */
    /**
     * gives recipe information and product information for a particular ProdID
     *
     * @param prodID
     * @return
     */

    public String[][] getRecInfor4Prod(String prodID, String orderID, String quantity) {
        decreaseProductStock(prodID, quantity);
        filledForDM.increaseProdsOfFilled_For(prodID, quantity);
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
     *
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
    
    public String[][] getProductByID(String prodID) {
        String sqlQuery = "select * from Product where prodID=" + prodID;
        String[][] results = new String[0][0];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    /**
     * Nested Query
     * Gives product ID, Name recipe and price for products whose price is lower than average price
     */
    public String[][] getProdsCheaperAVG() {
        String sqlQuery = "SELECT rp1.prodID, rp1.prodName,rp1.recID, rp1.prodPrice FROM Recipe4Product rp1 WHERE rp1.prodPrice < (SELECT AVG(rp2.prodPrice) FROM Recipe4Product rp2)";

        String[][] results = new String[0][0];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    /**
     * Nested Query
     * Gives product ID, Name recipe and price for products whose price is higher than average price
     */
    public String[][] getProdsExpensiverAVG() {

        String sqlQuery = "SELECT rp1.prodID, rp1.prodName,rp1.recID, rp1.prodPrice FROM Recipe4Product rp1 WHERE rp1.prodPrice > (SELECT AVG(rp2.prodPrice) FROM Recipe4Product rp2)";

        String[][] results = new String[0][0];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
}

