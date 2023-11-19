package org.example.repository.impl;


import org.example.entity.Employee;
import org.example.repository.EmployeeRepository;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    Session session;
    public EmployeeRepositoryImpl(Session session){
        this.session=session;
    }

    @Override
    public void save(Employee employee) {

        try {
            session.beginTransaction();
            session.persist(employee);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    @Override
    public Employee load(Long id) {
        try {
            session.beginTransaction();
            return session.load(Employee.class, id);

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

            Employee employee = session.get(Employee.class, id);
            session.delete(employee);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    @Override
    public void update(Long id, Employee employee) {
        try {
            session.beginTransaction();
            Employee employee1 = session.load(Employee.class, id);
            employee1.setName(employee.getName());
            employee1.setSalary(employee.getSalary());

            session.update(employee1);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();


        }
    }

    @Override
    public List<Employee> findEmployeeByPostalCode(String postalCode) {
        String hql="SELECT e from Employee e INNER join Address a on e.id = a.employee.id where a.postalCode= :postalCode";
        Query<Employee> query = session.createQuery(hql, Employee.class);
        query.setParameter("postalCode",postalCode);
        List<Employee> resultList = query.getResultList();
        return resultList;

    }

    @Override
    public List<Employee> findEmployeeByTelNumber(String telNumber) {
        String hql="SELECT e from Employee e INNER join Address a on  e.id =a.employee.id inner join PhoneNumbers p " +
                "on a.id=p.address.id WHERE p.telNumber= :telNumber";
        Query<Employee> query = session.createQuery(hql, Employee.class);
        query.setParameter("telNumber",telNumber);
        return query.getResultList();
    }

    @Override
    public List<Employee> findEmployeeByCity(String city) {
        String hql="SELECT e from Employee e INNER join  Address a on e.id = a.employee.id WHERE a.city= :city";
        Query<Employee> query = session.createQuery(hql, Employee.class);
        query.setParameter("city",city);
        return query.getResultList();
    }

    @Override
    public List<Employee> findEmployeeByNumberPrefix(String prefix) {
        prefix = "0912";
        String hql="SELECT e from Employee e INNER join Address  a on e.id =a.employee.id inner join  " +
                "PhoneNumbers p  on a.id =p.address.id WHERE p.mobNumber like :prefix ";
        Query<Employee> query = session.createQuery(hql, Employee.class);
        query.setParameter("prefix",prefix+"%");
        return query.getResultList();
    }

    @Override
    public List<Employee> findEmployeeByPrefixAndCity(String prefix, String city) {
        String hql="SELECT e from Employee e INNER join Address a on e.id = a.employee.id inner join PhoneNumbers p  " +
                "on a.id = p.address.id WHERE p.mobNumber like :prefix  and a.city= :city ";
        Query<Employee> query = session.createQuery(hql, Employee.class);
        query.setParameter("prefix",prefix+"%");
        query.setParameter("city",city);
        return query.getResultList();
    }

//    @Override
//    public List<Employee> findEmployeeBasedOnHighestSalaryInCity(String city) {
//        String sql="SELECT * FROM employee e1 INNER JOIN address a1 ON e1.id = a1.employee_id WHERE e1.salary=(SELECT max(salary) FROM employee e2 INNER JOIN address a2 ON e2.id = a2.employee_id WHERE a2.city=a1.city) ";
//        NativeQuery<Employee> query=session.createNativeQuery(sql,Employee.class);
//        List<Employee> resultList = query.getResultList();
//        return resultList;
//
//    }
    @Override
    public List<Employee> findEmployeeBasedOnHighestSalaryInCity(String city) {
        String sql= "SELECT * FROM employee e1 INNER JOIN address a1 ON e1.id = a1.employee_id WHERE a1.city =? AND e1.salary = (SELECT MAX(salary) FROM employee e2 INNER JOIN address a2 ON e2.id = a2.employee_id WHERE a2.city =?) ";
        Query<Employee> query=session.createNativeQuery(sql,Employee.class);
        query.setParameter(1,city);
        query.setParameter(2,city);
        return query.getResultList();
    }
}
