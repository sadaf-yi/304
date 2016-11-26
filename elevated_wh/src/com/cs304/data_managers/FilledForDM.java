package com.cs304.data_managers;

import com.cs304.data_objects.Filled_For;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by tyh0 on 2016-11-21.
 */
public class FilledForDM {

    ArrayList<Filled_For> ff;
    ConnectionManager cm;

    public FilledForDM() {
        ff = null;
        cm = new ConnectionManager();
    }

    public int insertNewFilledFor(String prodID, String orderID, String numfilled, String isShipped) {
        String sqlCmd = "insert into Filled_For(dateupdated,prodID,orderID,numFilled,isShipped) "+
                "values(TO_DATE('19-NOV-16 12:56 PM','DD-MON-YY HH:MI PM'),"+
                prodID+","+
                orderID+","+
                numfilled+","+
                isShipped+")";
        int result = cm.executeStatement(sqlCmd);
        return result;
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
        String sqlQuery = "SELECT ff.prodID, SUM(ff.numFilled) FROM Filled_For ff\n" +
                "WHERE ff.orderID ="+orderID+" GROUP BY ff.orderID, ff.prodID;";
        String[][] result = new String[1][1];
        try {
            result = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }



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

    // TODO: call the view that checks the amount of the filled for and for the prod, (get SUM) groub by prodID, orderID
    // so that you

}
