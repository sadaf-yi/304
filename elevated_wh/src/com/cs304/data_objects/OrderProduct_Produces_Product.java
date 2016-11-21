package com.cs304.data_objects;

import java.sql.Date;

/**
 * Created by SadafiYadegari on 2016-11-20.
 */
public class OrderProduct_Produces_Product {

    private Date dateUpdated;
    private int prodID;
    private int quantityRes;

    public OrderProduct_Produces_Product(Date dateUpdated, int prodID, int quantityRes) {
        this.dateUpdated = dateUpdated;
        this.prodID = prodID;
        this.quantityRes = quantityRes;
    }

    public Date getDateUpdated() {
        return this.dateUpdated;
    }

    public int getProdID() {
        return this.prodID;
    }

    public int getquantityRes() {
        return this.quantityRes;
    }

    private void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    private void setProdID(int pid) {
        this.prodID = pid;
    }

    private void setquantityRes(int qRes) {
        this.quantityRes = qRes;
    }

}
