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

    public String[][] listOrderContent(String orderID) {
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
