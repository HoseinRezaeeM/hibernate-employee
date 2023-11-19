package org.example;

import org.example.entity.Address;
import org.example.entity.Employee;
import org.example.entity.PhoneNumbers;
import org.example.util.AppContext;
import org.hibernate.Session;
import org.hibernate.graph.spi.AppliedGraph;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        Session session = SessionFactoryProvider.getSessionFactory().openSession();
//
//        Employee employee = new Employee("samyar","1111",100000.0);
//
//
//        Address address= new Address("123445","st.10","tehran",employee);
//
//        PhoneNumbers phoneNumbers = new PhoneNumbers("2224325","091223142",address);
//
//        employee.getAddress().add(address);
//
//        address.getPhoneNumbers().add(phoneNumbers);
//
//
//
//        Employee employee1 = new Employee("ali","1000",2000.0);
//
//        Address address1 = new Address("15192352","molavi","tehran",employee1);
//
//        PhoneNumbers phoneNumbers1 = new PhoneNumbers("77123133","09221234234",address1);
//
//        employee1.getAddress().add(address1);
//
//        address1.getPhoneNumbers().add(phoneNumbers1);
//
//        AppContext.getEmployeeService().save(employee1);
//
//        AppContext.getPhoneNumbersService().save(phoneNumbers1);
//
//        AppContext.getPhoneNumbersService().save(phoneNumbers1);
//
//
//        System.out.println(AppContext.getEmployeeService().findEmployeeByPostalCode("123"));
//
//        System.out.println(AppContext.getEmployeeService().findEmployeeByNumberPrefix("0912"));
//
//        System.out.println(AppContext.getEmployeeService().findEmployeeByCity("zahedan"));
//
//        System.out.println(AppContext.getEmployeeService().findEmployeeByPrefixAndCity("0912", "tehran"));

        System.out.println(AppContext.getEmployeeService().findEmployeeBasedOnHighestSalaryInCity("zanjan"));
    }
}