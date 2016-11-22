package com.cs304.data_managers;
import com.cs304.data_objects.*;
import java.util.ArrayList;
import java.sql.ResultSet;

public class RecipeUsesDM {
    ArrayList<Recipe_Uses> ru;
    ConnectionManager cm;

    public RecipeUsesDM () {
        ru = null;
        cm = new ConnectionManager();
    }


}
