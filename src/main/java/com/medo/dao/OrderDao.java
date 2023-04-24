package com.medo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.medo.entity.Order;


public interface OrderDao extends JpaRepository<Order, Long> {

}
