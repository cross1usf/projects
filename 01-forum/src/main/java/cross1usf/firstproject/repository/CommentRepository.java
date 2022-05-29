package cross1usf.firstproject.repository;

import cross1usf.firstproject.model.Post;
import cross1usf.firstproject.model.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<PostComment, Integer> {
    List<PostComment> findByPost(Post post);
}
