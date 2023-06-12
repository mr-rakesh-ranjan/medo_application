package com.medo.service.impl;

import com.medo.dto.AddressDto;
import com.medo.dto.CustomerDto;
import com.medo.repository.CustomerRepo;
//import com.medo.dto.CustomerDto;
import com.medo.entity.Address;
import com.medo.entity.Customer;
import com.medo.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

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
             customer1 = this.customerRepo.save(customer);
        } catch (Exception e){
            e.printStackTrace();
        }
        return customer1;
    }

    @Override
    public Customer updateCustomer(String customerId, Customer customer) {
        Customer customer1 = getCustomerById(customerId);
        customer1 = this.customerRepo.save(customer);
        return customer1;
    }

    @Override
    public List<Customer> customers() {
        List<Customer> list;
        list = this.customerRepo.findAll();
        return list;
    }

    @Override
    public Customer getCustomerById(String s) {
        return this.customerRepo.findByCustomerId(s);
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        Customer customer = this.customerRepo.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("Customer not found!!")
        );
        return customer;
    }

    @Override
    public void deleteCustomer(String customerId) {
        Customer customer = getCustomerById(customerId);
        this.customerRepo.delete(customer);
    }

    @Override
    public CustomerDto addAddressToCustomer(String customerId, AddressDto addressDto) {
        System.out.println("service impl is called");
        Customer customer = this.customerRepo.findByCustomerId(customerId);
        System.out.println(customer.getName());
        List<Address> addressList = customer.getAddresses();
        System.out.println("addressList");
        for(Address i : addressList){
            System.out.println(i);
        }
        Address address = this.modelMapper.map(addressDto, Address.class);
        if (addressList.size() == 0){
            addressList.add(address);
            addressList.get(0).setCustomer(customer);
        } else {
            for (int i = addressList.size() - 1; i < addressList.size(); i++) {
                addressList.add(i, address);
                addressList.get(i).setCustomer(customer);
            }
        }
        System.out.println("this is from service impl" + customer);
        return CustomerDto.builder()
                .customerId(customer.getCustomerId())
                .name(customer.getName())
                .phoneNumber(customer.getPhoneNumber())
                .email(customer.getEmail())
                .addresses(customer.getAddresses())
                .build();
    }


}
