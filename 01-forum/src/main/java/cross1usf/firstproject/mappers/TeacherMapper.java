package cross1usf.firstproject.mappers;

import cross1usf.firstproject.dto.TeacherDto;
import cross1usf.firstproject.model.Course;
import cross1usf.firstproject.model.Teacher;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;


public class TeacherMapper {


    public Teacher map(TeacherDto teacherDto, Course course) {
        Teacher teacher = Teacher.builder()
                .name(teacherDto.getName())
                .course(teacherDto.getCourse())
                .department(course.getDepartment())
                .build();
        return teacher;
    }


}
