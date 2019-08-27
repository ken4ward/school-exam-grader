package io.school.apps.service;

import io.school.apps.model.SchoolClass;
import io.school.apps.model.Teacher;
import io.school.apps.repository.ManagerRepository;
import io.school.apps.repository.SchoolClassRepository;
import io.school.apps.repository.TeacherRepository;
import io.school.apps.service.serviceinterface.TeacherInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TeacherService implements TeacherInterface {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public Teacher save(Teacher teacher, Long manager_id ){
        return managerRepository.findById(manager_id)
                .map( manager -> { teacher.setManager(manager);
                    return teacherRepository.save(teacher);
                }).orElseThrow(()-> new NoSuchElementException());
    }

    @Override
    public Teacher update(Long mamager_id, Long teacher_id, Teacher teacher) {
        if(!managerRepository.existsById(mamager_id)) {
            throw new NoSuchElementException("Manager " + mamager_id + " not found");
        }
        return teacherRepository.findById(teacher_id).map(myteacher -> {
            myteacher.setTeacherName(teacher.getTeacherName());
            return teacherRepository.save(myteacher);
        }).orElseThrow(() -> new NoSuchElementException("Teacher  id  " + teacher_id + "  not found"));
    }

    @Override
    public ResponseEntity<?> delete(Long class_id, Long manager_id) {

        return null;
    }

    public Page<Teacher> getAll( Long manager_id , Pageable pageable) {
        return teacherRepository.findByManagerId(manager_id, pageable);
    }
}
