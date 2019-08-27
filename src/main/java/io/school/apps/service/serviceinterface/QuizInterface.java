package io.school.apps.service.serviceinterface;

import io.school.apps.model.Quiz;
import io.school.apps.model.SchoolClass;
import org.springframework.http.ResponseEntity;

public interface QuizInterface {

    public Quiz save(Quiz quiz, Long teacher_id );
    public Quiz update(Long teacher_id, Long class_id, Quiz quiz);
    public ResponseEntity<?> delete(Long teacher_id, Long quiz_id);

}
