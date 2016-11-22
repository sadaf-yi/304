package com.cs304.data_managers;
import com.cs304.data_objects.*;
import java.util.ArrayList;
import java.sql.ResultSet;

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
