package com.example.a43204_new.ui.theme.tuan6;

import java.util.PrimitiveIterator;

public class Product {
    private String styleId;
    private String brand;
    private String price;
    private String additionInfo;
    private String SearchImage;

    public Product(String styleId, String brand, String price, String additionInfo, String searchImage) {
        this.styleId = styleId;
        this.brand = brand;
        this.price = price;
        this.additionInfo = additionInfo;
        SearchImage = searchImage;
    }

    public String getStyleId() {
        return styleId;
    }

    public void setStyleId(String styleId) {
        this.styleId = styleId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAdditionInfo() {
        return additionInfo;
    }

    public void setAdditionInfo(String additionInfo) {
        this.additionInfo = additionInfo;
    }

    public String getSearchImage() {
        return SearchImage;
    }

    public void setSearchImage(String searchImage) {
        SearchImage = searchImage;
    }
}
