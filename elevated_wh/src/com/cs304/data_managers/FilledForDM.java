package com.cs304.data_managers;

import com.cs304.data_objects.Filled_For;

import java.sql.SQLException;
import java.util.ArrayList;

public class FilledForDM {

    ArrayList<Filled_For> ff;
    ConnectionManager cm;

    public FilledForDM() {
        ff = null;
        cm = new ConnectionManager();
    }

    /**
     * for a given prodID, return Stock product
     * @param prodID
     * @return Stockproduct
     */

    public int getStockProd4ProdID(String prodID) {
        String getStockProdQuery = "SELECT * FROM Product WHERE prodID = " + prodID;

        String[][] getProdStock = new String[0][];

        try {
            getProdStock = cm.submitQuery(getStockProdQuery);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        int stockProd = Integer.parseInt(getProdStock[1][5]);
        return stockProd;
    }

    public int insertNewFilledFor(String prodID, String orderID, String numfilled, String isShipped) {
        String getNumProdQuery = "SELECT numProd FROM Reserves WHERE orderID = "+ orderID;
        String getPreviouslyNumProdQuery ="SELECT r.prodID, p.prodName, r.numProd, SUM(f.numFilled) FROM Product p, Reserves r LEFT JOIN Filled_For f ON r.prodID = f.prodID WHERE r.orderID = "
                + orderID+
                " AND f.orderID =" + orderID+
                " AND r.prodID = p.PRODID AND p.prodID =" +prodID+
                " GROUP BY r.prodID, r.numProd, p.prodName ORDER BY r.prodID";
        String[][] getPreviouslyNumProd =new String[0][];

        try {
            getPreviouslyNumProd = cm.submitQuery(getPreviouslyNumProdQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String previouslyNumProd = getPreviouslyNumProd[1][2];

        String[][] numProdArray = new String[0][];

        int result;
        try {
            numProdArray = cm.submitQuery(getNumProdQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String numProdStr = numProdArray[1][2];
        int numProdInt = Integer.parseInt(numProdStr);
        int numfilledInt = Integer.parseInt(numfilled);

        int stockProd = this.getStockProd4ProdID(prodID);
        int numProdPreviously = Integer.parseInt(previouslyNumProd);

        if (numProdInt >= numfilledInt && stockProd >= (numProdInt + numProdPreviously)){
            String sqlCmd = "insert into Filled_For(dateupdated,prodID,orderID,numFilled,isShipped) " +
                    "values(TO_DATE('19-NOV-16 12:56 PM','DD-MON-YY HH:MI PM')," +
                    prodID + "," +
                    orderID + "," +
                    numfilled + "," +
                    isShipped + ")";
            result = cm.executeStatement(sqlCmd);
            return result;
        }

        else {
            // TODO: implement the exception that triggers an error popup in the UI
            int error = -1;
            return error;
        }

    }

    /**
     * Find the average number of products in all orders
     * @return
     */

    public int getAVGNumProd4Orders(String prodID) {
        String getQuery = "SELECT AVG(numOfProds) FROM (SELECT ff.orderID , SUM(ff.prodID) AS numOfProds FROM  Filled_For ff GROUP BY ff.orderID)";

        String[][] getAVGNumProds = new String[0][];

        try {
            getAVGNumProds = cm.submitQuery(getQuery);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        int stockProd = Integer.parseInt(getAVGNumProds[1][0]);
        return stockProd;
    }

    /**
     * Find the average number of orders for all customers
     * @return
     */

    public int getAVGNumOrders4Customers(String prodID) {
        String getQuery = "SELECT AVG(numOfProds) FROM (SELECT ff.orderID , SUM(ff.prodID) AS numOfProds FROM  Filled_For ff GROUP BY ff.orderID)";

        String[][] getAVGNumOrders = new String[0][];

        try {
            getAVGNumOrders = cm.submitQuery(getQuery);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        int stockProd = Integer.parseInt(getAVGNumOrders[1][0]);
        return stockProd;
    }


    public String[][] getAllFilledFor() {
        String sqlQuery = "SELECT * FROM Filled_For";
        String[][] result = new String[1][1];
        try {
            result = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String[][] getFilledForByProductID(String prodID) {
        String sqlQuery = "SELECT * FROM Filled_For WHERE productID=\'"+prodID+"\'";
        String[][] result = new String[1][1];
        try {
            result = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * for a given order number, give the product IDs on that order and the total amount of that product
     * @param orderID
     * @return
     */

    public String[][] getNumProdPlusProdID4Order(String orderID) {
        String sqlQuery = "SELECT ff.prodID, SUM(ff.numFilled) FROM Filled_For ff WHERE ff.orderID ="+orderID+" GROUP BY ff.orderID, ff.prodID;";
        String[][] result = new String[1][1];
        try {
            result = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Get the total cost of an order
     * @param orderID
     * @return
     */

    public String[][] getFilledForByOrderID(String orderID) {
        String sqlQuery = "SELECT * FROM Filled_For WHERE orderID=\'"+orderID+"\'";
        String[][] result = new String[1][1];
        try {
            result = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * HELPER:  increases products in filled for relationship
     * @param prodID
     * @param quantity
     * @return
     */
    public int increaseProdsOfFilled_For(String prodID, String quantity) {
        String sqlCmd = "UPDATE Filled_For SET numFilled = numFilled + " + quantity + "WHERE prodID=" + prodID;
        int result = cm.executeStatement(sqlCmd);
        return result;
    }

}
