import java.util.ArrayList;

/**
 * Created by SadafiYadegari on 2016-11-19.
 */
public class Order {

    private int orderID;
    private ArrayList<Order> orders;

    public Order (int orderID) {
        this.orderID = orderID;
    }

    public int getOrderID() {
        return this.orderID;
    }

    private void setOrderID(int ID) {
        this.orderID = ID;
    }

    private ArrayList<Order> getOrders() {
        return this.orders;
    }
}
