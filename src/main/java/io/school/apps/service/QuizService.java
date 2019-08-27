package io.school.apps.service;

import io.school.apps.model.Quiz;
import io.school.apps.model.Student;
import io.school.apps.model.Teacher;
import io.school.apps.repository.QuizRepository;
import io.school.apps.repository.TeacherRepository;
import io.school.apps.service.serviceinterface.QuizInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class QuizService implements QuizInterface {

    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public Quiz save(Quiz quiz, Long teacher_id ){
        return teacherRepository.findById(teacher_id)
                .map( teacher -> { quiz.setTeacher(teacher);
                    return quizRepository.save(quiz);
                }).orElseThrow(()-> new NoSuchElementException());
    }

    @Override
    public Quiz update(Long teacher_id, Long quiz_id, Quiz quiz) {
        if(!teacherRepository.existsById(teacher_id)) {
            throw new NoSuchElementException("Manager " + teacher_id + " not found");
        }
        return quizRepository.findById(quiz_id).map(myQuiz -> {
            myQuiz.setQuizName(quiz.getQuizName());
            return quizRepository.save(myQuiz);
        }).orElseThrow(() -> new NoSuchElementException("Class  id  " + quiz_id + "  not found"));
    }

    public Page<Quiz> getAll(Long teacher_id , Pageable pageable) {
        return quizRepository.findByTeacherId(teacher_id, pageable);
    }

    @Override
    public ResponseEntity<?> delete(Long teacher_id, Long quiz_id) {
        return null;
    }
}
