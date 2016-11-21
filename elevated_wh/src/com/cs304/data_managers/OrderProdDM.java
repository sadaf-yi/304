package com.cs304.data_managers;

import com.cs304.data_objects.*;
import java.util.ArrayList;

/**
 * Created by tyh0 on 2016-11-21.
 */
public class OrderProdDM {
    ArrayList<OrderProduct_Produces_Product> oppp;
    ConnectionManager cm;

    public OrderProdDM() {
        oppp = null;
        cm = new ConnectionManager();
    }
}
