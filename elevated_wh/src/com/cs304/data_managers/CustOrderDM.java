package com.cs304.data_managers;
import com.cs304.data_objects.Cust_Order;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustOrderDM {

    ArrayList<Cust_Order> orders;
    ConnectionManager cm;
    public CustOrderDM() {
        orders = new ArrayList<Cust_Order>();
        cm = new ConnectionManager();
    }

    public int insertNewCustOrderTuple() {
        String cmd1 = "SELECT order_counter.NEXTVAL FROM dual";
        String[][] result1 = new String[0][];
        try {
            result1 = cm.submitQuery(cmd1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int newOrderID = Integer.parseInt(result1[1][0]);
        // result 1 should contain the next sequence number, aka the order number to use
        String sqlCmd = "insert into Cust_Order(orderID) values (" + newOrderID + ")";
        int result = cm.executeStatement(sqlCmd);
        return newOrderID;
    }

    public String[][] getAllPlacedFor() {
        String sqlQuery = "SELECT * FROM Placed_For";
        String[][] results = new String[0][0];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return results;
    }

    public String[][] getAllOrderTuples() {
        String sqlQuery = "SELECT * FROM Cust_Order";
        String[][] results = new String[0][0];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return results;
    }

    public String[][] getAllProdsReserved() {
        String sqlQuery = "SELECT * FROM Cust_Order";
        String[][] results = new String[0][0];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return results;
    }

    /**
     * Ship the item: change the flag on FilledFor (isShipped to 1)
     * @return
     */

    public int shipOrder(String orderID) {
        String sqlCmd = "UPDATE Filled_For SET isShipped = 1 WHERE orderID=" + orderID;
        int result = cm.executeStatement(sqlCmd);
        return result;
    }


//    public String[][] listAllOrders() {
//        String sqlQuery = "";
//        String[][] results = new String[1][1];
//
//
//        sqlQuery = "SELECT Placed_For.orderID, Customer.custFName, Customer.custLName \n" +
//                    "    FROM Customer, Placed_For\n" +
//                    "    WHERE Placed_For.custID IN (SELECT c2.custID\n" +
//                    "                                FROM Customer c2)";
//
//
//        try {
//            results = cm.submitQuery(sqlQuery);
//        } catch (SQLException e) {
//
//            e.printStackTrace();
//        }
//        return results;
//    }
    //TODO pass me

    /**
     * List order by content returns prodID numReserved and SUM(numFilled)
     * @param orderID
     * @return
     */
    public String[][] listOrderContent(String orderID) {
        String sqlQuery = "SELECT r.prodID, r.numProd, SUM(f.numFilled) FROM Reserves r LEFT JOIN Filled_For f ON r.prodID = f.prodID WHERE r.orderID = "+ orderID +" AND f.orderID = "+ orderID +" GROUP BY r.prodID, r.numProd ORDER BY r.prodID";
        String[][] results = new String[1][1];

        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return results;
    }

}
