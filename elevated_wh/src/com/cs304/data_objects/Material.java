package com.cs304.data_objects;

/**
 * Created by SadafiYadegari on 2016-11-19.
 */
public class Material {

    private int matID;
    private String matName;
    private float matStock;
    private int matPrice;
    private String matUnit;



    public Material (int matID, String matName, float matStock, int matPrice, String matUnit) {
        this.matID = matID;
        this.matName = matName;
        this.matStock = matStock;
        this.matPrice = matPrice;
        this.matUnit = matUnit;
    }

    public int getMatID() {
        return this.matID;
    }

    public String getMatName() {
        return this.matName;
    }

    public float getMatStock() {
        return this.matStock;
    }

    public int getMatPrice() {
        return this.matPrice;
    }

    public String getMatUnit() {
        return this.matUnit;
    }


    private void setMatID (int ID) {
        this.matID = ID;
    }

    private void setMatName (String name) {
        this.matName = name;
    }

    private void setMatStock (float stock) {
        this.matStock = stock;
    }

    private void setMatPrice (int price) {
        this.matPrice = price;
    }

    private void setMatUnit (String unit) {
        this.matUnit = unit;
    }

    protected void addMaterial(int quantity) {
        this.matStock += quantity;
    }

    protected void removeMaterial(int quantity){
        this.matStock -= quantity;
    }


}
