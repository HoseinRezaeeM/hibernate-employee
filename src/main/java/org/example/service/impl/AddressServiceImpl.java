package org.example.service.impl;

import org.example.entity.Address;
import org.example.repository.AddressRepository;
import org.example.service.AddressService;

public class AddressServiceImpl implements AddressService {

    AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository){
        this.addressRepository=addressRepository;
    }
    @Override
    public void save(Address address) {
        addressRepository.save(address);
    }

    @Override
    public Address load(Long id) {
        return addressRepository.load(id);
    }

    @Override
    public void delete(Long id) {
        addressRepository.delete(id);
    }

    @Override
    public void update(Long id, Address address) {
        addressRepository.update(id,address);
    }
}
