package com.example.idrees.styleomega.Model;

import android.media.Image;

import com.orm.SugarRecord;

public class Product extends SugarRecord<Product> {

String ProductCode, ProductName, Description;
Double ProductPrice;
Integer Quantity;
String ProductImage;
Boolean NewArrival;
Boolean Availability;
String Category;                //MEN //WOMEN //MENACC //WOMENACC
String subCategory;             //TSHIRT //SHIRT //TROUSER


    public Product(String productCode, String productName, String description, Double productPrice, Integer quantity, String productImage, Boolean newArrival, Boolean availability, String category, String subCategory) {
        ProductCode = productCode;
        ProductName = productName;
        Description = description;
        ProductPrice = productPrice;
        Quantity = quantity;
        ProductImage = productImage;
        NewArrival = newArrival;
        Availability = availability;
        Category = category;
        this.subCategory = subCategory;
    }

    public Product() {

    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public Boolean getNewArrival() {
        return NewArrival;
    }

    public void setNewArrival(Boolean newArrival) {
        NewArrival = newArrival;
    }

    public Boolean getAvailability() {
        return Availability;
    }

    public void setAvailability(Boolean availability) {
        Availability = availability;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }



    public String getProductCode() {
        return ProductCode;
    }

    public void setProductCode(String productCode) {
        ProductCode = productCode;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Double getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(Double productPrice) {
        ProductPrice = productPrice;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public String getProductImage() {
        return ProductImage;
    }

    public void setProductImage(String productImage) {
        ProductImage = productImage;
    }
}
