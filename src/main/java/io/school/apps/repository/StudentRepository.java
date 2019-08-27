package io.school.apps.repository;

import io.school.apps.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public Page<Student> findByManagerId(Long manager_id, Pageable pageable);
}
