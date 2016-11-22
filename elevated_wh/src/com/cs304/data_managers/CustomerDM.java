package com.cs304.data_managers;

import com.cs304.data_objects.*;

import java.sql.SQLException;

import java.util.ArrayList;

import com.cs304.data_objects.Customer;

public class CustomerDM {

    // may need more arraylists to hold data related to customer actions
    ArrayList<Customer> mats;
    ConnectionManager cm;

    public CustomerDM() {
        mats = null;
        cm = new ConnectionManager();
    }

    public void insertCustomer(String firstName, String lastName, String phoneNumber) {
        String sqlCmd =
                "insert into Customer(custID,custFName, custLName, pnum) "+"values(customer_counter.nextval,\'"+firstName+"\',\'"+ lastName +
                "\',\'"+phoneNumber+"\')";
        cm.connectToDb();
        int rowCount = cm.executeStatement(sqlCmd);
    }

    public String[][] findCxByIdOrPhoneNumber(String cid, String name, String pnum) {
        String sqlQuery = "";
        String[][] results = new String[1][1];
        cm.connectToDb();
        if (!cid.equals("")) {
            sqlQuery = "SELECT custID,custFName, custLName, pnum FROM Customer WHERE custID=" + cid;
        } else {
            String fname = name.substring(0, name.indexOf(' '));
            String lname = name.substring(name.indexOf(' ')+1);
            sqlQuery = "SELECT * FROM Customer c " +
                    "WHERE c.custFName = \'" + fname +
                    "\' AND c.custLName = \'" + lname +
                    "\' AND c.pnum = \'" + pnum.replaceAll("[\\s\\-()]", "") + "\'";
        }
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public String[][] listAllCustomers() {
        String sqlQuery = "";
        String[][] results = new String[1][1];
        cm.connectToDb();
        sqlQuery = "SELECT * FROM Customer";

        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
<<<<<<< HEAD


=======
>>>>>>> josh2
}
