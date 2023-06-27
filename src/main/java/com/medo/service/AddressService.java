package com.medo.service;

import com.medo.dto.AddressDto;
import com.medo.dto.CustomerDto;
import com.medo.entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AddressService {

    CustomerDto addAddressToCustomer(String customerId, AddressDto addressDto);
    List<Address> getAllAddressFromCustomer(String customerId);

    String deleteAddress(String customerId, Long addressId);

    AddressDto updateAddress(String customerId, Long addressId, AddressDto addressDto);
}
