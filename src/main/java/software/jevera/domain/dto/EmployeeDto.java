package software.jevera.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.jevera.service.position.EmployeeSex;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private String fullName;
    private Instant dateOfBirth;
    private EmployeeSex sex;
    private String nationality;
    private String workLocation;
    private Instant startOfWork;
    private String password;
    private String currentPosition;
}
