package com.example.idrees.styleomega.Model;

import com.orm.SugarRecord;

import java.util.Date;

public class CartItem extends SugarRecord <CartItem> {

    int Quantity;
    Date purchaseDate;
    Cart order;
    Product product;

    public CartItem() {

    }

    public CartItem(int quantity, Date purchaseDate, Cart order, Product product) {
        Quantity = quantity;
        this.purchaseDate = purchaseDate;
        this.order = order;
        this.product = product;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Cart getOrder() {
        return order;
    }

    public void setOrder(Cart order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
