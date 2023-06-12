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
//@RequestMapping("api/v1/public")
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
    public Customer getCustomerById(@PathVariable("customerId") String customerId){
        return this.customerService.getCustomerById(customerId);
    }

    @PostMapping("/add-address/{customerId}")
    public ResponseEntity<CustomerDto> addAddressToCustomer(@PathVariable("customerId") String customerId, @RequestBody AddressDto addressDto){
        CustomerDto customerDto = this.customerService.addAddressToCustomer(customerId, addressDto);
        System.out.println("this is from customer controllers" + customerDto);
        return ResponseEntity.ok(customerDto);
    }




}
