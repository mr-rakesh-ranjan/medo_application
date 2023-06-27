package com.medo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.medo.entity.Address;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDto {
    private String customerId;
    private String name;
    private String phoneNumber;
    private String password;
    private String email;
    private List<Address> addresses;

    @JsonIgnore
    private String getPassword(){
        return  this.password;
    }

}
