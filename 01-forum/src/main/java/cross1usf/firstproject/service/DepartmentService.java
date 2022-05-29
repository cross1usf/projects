package cross1usf.firstproject.service;

import cross1usf.firstproject.dto.DepartmentDto;
import cross1usf.firstproject.mappers.DepartmentMapper;
import cross1usf.firstproject.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private DepartmentMapper departmentMapper;


    public void save(DepartmentDto departmentDto) {
        departmentRepository.save(departmentMapper.map(departmentDto));

    }
}
