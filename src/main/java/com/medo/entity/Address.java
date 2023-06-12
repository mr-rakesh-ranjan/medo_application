package com.medo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.StringJoiner;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Address {

    @Id
//    @GeneratedValue(generator = "addressId-generator")
//    @GenericGenerator(name = "addressId-generator",
//            parameters = @Parameter(name = "prefix", value = "ADS"),
//            strategy = "com.medo.utils.MyGenerator")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long addressId;
    private String flatNo;
    private String streetName;
    private String locality;
    private String pincode;
    private String city;
    private String state;

    @JsonIgnore
    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(
            name = "customer_id"
    )
    private Customer customer;

    public Address(String flatNo, String streetName, String locality, String pincode, String city, String state) {
        this.flatNo = flatNo;
        this.streetName = streetName;
        this.locality = locality;
        this.pincode = pincode;
        this.city = city;
        this.state = state;
    }

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
        sb.append(", customer=").append(customer);
        sb.append('}');
        return sb.toString();
    }
}
