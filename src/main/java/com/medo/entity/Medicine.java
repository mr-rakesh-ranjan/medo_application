package com.medo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long medId;
    private String medicineName;
    private String medicineCompany;
    private double price;
    private String medicineType;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate manufacturingDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expiryDate;


}
