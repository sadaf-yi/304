package com.cs304.data_managers;
import java.util.ArrayList;

import com.cs304.data_objects.Recipe_Uses;
/**
 * Created by tyh0 on 2016-11-21.
 */
public class RecipeUsesDM {
    ArrayList<Recipe_Uses> ru;
    ConnectionManager cm;

    public RecipeUsesDM () {
        ru = null;
        cm = new ConnectionManager();
    }
}
