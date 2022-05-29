package cross1usf.firstproject.repository;

import cross1usf.firstproject.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course,Integer > {
    Optional<Course> findByName(String name);
}
