package com.cs304.data_managers;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cs304.data_objects.Filled_For;


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
        cm.connectToDb();
        int result = cm.executeStatement(sqlCmd);
        return result;
    }

    public String[][] getAllFilledFor() {
        String sqlQuery = "SELECT * FROM Filled_For";
        cm.connectToDb();
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
        cm.connectToDb();
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
        cm.connectToDb();
        String[][] result = new String[1][1];
        try {
            result = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }



}