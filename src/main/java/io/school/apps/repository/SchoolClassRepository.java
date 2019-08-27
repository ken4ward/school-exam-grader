package io.school.apps.repository;

import io.school.apps.model.SchoolClass;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long> {
    public Page<SchoolClass> findByManagerId(Long manager_id, Pageable pageable);
}
