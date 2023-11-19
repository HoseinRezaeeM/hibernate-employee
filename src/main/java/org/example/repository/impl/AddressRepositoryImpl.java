package org.example.repository.impl;

import org.example.entity.Address;
import org.example.repository.AddressRepository;
import org.hibernate.Session;

public class AddressRepositoryImpl implements AddressRepository {
        Session session;

        public AddressRepositoryImpl(Session session){
            this.session=session;
        }
    @Override
    public void save(Address address) {
        try {
            session.beginTransaction();
            session.persist(address);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }


    @Override
    public Address load(Long id) {
        try {
            session.beginTransaction();
            return session.load(Address.class, id);

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        try {
            session.beginTransaction();

            Address person1 = session.get(Address.class, id);
            session.delete(person1);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    @Override
    public void update(Long id, Address address) {
        try {
            session.beginTransaction();
            Address person1 =  session.load(Address.class, id);
            person1.setPostalAddress(address.getPostalAddress());
            person1.setCity(address.getCity());

            session.update(person1);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();


        }

    }


}
