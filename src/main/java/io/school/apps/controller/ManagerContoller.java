package io.school.apps.controller;

import io.school.apps.model.Manager;
import io.school.apps.model.Teacher;
import io.school.apps.service.ManagerService;
import io.school.apps.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/school")
public class ManagerContoller {

    @Autowired
    private ManagerService managerService;

    @RequestMapping( value = "/manager", method = RequestMethod.POST)
    public Manager save(@RequestBody Manager manager ){
        return managerService.save(manager);
    }

    @RequestMapping( value = "/manager/{id}", method = RequestMethod.GET)
    public ResponseEntity<Manager> fetchManagerById(@PathVariable(value = "id") Long id ){
        Manager manager = managerService.fetchManagerById(id);
        if ( manager == null ) {
            return ResponseEntity.notFound().build();
        } else return ResponseEntity.ok().body(manager);
    }

    @RequestMapping( value = "/manager", method = RequestMethod.GET)
    public List<Manager> getAllManger(){
        return managerService.getAllManager();
    }

    @RequestMapping( value = "/manager/{id}", method = RequestMethod.PUT)
    public Manager updateManager(@Valid @PathVariable(value = "id") Long id, @Valid @RequestBody Manager manager){
        Manager updatedManager =  managerService.updateManagerById(id, manager);
        if ( manager == null ) {
            return null;
        } else return updatedManager;
    }

    @RequestMapping( value = "/manager/{id}", method = RequestMethod.DELETE)
    public void deleteTeacher( @PathVariable Long id){
        managerService.deleteManager(id);
    }

}
