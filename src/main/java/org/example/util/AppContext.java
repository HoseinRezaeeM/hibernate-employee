package org.example.util;


import org.example.SessionFactoryProvider;
import org.example.entity.Employee;
import org.example.repository.AddressRepository;
import org.example.repository.EmployeeRepository;
import org.example.repository.PhoneNumbersRepository;
import org.example.repository.impl.AddressRepositoryImpl;
import org.example.repository.impl.EmployeeRepositoryImpl;
import org.example.repository.impl.PhoneNumberRepositoryImpl;
import org.example.service.AddressService;
import org.example.service.EmployeeService;
import org.example.service.PhoneNumbersService;
import org.example.service.impl.AddressServiceImpl;
import org.example.service.impl.EmployeeServiceImpl;
import org.example.service.impl.PhoneNumbersServiceImpl;
import org.hibernate.Session;

public class AppContext {
        private static Session SISSION;
        private static final AddressRepository ADDRESS_REPOSITORY;

        private static final PhoneNumbersRepository PHONE_NUMBERS_REPOSITORY;

        private static final EmployeeRepository EMPLOYEE_REPOSITORY;

        private static final AddressService ADDRESS_SERVICE;

        private static final PhoneNumbersService PHONE_NUMBERS_SERVICE;


        private static final EmployeeService EMPLOYEE_SERVICE;





    static {
        SISSION = SessionFactoryProvider.getSessionFactory().openSession();
        ADDRESS_REPOSITORY = new AddressRepositoryImpl(SISSION);
        PHONE_NUMBERS_REPOSITORY = new PhoneNumberRepositoryImpl(SISSION);
        EMPLOYEE_REPOSITORY = new EmployeeRepositoryImpl(SISSION);
        ADDRESS_SERVICE = new AddressServiceImpl(ADDRESS_REPOSITORY);
        EMPLOYEE_SERVICE = new EmployeeServiceImpl(EMPLOYEE_REPOSITORY);
        PHONE_NUMBERS_SERVICE = new PhoneNumbersServiceImpl(PHONE_NUMBERS_REPOSITORY);



    }

    public static AddressService getAddressService(){
        return ADDRESS_SERVICE;
    }

    public static EmployeeService getEmployeeService(){
        return EMPLOYEE_SERVICE;
    }

    public static PhoneNumbersService getPhoneNumbersService(){
        return PHONE_NUMBERS_SERVICE;
    }


}
