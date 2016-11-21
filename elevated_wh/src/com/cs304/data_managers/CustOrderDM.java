package com.cs304.data_managers;
import com.cs304.data_objects.*;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 * Created by tyh0 on 2016-11-20.
 */
public class CustOrderDM {

    ArrayList<Cust_Order> orders;
    ConnectionManager cm;
    public CustOrderDM() {
        orders = new ArrayList<Cust_Order>();
        cm = new ConnectionManager();
    }

    public String[][] getAllOrderTuples() {
        cm.connectToDb();
        String sqlQuery = "SELECT * FROM Cust_Order";
        String[][] results = cm.submitQuery(sqlQuery);
        return results;
    }



}
