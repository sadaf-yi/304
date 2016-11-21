package com.cs304.data_objects;

/**
 * Created by SadafiYadegari on 2016-11-20.
 */
public class Cust_Order {

        private int orderID;


        public Cust_Order (int orderID) {
            this.orderID = orderID;
        }

        public int getOrderID() {
            return this.orderID;
        }

        private void setOrderID(int ID) {
            this.orderID = ID;
        }

}
