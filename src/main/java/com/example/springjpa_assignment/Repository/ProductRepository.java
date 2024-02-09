package com.example.springjpa_assignment.Repository;

import com.example.springjpa_assignment.Entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    Product findByName(String name);
   List<Product> findByPrice(Double price);

}
