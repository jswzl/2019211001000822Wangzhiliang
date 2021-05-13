package com.Wangzhiliang.model;

import java.io.InputStream;

public class Product {
    private Integer ProductId;
    private String ProductName;
    private String ProductDescription;
    private InputStream Picture;
    private double Price;
    private int CategoryId;

    @Override
    public String toString() {
        return "Product{" +
                "ProductId=" + ProductId +
                ", ProductName='" + ProductName + '\'' +
                ", ProductDescription='" + ProductDescription + '\'' +
                ", Picture=" + Picture +
                ", Price=" + Price +
                ", CategoryId=" + CategoryId +
                '}';
    }

    public Integer getProductId() {
        return ProductId;
    }

    public void setProductId(Integer productId) {
        ProductId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductDescription() {
        return ProductDescription;
    }

    public void setProductDescription(String productDescription) {
        ProductDescription = productDescription;
    }

    public InputStream getPicture() {
        return Picture;
    }

    public void setPicture(InputStream picture) {
        Picture = picture;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public Product() {
    }

    public Product(Integer productId, String productName, String productDescription, InputStream picture, double price, int categoryId) {
        ProductId = productId;
        ProductName = productName;
        ProductDescription = productDescription;
        Picture = picture;
        Price = price;
        CategoryId = categoryId;
    }
}
