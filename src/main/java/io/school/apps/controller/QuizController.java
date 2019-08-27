package io.school.apps.controller;

import io.school.apps.model.Quiz;
import io.school.apps.model.Teacher;
import io.school.apps.repository.QuizRepository;
import io.school.apps.repository.TeacherRepository;
import io.school.apps.service.serviceinterface.QuizInterface;
import io.school.apps.service.serviceinterface.TeacherInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/school/teacher")
public class QuizController {

    @Autowired
    private QuizInterface quizInterface;
    @Autowired
    private QuizRepository quizRepository;

    @RequestMapping( value = "/{id}/quiz", method = RequestMethod.POST)
    public Quiz save(@RequestBody @Valid Quiz quiz, @PathVariable(value = "id") Long id){
        return quizInterface.save(quiz, id);
    }

    @RequestMapping( value = "/{id}/quiz", method = RequestMethod.GET)
    public Page<Quiz> getAllQuizByManagerId(@PathVariable (value = "id") Long teacher_id, Pageable pageable) {
        return quizRepository.findByTeacherId(teacher_id, pageable);
    }

    @RequestMapping( value = "/{id}/quiz/{quiz_id}", method = RequestMethod.PUT)
    public Quiz updateQuiz(@PathVariable (value = "id") Long id, @PathVariable (value = "quiz_id") Long quiz_id,
                                 @Valid @RequestBody Quiz quiz){
        return quizInterface.update( id, quiz_id, quiz );
    }

    @RequestMapping( value = "/{id}/quiz/{quiz_id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteQuiz(@PathVariable (value = "id") Long id, @PathVariable (value = "quiz_id") Long quiz_id ){
        return quizInterface.delete(id, quiz_id);
    }

}
