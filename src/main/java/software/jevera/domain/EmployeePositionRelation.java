package software.jevera.domain;

import javax.persistence.*;

@Entity
public class EmployeePositionRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "employee")
    private Employee currentPositionEmployee;
    @OneToOne(mappedBy = "employee")
    private Employee fullNameEmployee;
    @OneToOne(mappedBy = "position")
    private Position idPosition;
    @OneToOne(mappedBy = "position")
    private Position parentPositionEmployee;
}
