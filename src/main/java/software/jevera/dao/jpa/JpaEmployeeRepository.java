package software.jevera.dao.jpa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import software.jevera.dao.EmployeeRepository;
import software.jevera.domain.Employee;

import javax.persistence.EntityManagerFactory;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class JpaEmployeeRepository implements EmployeeRepository {

    private final EntityManagerFactory entityManagerFactory;

    @Override
    public boolean isEmployeeExist(String fullName) {
        return false;
    }

    @Override
    public Optional<Employee> findByName(String fullName) {
        return Optional.empty();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return null;
    }

    @Override
    public Employee getEmployee(Employee employee) {
        return null;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public Employee deleteEmployee(Employee employee) {
        return null;
    }

    @Override
    public Employee searchByPosition(Employee employee) {
        return null;
    }

    @Override
    public Employee searchByExperience(Employee employee) {
        return null;
    }

    @Override
    public Employee searchByWorkplace(Employee employee) {
        return null;
    }

    @Override
    public Employee multiSearch(Employee employee) {
        return null;
    }
}
