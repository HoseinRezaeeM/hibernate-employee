package org.example.service.impl;

import org.example.entity.PhoneNumbers;
import org.example.repository.PhoneNumbersRepository;
import org.example.service.PhoneNumbersService;

public class PhoneNumbersServiceImpl implements PhoneNumbersService {
    PhoneNumbersRepository phoneNumbersRepository;

    public PhoneNumbersServiceImpl(PhoneNumbersRepository phoneNumbersRepository){
        this.phoneNumbersRepository=phoneNumbersRepository;
    }
    @Override
    public void save(PhoneNumbers phoneNumbers) {
        phoneNumbersRepository.save(phoneNumbers);


    }

    @Override
    public PhoneNumbers load(Long id) {
         return phoneNumbersRepository.load(id);
    }

    @Override
    public void delete(Long id) {
        phoneNumbersRepository.delete(id);
    }

    @Override
    public void update(Long id, PhoneNumbers phoneNumbers) {
        phoneNumbersRepository.update(id,phoneNumbers);
    }
}
