package com.medo.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createdDate;
    private String status;


    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer1;



}
