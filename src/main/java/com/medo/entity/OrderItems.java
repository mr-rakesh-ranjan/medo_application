package com.medo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItems {

    @EmbeddedId
    private OrderComposite id;

    private int quantity;
    @OneToOne
    private Medicine medicine;
//
    @ManyToOne
    private Order order;
}
