package com.cs304.data_managers;
import com.cs304.data_objects.*;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.util.ArrayList;

import com.cs304.data_objects.Cust_Order;

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

    public int insertNewCustOrderTuple() {
        cm.connectToDb();
        String sqlCmd = "insert into Cust_Order(orderID) values (order_counter.nextval)";
        int result = cm.executeStatement(sqlCmd);
        return result;
    }

    public String[][] getAllOrderTuples() {
        cm.connectToDb();
        String sqlQuery = "SELECT * FROM Cust_Order";
        String[][] results = new String[0][0];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
}