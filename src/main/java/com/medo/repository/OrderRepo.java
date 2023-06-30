package com.medo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.medo.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface OrderRepo extends JpaRepository<Order, Long> {

    @Query("select o from Order o where o.customer1.customerId= :ci  ")
    List<Order> getAllByCustomer(@Param("ci") String customerId);

}
