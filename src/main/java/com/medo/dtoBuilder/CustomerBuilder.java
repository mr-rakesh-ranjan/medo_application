package com.medo.dtoBuilder;

import com.medo.dto.CustomerRequest;
import com.medo.entity.*;

public class CustomerBuilder {

    //customer
    private String name;
    private String phoneNumber;
    private String email;
    private String password;

    //address
    private String flatNumber;
    private String streetName;
    private String locality;
    private String pincode;
    private String city;
    private String state;

    public CustomerBuilder(CustomerRequest customerRequest) {
        this.name = customerRequest.getName();
        this.phoneNumber = customerRequest.getPhoneNumber();
        this.email = customerRequest.getEmail();
        this.password = customerRequest.getPassword();
        this.flatNumber = customerRequest.getFlatNumber();
        this.streetName = customerRequest.getStreetName();
        this.locality = customerRequest.getLocality();
        this.pincode = customerRequest.getPincode();
        this.city = customerRequest.getCity();
        this.state = customerRequest.getState();
    }

    public Customer buildCustomer(){
        return new Customer(this.name, this.email, this.phoneNumber, this.password);
    }

    public Address buildAddress(){
        return new Address(this.flatNumber, this.streetName, this.locality, this.pincode, this.city, this.state);
    }


}
