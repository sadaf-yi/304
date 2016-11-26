package com.cs304.data_managers;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cs304.data_objects.Build_Product;
/**
 * Created by tyh0 on 2016-11-21.
 */
public class BuildProductDM {


    ArrayList<Build_Product> build_products;
    ConnectionManager cm;

    public BuildProductDM() {
        build_products = null;
        cm = new ConnectionManager();
    }

    public void insertNewBuildProductTuple(String prodID, String recipeID) {
        String sqlCmd = "insert into Build_Product(prodID, recID) values ("
                + prodID + "," + recipeID + ")";
        cm.connectToDb();
        int rowCount = cm.executeStatement(sqlCmd);
    }

    public String[][] getAllBuildProducts() {
        cm.connectToDb();
        String sqlQuery = "SELECT * FROM Build_Product";
        String[][] results = new String[0][];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public String[][] getAllInfo4ProdRec() {
        cm.connectToDb();
        String sqlQuery = "";

        sqlQuery = "SELECT * FROM Recipe4Product";

        String[][] results = new String[0][];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }


}
