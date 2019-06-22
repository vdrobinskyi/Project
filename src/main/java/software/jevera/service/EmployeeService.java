package software.jevera.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.jevera.dao.EmployeeRepository;
import software.jevera.domain.Employee;
import software.jevera.domain.dto.EmployeeDto;
import software.jevera.exceptions.EmployeeAlreadyExist;
import software.jevera.exceptions.UnccorectPassword;

import java.math.BigInteger;
import java.security.MessageDigest;

@RequiredArgsConstructor
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee registration(EmployeeDto employeeDto){

    if(employeeRepository.isEmployeeExist(employeeDto.getFullName())){
        throw new EmployeeAlreadyExist(employeeDto.getFullName());
    }

    Employee employee = new Employee();
    employee.setFullName(employeeDto.getFullName());
    employee.setPasswordHash(encryptPassword(employeeDto.getPassword()));
    employee.setDateOfBirth(employeeDto.getDateOfBirth());
    employee.setNationality(employeeDto.getNationality());
    employee.setSex(employeeDto.getSex());
    employee.setStartOfWork(employeeDto.getStartOfWork());
    employee.setWorkLocation(employeeDto.getWorkLocation());
    employee.setCurrentPosition(employeeDto.getCurrentPosition());

    return employeeRepository.saveEmployee(employee);

    }

    public Employee getAllEmployees(Employee employee){

        return employeeRepository.getEmployee(employee);

    }

    public Employee deleteEmployee(Employee employee){

        return null;

    }

    public Employee updateEmployee(Employee employee){

//        employee.getCurrentPosition(employee.setCurrentPosition());
        return null;
    }

    public Employee login(EmployeeDto employeeDto){
        return employeeRepository.findByName(employeeDto.getFullName())
                .filter(employee -> checkPassword(employeeDto, employee))
                .orElseThrow(UnccorectPassword::new);
    }

    private boolean checkPassword(EmployeeDto employeeDto, Employee employee) {
        String encryptPassword = encryptPassword(employeeDto.getPassword());
        return encryptPassword.equals(employee.getPasswordHash());
    }

    @SneakyThrows
    private String encryptPassword(String password) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(password.getBytes());
            return new BigInteger(1,messageDigest.digest()).toString(16);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
