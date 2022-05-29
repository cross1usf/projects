package cross1usf.firstproject.service;

import cross1usf.firstproject.dto.CommentsDto;
import cross1usf.firstproject.mappers.CommentsMapper;
import cross1usf.firstproject.model.Post;
import cross1usf.firstproject.model.PostComment;
import cross1usf.firstproject.repository.CommentRepository;
import cross1usf.firstproject.repository.PostRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final AuthService authService;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private CommentsMapper commentsMapper;


    public void save(CommentsDto commentsDto) {
        Post post = postRepository.findById(commentsDto.getPostId()).orElseThrow(() -> new RuntimeException("Post Not found"));
        PostComment postComment = PostComment.builder()
                .post(post)
                .user(authService.getUser())
                .description(commentsDto.getDescription())
                .dateCreated(Instant.now())
                .build();
        commentRepository.save(postComment);

    }

    public List<CommentsDto> getComments(Integer id){
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post Does not Exist"));
        return commentRepository.findByPost(post)
                .stream().map(commentsMapper::mapToDto)
                .collect(toList());
    }
}
