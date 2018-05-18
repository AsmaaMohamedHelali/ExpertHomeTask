
package com.example.android.experthometask.models.orders;

import java.io.Serializable;
import java.util.List;

public class Data implements Serializable{

    private String $id;
    private Customers Customers;
    private com.example.android.experthometask.models.login.response.Data Delegate;
    private List<OrderDetail> OrderDetails = null;
    private List<Payment> Payments = null;
    private int order_Id;
    private int customer_Id;
    private String Delegate_id;
    private int Status;
    private int total;
    private String OrderDate;


    public com.example.android.experthometask.models.orders.Customers getCustomers() {
        return Customers;
    }

    public int getOrder_Id() {
        return order_Id;
    }

    public int getTotal() {
        return total;
    }

    public String get$id() {
        return $id;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public List<OrderDetail> getOrderDetails() {
        return OrderDetails;
    }
}
