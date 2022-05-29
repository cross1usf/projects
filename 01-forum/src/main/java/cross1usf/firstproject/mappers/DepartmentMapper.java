package cross1usf.firstproject.mappers;

import cross1usf.firstproject.dto.DepartmentDto;
import cross1usf.firstproject.model.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {


    Department map(DepartmentDto departmentDto);

}
