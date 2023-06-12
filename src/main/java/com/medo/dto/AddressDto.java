package com.medo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    private String flatNo;
    private String streetName;
    private String locality;
    private String pincode;
    private String city;
    private String state;

}
