package software.jevera.domain;

import lombok.*;
import software.jevera.service.position.ProfessionalityLevel;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "name")
@Entity
@Table(name = "position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String abbreviation;
    private String attribute;
    private String parentPosition;
    @Enumerated
    private ProfessionalityLevel professionalLevel;
}
