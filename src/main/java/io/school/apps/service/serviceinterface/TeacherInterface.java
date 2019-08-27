package io.school.apps.service.serviceinterface;

import io.school.apps.model.SchoolClass;
import io.school.apps.model.Teacher;
import org.springframework.http.ResponseEntity;

public interface TeacherInterface {

    public Teacher save(Teacher teacher, Long manager_id );
    public Teacher update(Long mamager_id, Long class_id, Teacher teacher);
    public ResponseEntity<?> delete(Long manager_id, Long class_id);

}
