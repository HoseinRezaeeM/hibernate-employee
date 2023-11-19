package org.example.repository;


import org.example.entity.Address;

import java.util.List;

public interface AddressRepository {

    void save(Address address);

    Address load(Long id);

    void delete(Long id);


    void update(Long id,Address address);



}
