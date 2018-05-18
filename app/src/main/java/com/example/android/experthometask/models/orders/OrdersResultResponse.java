
package com.example.android.experthometask.models.orders;

import java.io.Serializable;
import java.util.List;

public class OrdersResultResponse implements Serializable {

    private String $id;
    private List<Data> data = null;

    public List<Data> getData() {
        return data;
    }
}
