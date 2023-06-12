package com.medo.dto;

import com.medo.entity.Customer;
import com.medo.entity.Medicine;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDto {

    private List<Medicine> medicineList;
    private int totalItems;
//    private double

}
