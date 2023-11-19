package org.example.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String postalCode;
    String postalAddress;
    String city;
    @ManyToOne
    Employee employee;
    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    List<PhoneNumbers> phoneNumbers = new ArrayList<>();


    public Address(String postalCode, String postalAddress, String city, Employee employee, List<PhoneNumbers> phoneNumbers) {
        this.postalCode = postalCode;
        this.postalAddress = postalAddress;
        this.city = city;
        this.employee = employee;
        this.phoneNumbers = phoneNumbers;
    }

    public Address(String postalCode, String postalAddress, String city, Employee employee) {
        this.postalCode = postalCode;
        this.postalAddress = postalAddress;
        this.city = city;
        this.employee = employee;
    }
}
