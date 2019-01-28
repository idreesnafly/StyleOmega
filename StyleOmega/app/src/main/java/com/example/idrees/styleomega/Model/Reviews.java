package com.example.idrees.styleomega.Model;

import com.orm.SugarRecord;

public class Reviews extends SugarRecord <Reviews> {

    User user;
    Product product;
    float rating;
    String review;

    public Reviews() {

    }

    public Reviews(User user, Product product, float rating, String review) {
        this.user = user;
        this.product = product;
        this.rating = rating;
        this.review = review;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
