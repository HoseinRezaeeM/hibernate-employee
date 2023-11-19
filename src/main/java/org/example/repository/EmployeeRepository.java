package org.example.repository;

import org.example.entity.Employee;

import java.util.List;

public interface EmployeeRepository {
    void save(Employee employee);

    Employee load(Long id);

    void delete(Long id);


    void update(Long id,Employee employee);

    List<Employee> findEmployeeByPostalCode(String postalCode);

    List<Employee> findEmployeeByTelNumber(String telNumber);

    List<Employee> findEmployeeByCity(String city);

    List<Employee> findEmployeeByNumberPrefix(String prefix);

    List<Employee> findEmployeeByPrefixAndCity(String prefix,String city);

    List<Employee> findEmployeeBasedOnHighestSalaryInCity(String city);
}
