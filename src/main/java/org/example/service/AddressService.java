package org.example.service;

import org.example.entity.Address;
import org.example.entity.Employee;

public interface AddressService {
    void save(Address address);

    Address load(Long id);

    void delete(Long id);


    void update(Long id,Address address);
}
