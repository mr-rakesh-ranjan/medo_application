package com.medo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.List;
import java.util.StringJoiner;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long addressId;
    private String flatNo;
    private String streetName;
    private String locality;
    private String pincode;
    private String city;
    private String state;

    @OneToMany(targetEntity = Order.class, fetch = FetchType.LAZY)
    @JoinTable(
            name = "orderAddressTable",
            joinColumns = @JoinColumn(name = "address-id", referencedColumnName = "addressId"),
            inverseJoinColumns = @JoinColumn(name = "order-id", referencedColumnName = "OrderId")
    )
    @JsonIgnore
    private List<Order> order;

    @JsonIgnore
    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(
            name = "customer_id"
    )
    private Customer customer;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address{");
        sb.append("addressId=").append(addressId);
        sb.append(", flatNo='").append(flatNo).append('\'');
        sb.append(", streetName='").append(streetName).append('\'');
        sb.append(", locality='").append(locality).append('\'');
        sb.append(", pincode='").append(pincode).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", state='").append(state).append('\'');
//        sb.append(", customer=").append(customer);
        sb.append('}');
        return sb.toString();
    }
}
