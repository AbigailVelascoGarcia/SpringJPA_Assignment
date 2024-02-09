package com.example.springjpa_assignment.Entity;

import com.example.springjpa_assignment.Entity.Order;
import com.example.springjpa_assignment.Entity.Product;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "USERS", schema = "shoppingcart")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int user_id;
    private String name;
    private String last_name;
    private String bio;
    private String email;
    private String area_of_interest;
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(
            name = "USERS_PRODUCTS",
            schema = "shoppingcart",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    )
    private List<Product> products;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    //Getters
    public int getUser_id() {
        return user_id;
    }

    public String getName() {
        return name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getBio() {
        return bio;
    }

    public String getEmail() {
        return email;
    }

    public String getArea_of_interest() {
        return area_of_interest;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Order> getOrders() {
        return orders;
    }

    //Setters
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setArea_of_interest(String area_of_interest) {
        this.area_of_interest = area_of_interest;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}
