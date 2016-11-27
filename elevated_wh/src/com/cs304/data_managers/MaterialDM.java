package com.cs304.data_managers;

import com.cs304.data_objects.*;

import java.sql.SQLException;

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
        String sqlQuery = "SELECT * FROM Material";
        String[][] results = new String[0][];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public String[][] getNamefromID(String mid) {
        String sqlQuery = "SELECT matName FROM Material WHERE matID="+mid;
        String[][] results = new String[0][];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public int insertNewMaterial(String prodName, String stock, String unit, String price) {
        String sqlCmd = "INSERT INTO Material(matID,matName,matStock,matUnit,matPrice) "+
                "VALUES(material_counter.nextval,\'"+ prodName+ "\'," + stock+ ",\'" + unit + "\',\'"+price+"\')";
        int result = cm.executeStatement(sqlCmd);
        return result;
    }

    public int updateMaterialStock(String matID, String quantity) {
        String sqlCmd = "UPDATE Material SET matStock = matStock + " + quantity + " WHERE matID="+matID;
        //return of 0 means tuple was NOT successfully added
        int result = cm.executeStatement(sqlCmd);
        return result;
    }

}
