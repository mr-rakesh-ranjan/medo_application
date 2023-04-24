package com.medo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.List;
import java.util.StringJoiner;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(generator = "customerId-generator")
    @GenericGenerator(name = "customerId-generator",
            parameters = @Parameter(name = "prefix", value = "CTMR"),
            strategy = "com.medo.utils.MyGenerator")
    private String customerId;
    private String name;
    private String phoneNumber;
    private String password;
    private String email;

//    @JsonIgnore
    @OneToMany(mappedBy = "customer",
            fetch =  FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Address> addresses;

    @OneToMany(mappedBy = "customer1",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Order> orders;

    public Customer(String name, String phoneNumber, String password, String email) {
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Customer.class.getSimpleName() + "[", "]")
                .add("customerId='" + customerId + "'")
                .add("name='" + name + "'")
                .add("phoneNumber='" + phoneNumber + "'")
                .add("password='" + password + "'")
                .add("address=" + addresses)
                .add("email='" + email + "'")
                .toString();
    }
}
