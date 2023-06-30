package com.medo.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class OrderEnity {

    @EmbeddedId
    private OrderComposite orderComposite;

}
