package io.school.apps.service;

import io.school.apps.model.Manager;
import io.school.apps.model.Teacher;
import io.school.apps.repository.ManagerRepository;
import io.school.apps.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    public Manager save(Manager manager ) {
        return managerRepository.save(manager);
    }

    public Manager fetchManagerById(Long id){
        Optional<Manager> managerOptional = managerRepository.findById(id);
        if ( managerOptional.isPresent() ) {
            return managerOptional.get();
        } else return null;
    }

    public List<Manager> getAllManager(){
        List<Manager> managerOptional = managerRepository.findAll();
        if (managerOptional.isEmpty()) {
            return null;
        } else return managerOptional;
    }

    public Manager updateManagerById( Long id, Manager manager){
        Optional<Manager> managerOptional = managerRepository.findById(id);
        if (managerOptional.isPresent()) {
            managerOptional.get().setManagerName(manager.getManagerName());
            return managerRepository.save(manager);
        } else return null;
    }

    public void deleteManager( Long id ) {
        if (managerRepository.getOne(id).equals(null)) {
            return;
        } else managerRepository.deleteById(id);
    }

}
