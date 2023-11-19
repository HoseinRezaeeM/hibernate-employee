package org.example.service.impl;

import org.example.entity.Employee;
import org.example.repository.EmployeeRepository;
import org.example.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository= employeeRepository;
    }
    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee load(Long id) {
        return employeeRepository.load(id);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.delete(id);
    }

    @Override
    public void update(Long id, Employee employee) {
        employeeRepository.update(id,employee);
    }

    @Override
    public List<Employee> findEmployeeByPostalCode(String postalCode) {
        return employeeRepository.findEmployeeByPostalCode(postalCode);
    }

    @Override
    public List<Employee> findEmployeeByTelNumber(String telNumber) {
        return employeeRepository.findEmployeeByTelNumber(telNumber);
    }

    @Override
    public List<Employee> findEmployeeByCity(String city) {
         return employeeRepository.findEmployeeByCity(city);
    }

    @Override
    public List<Employee> findEmployeeByNumberPrefix(String prefix) {
         return employeeRepository.findEmployeeByNumberPrefix(prefix);
    }

    @Override
    public List<Employee> findEmployeeByPrefixAndCity(String prefix, String city) {
        return employeeRepository.findEmployeeByPrefixAndCity(prefix,city);
    }

    @Override
    public List<Employee> findEmployeeBaseOnCityAndIncome(String city) {
      return   employeeRepository.findEmployeeBasedOnHighestSalaryInCity(city);
    }
    public List<Employee> findEmployeeBasedOnHighestSalaryInCity(String city){
        return employeeRepository.findEmployeeBasedOnHighestSalaryInCity(city);
    };
}
