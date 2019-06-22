package software.jevera.web;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import software.jevera.domain.Employee;
import software.jevera.domain.dto.EmployeeDto;
import software.jevera.service.EmployeeService;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final HttpSession httpSession;

    @PostMapping(value = "/registration")
    public Employee registration(EmployeeDto employeeDto){
        return employeeService.registration(employeeDto);
    }

    @PostMapping(value = "/login")
    public Employee login(EmployeeDto employeeDto){
        Employee employee = employeeService.login(employeeDto);
        httpSession.setAttribute("employee", employee);
        return employee;
    }

//    public Employee findEmployee(){
////
////    }
}
