package com.medo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.medo.entity.Order;


public interface OrderRepo extends JpaRepository<Order, Long> {

}
