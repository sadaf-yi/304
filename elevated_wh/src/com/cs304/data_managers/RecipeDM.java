package com.cs304.data_managers;
import com.cs304.data_objects.Recipe;

import java.sql.SQLException;
import java.util.ArrayList;

public class RecipeDM {
    ArrayList<Recipe> recipes;
    ConnectionManager cm;

    public RecipeDM() {
        recipes = null;
        cm = new ConnectionManager();
    }
    public int addNewRecipe(String recName, String procedure) {
        String sqlCmd = "insert into Recipe(recID, recName, procedure) " +
                "values(recipe_counter.nextval,\'" + recName + "\',\'" + procedure;
        int result = cm.executeStatement(sqlCmd);
        return result;
    }

    public  String[][] getRecInfo(String recID) {
        String sqlQuery = "SELECT procedure, recName FROM Recipe";

        String[][] results = new String[0][0];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return results;
    }

    


}
