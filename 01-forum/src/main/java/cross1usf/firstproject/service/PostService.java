package cross1usf.firstproject.service;

import cross1usf.firstproject.dto.PostRequest;
import cross1usf.firstproject.exceptions.TokenNotFoundException;
import cross1usf.firstproject.model.Post;
import cross1usf.firstproject.model.Topic;
import cross1usf.firstproject.model.security.User;
import cross1usf.firstproject.repository.PostRepository;
import cross1usf.firstproject.repository.TopicRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class PostService {

    private final AuthService authService;
    private final TopicRepository topicRepository;
    private final PostRepository postRepository;


    public Post save(PostRequest postRequest) {
        Topic topic = topicRepository.findByName(postRequest.getTopic()).orElseThrow(() ->new TokenNotFoundException("Cannont find topic"));
        User user = authService.getUser();
        Post post = Post.builder()
                .postName(postRequest.getPostName())
                .postDescription(postRequest.getPostDescription())
                .topic(topic)
                .user(user)
                .LikeCount(0)
                .build();
        postRepository.save(post);
        return post;
    }


}
