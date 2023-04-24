package com.medo.service.impl;

import com.medo.dao.CustomerDao;
//import com.medo.dto.CustomerDto;
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

//    private Add
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Customer createCustomer(Customer customer) {
        Customer customer1 = new Customer();
        List<Address> list  = customer.getAddresses();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setCustomer(customer);
        }
        try {
            customer.setAddresses(list);
             customer1 = this.customerDao.save(customer);
        } catch (Exception e){
            e.printStackTrace();
        }
        return customer1;
    }

    @Override
    public Customer updateCustomer(String customerId, Customer customer) {
        Customer customer1 = getCustomerById(customerId);
        customer1 = this.customerDao.save(customer);
        return customer1;
    }

    @Override
    public List<Customer> customers() {
        List<Customer> list;
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


}
