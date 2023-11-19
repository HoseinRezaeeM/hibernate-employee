package org.example.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumbers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String telNumber;

    String mobNumber;
    @ManyToOne
    Address address;

    public PhoneNumbers(String telNumber, String mobNumber, Address address) {
        this.telNumber = telNumber;
        this.mobNumber = mobNumber;
        this.address = address;
    }

    public PhoneNumbers(String telNumber, String mobNumber) {
        this.telNumber = telNumber;
        this.mobNumber = mobNumber;
    }
}
