package cross1usf.firstproject.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;

    @ManyToMany
    private Set<Course> course;

    @OneToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;



}
