
package com.example.android.experthometask.models.orders;

import java.io.Serializable;
import java.util.List;

public class Subcategories implements Serializable{

    private String $id;
    private Categories categories;
    private List<Object> ProductDiscounts = null;
    private List<SubCategoriesImage> subCategoriesImages = null;
    private int subcategory_ID;
    private String subcategory_Size;
    private Float subcategory_Price;
    private int subcategory_Package;
    private String creation_date;
    private int category_ID;
    private String $ref;

    public String getSubcategory_Size() {
        return subcategory_Size;
    }

    public Float getSubcategory_Price() {
        return subcategory_Price;
    }

    public String getCreation_date() {
        return creation_date;
    }
}
