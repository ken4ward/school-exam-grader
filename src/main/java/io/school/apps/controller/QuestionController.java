package io.school.apps.controller;


import io.school.apps.model.Quiz;
import io.school.apps.repository.QuestionRepository;
import io.school.apps.repository.QuizRepository;
import io.school.apps.service.serviceinterface.QuestionInterface;
import io.school.apps.service.serviceinterface.QuizInterface;
import io.school.apps.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/school/teacher")
public class QuestionController {

    @Autowired
    private QuestionInterface questionInterface;
    @Autowired
    private QuestionRepository questionRepository;

    @RequestMapping( value = "/{id}/question", method = RequestMethod.POST)
    public Question save(@RequestBody @Valid Question question, @PathVariable(value = "id") Long id){
        return questionInterface.save(question, id);
    }

    @RequestMapping( value = "/{id}/question", method = RequestMethod.GET)
    public Page<Question> getAllQuestionById(@PathVariable (value = "id") Long quiz_id, Pageable pageable) {
        return questionRepository.findByQuizId(quiz_id, pageable);
    }

    @RequestMapping( value = "/{id}/question/{question_id}", method = RequestMethod.PUT)
    public Question updateQuestion(@PathVariable (value = "id") Long id, @PathVariable (value = "question_id") Long question_id,
                           @Valid @RequestBody Question question){
        return questionInterface.update( id, question_id, question );
    }

    @RequestMapping( value = "/{id}/question/{question_id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteQuestion(@PathVariable (value = "id") Long id, @PathVariable (value = "question_id") Long question_id ){
        return questionInterface.delete(id, question_id);
    }

}
