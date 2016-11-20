import java.util.ArrayList;
import java.util.List;

/**
 * Created by SadafiYadegari on 2016-11-19.
 */
public class Customer {


    private int custID;
    private String custName;
    private ArrayList<Customer> customers;

    public Customer(int custID , String custName) {
        this.custID = custID;
        this.custName = custName;
        }

    public int getCustID(){
        return this.custID;
    }

    public String getCustName(){
        return this.custName;
    }

    private void setCustID (int ID) {
        this.custID = ID;
    }


    private void setCustName(String name) {
        this.custName = name;
    }

    public List<Customer> getCustomers(){
        return this.customers;
    }

    private void addCustomer(Customer c) {
        customers.add(c);
    }

    private void removeCustomer(Customer c) {
        customers.remove(c);
    }

}


