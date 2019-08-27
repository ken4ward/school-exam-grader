package io.school.apps.service;

import io.school.apps.model.Student;
import io.school.apps.model.Teacher;
import io.school.apps.repository.ManagerRepository;
import io.school.apps.repository.StudentRepository;
import io.school.apps.repository.TeacherRepository;
import io.school.apps.service.serviceinterface.StudentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StudentService implements StudentInterface {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public Student save(Student student, Long manager_id ){
        return managerRepository.findById(manager_id)
                .map( manager -> { student.setManager(manager);
                    return studentRepository.save(student);
                }).orElseThrow(()-> new NoSuchElementException());
    }

    @Override
    public Student update(Long mamager_id, Long student_id, Student student) {
        if(!managerRepository.existsById(mamager_id)) {
            throw new NoSuchElementException("Manager " + mamager_id + " not found");
        }
        return studentRepository.findById(student_id).map(myStudent -> {
            myStudent.setStudentName(student.getStudentName());
            return studentRepository.save(myStudent);
        }).orElseThrow(() -> new NoSuchElementException("Class  id  " + student_id + "  not found"));
    }

    @Override
    public ResponseEntity<?> delete(Long class_id, Long manager_id) {

        return null;
    }

    public Page<Student> getAll(Long manager_id , Pageable pageable) {
        return studentRepository.findByManagerId(manager_id, pageable);
    }

}
