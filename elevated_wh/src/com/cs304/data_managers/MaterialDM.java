package com.cs304.data_managers;

import com.cs304.data_objects.Material;
import java.util.ArrayList;

/**
 * Created by tyh0 on 2016-11-20.
 */
public class MaterialDM {

    ArrayList<Material> mats;
    ConnectionManager cm;
    public MaterialDM() {
        mats = null;
        cm = new ConnectionManager();
    }




}
