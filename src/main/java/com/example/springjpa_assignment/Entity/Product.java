package com.example.springjpa_assignment.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "PRODUCTS", schema = "shoppingcart")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;
    private String name;
    private Double price;
    private byte[] image;
    private String description;
    @Column(name = "TOTAL_PRODUCTS_INVENTORY")
    private  int inventory_amount;
    private boolean status;
    @ManyToMany(mappedBy = "products")
    private List<User> users;
    @OneToMany
    private List<Order> orders;

    //Getters
    public int getProduct_id() {
        return product_id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public byte[] getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public int getInventory_amount() {
        return inventory_amount;
    }

    public boolean getStatus() {
        return status;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Order> getOrders() {
        return orders;
    }

    //Setters
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInventory_amount(int inventory_amount) {
        this.inventory_amount = inventory_amount;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
