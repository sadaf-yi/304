package com.cs304.data_managers;

import com.cs304.data_objects.*;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cs304.data_objects.Placed_For;

/**
 * Created by tyh0 on 2016-11-21.
 */
public class PlacedForDM {
    ArrayList<Placed_For> pf;
    ConnectionManager cm;

    public PlacedForDM() {
        pf = null;
        cm = new ConnectionManager();
    }

    public int insertPlacedFor(String orderID, String custID) {
        String sqlCmd = "INSERT INTO Placed_For(orderID,custID) VALUES(" + orderID + "," + custID +")";
        cm.connectToDb();
        int result = cm.executeStatement(sqlCmd);
        return result;
    }

    public String[][] getAllPlacedFor() {
        String sqlQuery = "SELECT * FROM Placed_For";
        cm.connectToDb();
        String[][] result = new String[1][1];
        try {
            result = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String[][] getPlacedForByOrderID(String orderID) {
        String sqlQuery = "SELECT * FROM Placed_For WHERE orderID="+orderID;
        cm.connectToDb();;
        String[][] result = new String[1][1];
        try {
            result = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
