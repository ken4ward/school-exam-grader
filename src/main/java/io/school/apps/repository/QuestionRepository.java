package io.school.apps.repository;

import io.school.apps.model.Question;
import io.school.apps.model.Quiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    public Page<Question> findByQuizId(Long quiz_id, Pageable pageable);
}
