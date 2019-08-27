package io.school.apps.controller;

import io.school.apps.model.Student;
import io.school.apps.model.Teacher;
import io.school.apps.repository.StudentRepository;
import io.school.apps.repository.TeacherRepository;
import io.school.apps.service.StudentService;
import io.school.apps.service.serviceinterface.StudentInterface;
import io.school.apps.service.serviceinterface.TeacherInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/school/manager")
public class StudentController {

    @Autowired
    private StudentInterface studentInterface;
    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping( value = "/{id}/student", method = RequestMethod.POST)
    public Student save(@RequestBody @Valid Student student, @PathVariable(value = "id") Long id){
        return studentInterface.save(student, id);
    }

    @RequestMapping( value = "/{id}/student", method = RequestMethod.GET)
    public Page<Student> getAllStudentByManagerId(@PathVariable (value = "id") Long manager_id, Pageable pageable) {
        return studentRepository.findByManagerId(manager_id, pageable);
    }

    @RequestMapping( value = "/{id}/student/{student_id}", method = RequestMethod.PUT)
    public Student updateStudent(@PathVariable (value = "id") Long id, @PathVariable (value = "student_id") Long student_id,
                                 @Valid @RequestBody Student student){
        return studentInterface.update( id, student_id, student );
    }

    @RequestMapping( value = "/{id}/student/{student_id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteStudent( @PathVariable (value = "id") Long id, @PathVariable (value = "student_id") Long student_id ){
        return studentInterface.delete(id, student_id);
    }

}
