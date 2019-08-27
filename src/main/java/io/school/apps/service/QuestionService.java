package io.school.apps.service;

import io.school.apps.model.Question;
import io.school.apps.model.Quiz;
import io.school.apps.repository.QuestionRepository;
import io.school.apps.repository.QuizRepository;
import io.school.apps.repository.TeacherRepository;
import io.school.apps.service.serviceinterface.QuestionInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class QuestionService implements QuestionInterface {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    QuizRepository quizRepository;

    @Override
    public Question save(Question question, Long quiz_id ){
        return quizRepository.findById(quiz_id)
                .map( quiz -> { question.setQuiz(quiz);
                    return questionRepository.save(question);
                }).orElseThrow(()-> new NoSuchElementException());
    }

    @Override
    public Question update(Long quiz_id, Long question_id, Question question) {
        if(!quizRepository.existsById(quiz_id)) {
            throw new NoSuchElementException("Quiz " + quiz_id + " not found");
        }
        return questionRepository.findById(question_id).map(myQuestion -> {
            myQuestion.setQuestionName(question.getQuestionName());
            return questionRepository.save(myQuestion);
        }).orElseThrow(() -> new NoSuchElementException("Class  id  " + question_id + "  not found"));
    }

    public Page<Question> getAll(Long question_id , Pageable pageable) {
        return questionRepository.findByQuizId(question_id, pageable);
    }

    @Override
    public ResponseEntity<?> delete(Long teacher_id, Long quiz_id) {
        return null;
    }

}
