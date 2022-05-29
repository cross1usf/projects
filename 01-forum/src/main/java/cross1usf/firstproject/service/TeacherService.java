package cross1usf.firstproject.service;

import cross1usf.firstproject.dto.TeacherDto;
import cross1usf.firstproject.mappers.TeacherMapper;
import cross1usf.firstproject.model.Course;
import cross1usf.firstproject.repository.CourseRepository;
import cross1usf.firstproject.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;
    private TeacherMapper teacherMapper;


    public void save(TeacherDto teacherDto) {
        Course course = courseRepository.findByName(String.valueOf(teacherDto.getCourse()))
                .orElseThrow(() -> new RuntimeException("Course not Found"));
        teacherRepository.save(teacherMapper.map(teacherDto,course));
        }

}

