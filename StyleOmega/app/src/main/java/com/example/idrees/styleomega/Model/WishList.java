package com.example.idrees.styleomega.Model;

import com.orm.SugarRecord;

public class WishList extends SugarRecord <WishList> {
    Product product;
    User user;

    public WishList() {

    }

    public WishList(Product product, User user) {
        this.product = product;
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
