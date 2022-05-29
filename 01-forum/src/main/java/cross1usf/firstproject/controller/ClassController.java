package cross1usf.firstproject.controller;

import cross1usf.firstproject.dto.DepartmentDto;
import cross1usf.firstproject.dto.TeacherDto;
import cross1usf.firstproject.service.DepartmentService;
import cross1usf.firstproject.service.TeacherService;
import io.swagger.models.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ClassController {

    private final TeacherService teacherService;
    private final DepartmentService departmentService;

    @GetMapping("/newteacher")
    public ResponseEntity<String> saveTeacher(TeacherDto teacherDto) {
        teacherService.save(teacherDto);
        return new ResponseEntity<>("Teacher saved!", HttpStatus.CREATED);
    }


    @PostMapping("/newdepartment")
    public ResponseEntity<String> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        departmentService.save(departmentDto);
        return new ResponseEntity<>("Department Saved", HttpStatus.CREATED);
    }




}
