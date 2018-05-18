
package com.example.android.experthometask.models.orders;

import java.io.Serializable;
import java.util.List;

public class Governorate implements Serializable {

    private String $id;
    private int governorate_code;
    private String governorate_name;
    private List<Department_> department = null;
    private List<Department_> customers = null;


}
