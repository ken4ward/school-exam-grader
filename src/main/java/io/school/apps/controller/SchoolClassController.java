package io.school.apps.controller;

import io.school.apps.model.SchoolClass;
import io.school.apps.repository.SchoolClassRepository;
import io.school.apps.service.SchoolClassService;
import io.school.apps.service.serviceinterface.SchoolClassInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/school/manager")
public class SchoolClassController {

    @Autowired
    private SchoolClassInterface schoolClassInterface;
    @Autowired
    private SchoolClassRepository schoolClassRepository;

    @RequestMapping( value = "/{id}/class", method = RequestMethod.POST)
    public SchoolClass save(@RequestBody @Valid SchoolClass schoolClass, @PathVariable(value = "id") Long id){
        return schoolClassInterface.save(schoolClass, id);
    }

    @RequestMapping( value = "/{id}/class", method = RequestMethod.GET)
    public Page<SchoolClass> getAllClassesByManagerId(@PathVariable (value = "id") Long manager_id, Pageable pageable) {
        return schoolClassRepository.findByManagerId(manager_id, pageable);
    }

    @RequestMapping( value = "/{id}/class/{class_id}", method = RequestMethod.PUT)
    public SchoolClass updateClass(@PathVariable (value = "id") Long id, @PathVariable (value = "class_id") Long class_id,
                                   @Valid @RequestBody SchoolClass schoolClass){
        return schoolClassInterface.update( id, class_id, schoolClass );
    }

    @RequestMapping( value = "/{id}/class/{class_id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteClass( @PathVariable (value = "id") Long id, @PathVariable (value = "class_id") Long class_id ){
        return schoolClassInterface.delete(id, class_id);
    }
}
