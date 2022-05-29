package cross1usf.firstproject.repository;

import cross1usf.firstproject.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
