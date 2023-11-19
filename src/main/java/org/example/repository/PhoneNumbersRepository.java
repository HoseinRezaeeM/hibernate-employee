package org.example.repository;

import org.example.entity.PhoneNumbers;

public interface PhoneNumbersRepository {

    void save(PhoneNumbers phoneNumbers);

    PhoneNumbers load(Long id);

    void delete(Long id);


    void update(Long id, PhoneNumbers phoneNumbers);
}
