package com.cs304.data_managers;
import com.cs304.data_objects.*;
import java.util.ArrayList;

/**
 * Created by tyh0 on 2016-11-21.
 */
public class PlacedForDM {
    ArrayList<Placed_For> pf;
    ConnectionManager cm;

    public PlacedForDM() {
        pf = null;
        cm = new ConnectionManager();
    }

}
