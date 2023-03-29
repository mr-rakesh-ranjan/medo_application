package com.medo.dto;

import com.medo.entity.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CustomerDto {
    private  String customerId;
    private String name;
    private String phoneNumber;
    private String password;
    private String email;
    private List<Address> addresses;

}
