package com.medo.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private String paymentMethod;
    private double totalPrice;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Address address;

    @OneToMany(mappedBy = "order",
            fetch =  FetchType.LAZY,
            cascade = CascadeType.MERGE,
            orphanRemoval = true
    )
    private List<OrderItems> orderItems = new ArrayList<>();


    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer1;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("orderId=").append(orderId);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", status='").append(status).append('\'');
        sb.append(", paymentMethod='").append(paymentMethod).append('\'');
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", address=").append(address);
        sb.append(", orderItems=").append(orderItems);
        sb.append('}');
        return sb.toString();
    }
}
