package com.example.springjpa_assignment.Repository;

import com.example.springjpa_assignment.Entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
