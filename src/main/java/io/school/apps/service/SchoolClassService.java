package io.school.apps.service;

import io.school.apps.model.SchoolClass;
import io.school.apps.repository.ManagerRepository;
import io.school.apps.repository.SchoolClassRepository;
import io.school.apps.service.serviceinterface.SchoolClassInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class SchoolClassService implements SchoolClassInterface {

    @Autowired
    private SchoolClassRepository schoolClassRepository;
    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public SchoolClass save( SchoolClass schoolClass, Long manager_id ){
        return managerRepository.findById(manager_id)
                .map( manager -> { schoolClass.setManager(manager);
                    return schoolClassRepository.save(schoolClass);
                }).orElseThrow(()-> new NoSuchElementException());
    }

    @Override
    public SchoolClass update(Long mamager_id, Long class_id, SchoolClass schoolClass) {

        if(!managerRepository.existsById(mamager_id)) {
            throw new NoSuchElementException("Manager " + mamager_id + " not found");
        }
        return schoolClassRepository.findById(class_id).map(myclass -> {
            myclass.setSchoolClassName(schoolClass.getSchoolClassName());
            return schoolClassRepository.save(myclass);
        }).orElseThrow(() -> new NoSuchElementException("Class  id  " + class_id + "  not found"));
    }

    @Override
    public ResponseEntity<?> delete(Long class_id, Long manager_id) {

        return null;
    }

    public Page<SchoolClass> getAllclasses( Long manager_id , Pageable pageable) {
        return schoolClassRepository.findByManagerId(manager_id, pageable);
    }
}
