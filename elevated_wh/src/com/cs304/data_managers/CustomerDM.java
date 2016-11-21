package com.cs304.data_managers;
import java.util.ArrayList;

import com.cs304.data_objects.Customer;

/**
 * Created by tyh0 on 2016-11-20.
 */
public class CustomerDM {

    // may need more arraylists to hold data related to customer actions
    ArrayList<Customer> mats;
    ConnectionManager cm;

    public CustomerDM() {
        mats = null;
        cm = new ConnectionManager();
    }

    public void insertCustomer(String firstName, String lastName, String phoneNumber) {
        // TODO: finish this function as it's what josh is using in one of his panels
    }



}