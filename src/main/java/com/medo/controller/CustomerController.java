package com.medo.controller;

import com.medo.entity.Customer;

import com.medo.service.CustomerService;
import com.medo.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/home")
    public String home(){
        return "this is customer controller";
    }

    @PostMapping("/create")
    public Customer createCustomer(@RequestBody Customer customer){
        return this.customerService.createCustomer(customer);
    }

    @GetMapping("/all-customer")
    public List<Customer> getAllCustomer(){
        return this.customerService.customers();
    }

    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable("customerId") String customerId){
        return this.customerService.getCustomerById(customerId);
    }




}
