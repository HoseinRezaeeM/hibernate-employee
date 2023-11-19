package org.example.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor

@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String empCode;

    Double salary;
    @ToString.Exclude
    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    List<Address> address = new ArrayList<>();

    public Employee(String name, String empCode, Double salary, List<Address> address) {
        this.name = name;
        this.empCode = empCode;
        this.salary = salary;
        this.address = address;
    }

    public Employee(String name, String empCode, Double salary) {
        this.name = name;
        this.empCode = empCode;
        this.salary = salary;
    }


}



