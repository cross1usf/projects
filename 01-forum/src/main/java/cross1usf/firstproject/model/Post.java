package cross1usf.firstproject.model;


import cross1usf.firstproject.model.security.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    @NotBlank(message = "Post Requires a name")
    private String postName;
    @NotBlank(message = "Post Requires a description")
    @Lob
    private String postDescription;
    @Builder.Default
    private Integer LikeCount = 0;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "topicId", referencedColumnName = "topicId")
    private Topic topic;



}
