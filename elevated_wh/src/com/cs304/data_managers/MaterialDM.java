package com.cs304.data_managers;
import java.util.ArrayList;

import com.cs304.data_objects.Material;

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

    public String[][] getAllMaterialTuples() {
        cm.connectToDb();
        String sqlQuery = "SELECT * FROM Material";
        String[][] results = cm.submitQuery(sqlQuery);
        return results;
    }


}
