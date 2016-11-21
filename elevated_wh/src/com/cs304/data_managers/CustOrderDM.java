package com.cs304.data_managers;
import com.cs304.data_objects.*;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 * Created by tyh0 on 2016-11-20.
 */
public class CustOrderDM {

    ArrayList<Cust_Order> orders;
    ConnectionManager cm;
    public CustOrderDM() {
        orders = null;
        cm = new ConnectionManager();
    }

}
