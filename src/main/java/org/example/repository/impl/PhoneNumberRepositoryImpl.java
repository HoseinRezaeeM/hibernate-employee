package org.example.repository.impl;

import org.example.entity.Employee;
import org.example.entity.PhoneNumbers;
import org.example.repository.PhoneNumbersRepository;
import org.hibernate.Session;

public class PhoneNumberRepositoryImpl implements PhoneNumbersRepository {

    Session session;
    public PhoneNumberRepositoryImpl(Session session){
        this.session=session;
    }
    @Override
    public void save(PhoneNumbers phoneNumbers) {
        try {
            session.beginTransaction();
            session.persist(phoneNumbers);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    @Override
    public PhoneNumbers load(Long id) {
        try {
            session.beginTransaction();
            return session.load(PhoneNumbers.class, id);

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

            PhoneNumbers phoneNumbers = session.get(PhoneNumbers.class, id);
            session.delete(phoneNumbers);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    @Override
    public void update(Long id, PhoneNumbers phoneNumbers) {
        try {
            session.beginTransaction();
            PhoneNumbers phoneNumbers1 = session.load(PhoneNumbers.class, id);
            phoneNumbers1.setMobNumber(phoneNumbers.getMobNumber());
            phoneNumbers1.setTelNumber(phoneNumbers.getTelNumber());

            session.update(phoneNumbers1);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();


        }

    }
}
