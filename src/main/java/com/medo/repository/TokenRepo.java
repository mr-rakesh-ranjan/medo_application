package com.medo.repository;

import com.medo.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TokenRepo extends JpaRepository<Token, Integer> {

    @Query("""
        select t from Token t inner join Customer c on t.customer.customerId = c.customerId 
        where c.customerId = :customerId and (t.expired = false or t.revoked = false)
    """)
    List<Token> findAllValidTokensByCustomer(@Param("customerId") String customerId);

    Optional<Token> findByToken(String token);
}
