package com.cs304.data_managers;
import com.cs304.data_objects.*;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 * Created by tyh0 on 2016-11-20.
 */
public class RecipeDM {
    ArrayList<Recipe> recipes;
    ConnectionManager cm;

    public RecipeDM() {
        recipes = null;
        cm = new ConnectionManager();
    }

    public addNewRecipe(String recName, String procedure) {
        String sqlCmd = "insert into Recipe(recID, recName, procedure) " +
                "values(recipe_counter.nextval,\'" + recName + "\',\'" + procedure;
        cm.connectToDb();
        cm.executeStatement(sqlCmd);
    }


}
