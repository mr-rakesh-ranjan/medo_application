package com.medo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.medo.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerDao extends JpaRepository<Customer, String> {

    @Query("select u from Customer u where u.customerId = :e")
    Customer findByCustomerId(@Param("e") String customerId);

}
