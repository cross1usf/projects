package cross1usf.firstproject.repository;

import cross1usf.firstproject.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

    Optional<Teacher> findByCourse(String course);
    Optional<Teacher> findByDepartment(String department);
}
