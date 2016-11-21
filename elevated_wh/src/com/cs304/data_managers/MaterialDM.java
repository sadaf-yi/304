package com.cs304.data_managers;
import com.cs304.data_objects.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

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
        String[][] results = new String[0][];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public int insertNewMaterial(String prodName, String stock, String unit, String price) {
        String sqlCmd = "insert into Material(matID,matName,matStock,matUnit,matPrice) "+
                "values(material_counter.nextval,\'"+ prodName+ "\'," + stock+ ",\'" + unit + "\',\'"+price+")";
        cm.connectToDb();
        int result = cm.executeStatement(sqlCmd);
        return result;
    }

    public int updateMaterialStock(String matID, String quantity) {
        String sqlCmd = ""
    }

}
