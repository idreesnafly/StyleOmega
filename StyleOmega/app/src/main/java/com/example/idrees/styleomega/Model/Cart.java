package com.example.idrees.styleomega.Model;

import com.orm.SugarRecord;

public class Cart extends SugarRecord <Cart> {

    double total;
    String status;
    User user;

    public Cart() {

    }

    public Cart(double total, String status, User user) {
        this.total = total;
        this.status = status;
        this.user = user;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

