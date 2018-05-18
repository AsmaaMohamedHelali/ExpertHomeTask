
package com.example.android.experthometask.models.orders;


import java.io.Serializable;

public class OrderDetail implements Serializable {

    private String $id;
    private Department_ Orders;
    private Subcategories subcategories;
    private int OrderDetailId;
    private int order_Id;
    private int subcategory_ID;
    private int Quantity;
    private int type;
    private Float UnitPrice;


    public Subcategories getSubcategories() {
        return subcategories;
    }

    public int getOrderDetailId() {
        return OrderDetailId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public int getType() {
        return type;
    }

    public Float getUnitPrice() {
        return UnitPrice;
    }
}
