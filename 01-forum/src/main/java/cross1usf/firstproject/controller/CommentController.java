package cross1usf.firstproject.controller;

import cross1usf.firstproject.dto.CommentsDto;
import cross1usf.firstproject.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@AllArgsConstructor
public class CommentController {

    private final CommentService commentService;

   /* @PostMapping
    public ResponseEntity<String> createComment(@RequestBody CommentsDto commentsDto) {
        commentService.save(commentsDto);
        return new ResponseEntity<>("Comment Saved", HttpStatus.CREATED);
    }*/

    /*@GetMapping("/api/{id}")
    public List<CommentsDto> getCommentsOfPost(@PathVariable Integer id) {
        return commentService.getComments(id);
    }*/

}
