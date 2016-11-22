package com.cs304.data_managers;
import java.util.ArrayList;

import com.cs304.data_objects.Recipe;

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

    public int addNewRecipe(String recName, String procedure) {
        String sqlCmd = "insert into Recipe(recID, recName, procedure) " +
                "values(recipe_counter.nextval,\'" + recName + "\',\'" + procedure;
        cm.connectToDb();
        int result = cm.executeStatement(sqlCmd);
        return result;
    }


}
