package software.jevera.dao;

import software.jevera.domain.Employee;

import java.util.Optional;

public interface EmployeeRepository {

    boolean isEmployeeExist(String fullName);
    Optional<Employee> findByName(String fullName);
    Employee saveEmployee(Employee employee);
    Employee getEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    Employee deleteEmployee(Employee employee);
    Employee searchByPosition(Employee employee);
    Employee searchByExperience(Employee employee);
    Employee searchByWorkplace(Employee employee);
    Employee multiSearch(Employee employee);
}
