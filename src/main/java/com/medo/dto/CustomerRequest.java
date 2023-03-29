package com.medo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {

    private String name;
    private String phoneNumber;
    private String email;
    private String password;

    private String flatNumber;
    private String streetName;
    private String locality;
    private String pincode;
    private String city;
    private String state;

}
