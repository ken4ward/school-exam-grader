package io.school.apps.service.serviceinterface;

import io.school.apps.model.SchoolClass;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface SchoolClassInterface {

    public SchoolClass save(SchoolClass schoolClass, Long manager_id );
    public SchoolClass update(Long mamager_id, Long class_id, SchoolClass schoolClass);
    public ResponseEntity<?> delete(Long manager_id, Long class_id);

}
