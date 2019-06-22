package software.jevera.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import software.jevera.service.position.EmployeeSex;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "fullName")
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String fullName;
    private Instant dateOfBirth;
    @Enumerated
    private EmployeeSex sex;
    private String nationality;
    private String workLocation;
    private Instant startOfWork;
    @JsonIgnore
    private String passwordHash;
    ////////////
    @OneToMany(mappedBy = "employee")
    private List<Position> positions = new ArrayList<>();
    private String currentPosition;

}
