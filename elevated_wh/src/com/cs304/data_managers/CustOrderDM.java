package com.cs304.data_managers;
import java.util.ArrayList;

import com.cs304.data_objects.Cust_Order;

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
