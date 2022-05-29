package cross1usf.firstproject.repository;

import cross1usf.firstproject.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {

    Optional<Topic> findByName(String topicName);
}
