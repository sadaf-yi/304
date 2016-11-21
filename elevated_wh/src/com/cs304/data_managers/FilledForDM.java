package com.cs304.data_managers;
import java.util.ArrayList;

import com.cs304.data_objects.Filled_For;

/**
 * Created by tyh0 on 2016-11-21.
 */
public class FilledForDM {

    ArrayList<Filled_For> ff;
    ConnectionManager cm;

    public FilledForDM() {
        ff = null;
        cm = new ConnectionManager();
    }
}
