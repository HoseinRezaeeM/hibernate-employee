package org.example;



import org.example.entity.Address;
import org.example.entity.Employee;
import org.example.entity.PhoneNumbers;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryProvider {

    private final static SessionFactory sessionFactory;

    static {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // by default load hibernate.cfg.xml
                .build();

        sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(PhoneNumbers.class)
                .buildMetadata()
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
