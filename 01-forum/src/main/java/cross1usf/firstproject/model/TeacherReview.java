package cross1usf.firstproject.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TeacherReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Lob
    @NotBlank
    private String description;
    @NotBlank
    private Integer rating;

    @ManyToOne
    private Teacher teacher;

}
