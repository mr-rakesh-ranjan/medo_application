package com.medo.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Embeddable
@Data
@ToString
public class OrderComposite implements Serializable {

    private Long orderId;
    private Long medicineId;


}
