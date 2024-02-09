package com.example.springjpa_assignment.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ORDER_HISTORY", schema = "shoppingcart")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;
    private LocalDate order_date;

    //private int user_id;
    //private int product_id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    //Getters
    public int getOrder_id() {
        return order_id;
    }

    public LocalDate getOrder_date() {
        return order_date;
    }
/*
    public int getUser_id() {
        return user_id;
    }

    public int getProduct_id() {
        return product_id;
    }
*/
    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    //Setters
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setOrder_date(LocalDate order_date) {
        this.order_date = order_date;
    }
/*
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
*/

    public void setUser(User user) {
        this.user = user;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
