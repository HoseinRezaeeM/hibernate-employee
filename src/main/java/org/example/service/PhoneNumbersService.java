package org.example.service;

import org.example.entity.Employee;
import org.example.entity.PhoneNumbers;

public interface PhoneNumbersService {
    void save(PhoneNumbers phoneNumbers);

    PhoneNumbers load(Long id);

    void delete(Long id);


    void update(Long id,PhoneNumbers phoneNumbers);
}
