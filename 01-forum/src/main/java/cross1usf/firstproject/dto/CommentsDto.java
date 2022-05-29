package cross1usf.firstproject.dto;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentsDto {


    private Integer postId;
    private String description;
    private Instant dateCreated;

}
