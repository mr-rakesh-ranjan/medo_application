package com.medo.dto;

import com.medo.entity.Address;
import com.medo.entity.Customer;
import com.medo.entity.Medicine;
import com.medo.entity.OrderItems;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDto {

    private List<OrderItems> orderItems;
    private int totalPrice;
    private String paymentMethod;
    private Address address;

}
