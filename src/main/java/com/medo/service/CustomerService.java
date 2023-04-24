package com.medo.service;

import com.medo.dto.CustomerDto;
import com.medo.entity.Customer;

import java.util.List;

public interface CustomerService {

    public Customer createCustomer(Customer customer);
    public Customer updateCustomer(String customerId, Customer customer);
    public List<Customer> customers();
    public Customer getCustomerById(String s);
    public void deleteCustomer(String customerId);



    //Using dto
//    public CustomerDto createCustomer(CustomerDto customerDto);
}
