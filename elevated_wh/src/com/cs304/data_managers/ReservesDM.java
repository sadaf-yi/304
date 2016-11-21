package com.cs304.data_managers;
import java.util.ArrayList;

import com.cs304.data_objects.Reserves;

/**
 * Created by tyh0 on 2016-11-21.
 */
public class ReservesDM {
    ArrayList<Reserves> res;
    ConnectionManager cm;

    public ReservesDM () {
        res = null;
        cm = new ConnectionManager();
    }

}
