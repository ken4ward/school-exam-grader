package io.school.apps.service.serviceinterface;

import io.school.apps.model.Student;
import io.school.apps.model.Teacher;
import org.springframework.http.ResponseEntity;

public interface StudentInterface {

    public Student save(Student student, Long manager_id );
    public Student update(Long mamager_id, Long class_id, Student student);
    public ResponseEntity<?> delete(Long manager_id, Long class_id);
}
