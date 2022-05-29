package cross1usf.firstproject.model;

import cross1usf.firstproject.model.security.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Topic {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer topicId;
    @NotBlank(message = "Topic Name Required")
    private String name;
    @NotBlank(message = "Description Required")
    private String description;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Post> posts;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
