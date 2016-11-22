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

    public String[][] listAllOrders() {
        cm.connectToDb();
        String sqlQuery = "";
        String[][] results = new String[1][1];


        sqlQuery = "SELECT Placed_For.orderID, Customer.custFName, Customer.custLName \n" +
                    "    FROM Customer, Placed_For\n" +
                    "    WHERE Placed_For.custID IN (SELECT c2.custID\n" +
                    "                                FROM Customer c2)";


        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return results;
    }

    public String[][] listOrderContent(String orderID) {
        cm.connectToDb();
        String sqlQuery = "";
        String[][] results = new String[1][1];


        //TODO: write the query for this
        //SELECT p.prodName, f.prodID, SUM(f.numFilled)
//        FROM product p, Filled_For f, Reserves r
//        WHERE p.ProdID = f.ProdID AND r.orderID = f.orderID
//        GROUP BY f.orderID
//        HAVING SUM(f.numFilled) >0;

        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return results;
    }




}