package io.school.apps.service.serviceinterface;

import io.school.apps.model.Option;
import org.springframework.http.ResponseEntity;

public interface OptionInterface {

    public Option save(Option option, Long option_id );
    public Option update(Long question_id, Long option_id, Option option);
    public ResponseEntity<?> delete(Long question_id, Long option_id);

}
