package com.example.idrees.styleomega.Model;

import com.orm.SugarRecord;

import java.util.Date;

public class CartItem extends SugarRecord <CartItem> {

    int Quantity;
    Date purchaseDate;
    Cart cartorder;
    Product products;

    public CartItem() {

    }

    public CartItem(int quantity, Date purchaseDate, Cart cartorder, Product products) {
        Quantity = quantity;
        this.purchaseDate = purchaseDate;
        this.cartorder = cartorder;
        this.products = products;
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
        return cartorder;
    }

    public void setOrder(Cart order) {
        this.cartorder = order;
    }

    public Product getProduct() {
        return products;
    }

    public void setProduct(Product product) {
        this.products = product;
    }
}
