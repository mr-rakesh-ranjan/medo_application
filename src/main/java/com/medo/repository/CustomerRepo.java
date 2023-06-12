package com.medo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.medo.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String> {

    @Query("select u from Customer u where u.customerId = :e")
    Customer findByCustomerId(@Param("e") String customerId);

    Optional<Customer> findByEmail(String email);

}
