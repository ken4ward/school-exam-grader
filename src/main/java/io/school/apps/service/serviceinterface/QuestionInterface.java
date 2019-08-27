package io.school.apps.service.serviceinterface;

import io.school.apps.model.Question;
import io.school.apps.model.Quiz;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface QuestionInterface {

    public Question save(Question question, Long quiz_id );
    public Question update(Long quiz_id, Long question_id, Question question);
    public ResponseEntity<?> delete(Long teacher_id, Long quiz_id);
}
