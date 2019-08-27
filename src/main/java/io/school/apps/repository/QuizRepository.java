package io.school.apps.repository;

import io.school.apps.model.Quiz;
import io.school.apps.model.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    public Page<Quiz> findByTeacherId(Long teacher_id, Pageable pageable);
}
