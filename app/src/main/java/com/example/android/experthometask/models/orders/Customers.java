
package com.example.android.experthometask.models.orders;


import java.io.Serializable;

public class Customers implements Serializable{

    private String $id;
    private Department department;
    private Governorate governorate;
    private int customer_Id;
    private String customer_name;
    private int governorate_code;
    private int department_code;
    private String mobile;
    private String actitvity;
    private String $ref;

    public String getCustomer_name() {
        return customer_name;
    }
}
