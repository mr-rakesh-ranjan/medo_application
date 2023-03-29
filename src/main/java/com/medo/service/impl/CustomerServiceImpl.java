package com.medo.service.impl;

import com.medo.dao.CustomerDao;
import com.medo.dto.CustomerDto;
import com.medo.dto.CustomerRequest;
import com.medo.dtoBuilder.CustomerBuilder;
import com.medo.entity.Address;
import com.medo.entity.Customer;
import com.medo.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    private ModelMapper modelMapper;

//    @Override
    public Customer createCustomer(Customer customer) {
        this.customerDao.save(customer);
        return customer;
    }

    @Override
    public Customer updateCustomer(String customerId, Customer customer) {
        Customer customer1 = getCustomerById(customerId);
        customer1 = this.customerDao.save(customer);
        return customer1;
    }

    @Override
    public List<Customer> customers() {
        List<Customer> list = new ArrayList<>();
        list = this.customerDao.findAll();
        return list;
    }

    @Override
    public Customer getCustomerById(String s) {
        return this.customerDao.findByCustomerId(s);
    }

    @Override
    public void deleteCustomer(String customerId) {
        Customer customer = getCustomerById(customerId);
        this.customerDao.delete(customer);
    }

    @Override
    public Customer createCustomer(CustomerDto customerDto) {
        Customer customer = this.modelMapper.map(customerDto, Customer.class);
        Customer customer1 = this.customerDao.save(customer);
        return customer1;
    }


}
