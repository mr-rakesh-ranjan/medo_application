package com.medo.controller;

import com.medo.dto.AddressDto;
import com.medo.dto.CustomerDto;
import com.medo.entity.Customer;

import com.medo.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*")
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


    @GetMapping("/all-customer")
    public List<Customer> getAllCustomer(){
        return this.customerService.customers();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("customerId") String customerId){
        return ResponseEntity.ok(this.customerService.getCustomerById(customerId));
    }





}
