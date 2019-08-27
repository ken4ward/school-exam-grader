package io.school.apps.controller;

import io.school.apps.model.SchoolClass;
import io.school.apps.model.Teacher;
import io.school.apps.repository.SchoolClassRepository;
import io.school.apps.repository.TeacherRepository;
import io.school.apps.service.TeacherService;
import io.school.apps.service.serviceinterface.SchoolClassInterface;
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
public class TeacherController {

    @Autowired
    private TeacherInterface teacherInterface;
    @Autowired
    private TeacherRepository teacherRepository;

    @RequestMapping( value = "/{id}/teacher", method = RequestMethod.POST)
    public Teacher save(@RequestBody @Valid Teacher teacher, @PathVariable(value = "id") Long id){
        return teacherInterface.save(teacher, id);
    }

    @RequestMapping( value = "/{id}/teacher", method = RequestMethod.GET)
    public Page<Teacher> getAllTeacherByManagerId(@PathVariable (value = "id") Long manager_id, Pageable pageable) {
        return teacherRepository.findByManagerId(manager_id, pageable);
    }

    @RequestMapping( value = "/{id}/teacher/{teacher_id}", method = RequestMethod.PUT)
    public Teacher updateTeacher(@PathVariable (value = "id") Long id, @PathVariable (value = "teacher_id") Long teacher_id,
                                   @Valid @RequestBody Teacher teacher){
        return teacherInterface.update( id, teacher_id, teacher );
    }

    @RequestMapping( value = "/{id}/teacher/{teacher_id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteTeacher( @PathVariable (value = "id") Long id, @PathVariable (value = "class_id") Long class_id ){
        return teacherInterface.delete(id, class_id);
    }
}
