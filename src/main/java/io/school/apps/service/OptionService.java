package io.school.apps.service;

import io.school.apps.model.Option;
import io.school.apps.service.serviceinterface.OptionInterface;
import org.springframework.http.ResponseEntity;

public class OptionService implements OptionInterface {

    

    @Override
    public Option save(Option option, Long option_id) {
        return null;
    }

    @Override
    public Option update(Long question_id, Long option_id, Option option) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long question_id, Long option_id) {
        return null;
    }
}
