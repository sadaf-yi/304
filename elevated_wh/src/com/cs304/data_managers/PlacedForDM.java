package com.cs304.data_managers;
import java.util.ArrayList;

import com.cs304.data_objects.Placed_For;

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
