package com.medo.repository;

import com.medo.entity.Address;
import com.medo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepo extends JpaRepository<Address, Long> {
    long deleteByCustomer(Customer customer);

    @Query("select a from Address a  where a.addressId= :ai and a.customer.customerId = :ci")
    Address getAddressByAddressIdAndCustomer(@Param("ai") Long addressId, @Param("ci") String customerId);

}
