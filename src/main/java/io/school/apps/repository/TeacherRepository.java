package io.school.apps.repository;

import io.school.apps.model.SchoolClass;
import io.school.apps.model.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    public Page<Teacher> findByManagerId(Long manager_id, Pageable pageable);
}
