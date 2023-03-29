package com.medo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.StringJoiner;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
        return new StringJoiner(", ", Address.class.getSimpleName() + "[", "]")
                .add("addressId='" + addressId + "'")
                .add("flatNo='" + flatNo + "'")
                .add("streetName='" + streetName + "'")
                .add("locality='" + locality + "'")
                .add("pincode='" + pincode + "'")
                .add("city='" + city + "'")
                .add("state='" + state + "'")
                .add("customer=" + customer)
                .toString();
    }
}
