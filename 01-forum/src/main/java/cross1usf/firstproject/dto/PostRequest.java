package cross1usf.firstproject.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {

    private Long postId;
    private String topic;
    private String postName;
    private String postDescription;


}
