package com.apodlatov.test.respak.controllers.technics.models;

import com.apodlatov.test.respak.controllers.technics.models.dto.incoming.GetTechnicsModelsByIdsDto;
import com.apodlatov.test.respak.service.api.TechnicsModelsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller("api_v1/technics_models/")
public class TechnicsModelsController {

    private final TechnicsModelsService technicsModelsService;

    @PostMapping
    public ResponseEntity<?> getTechnicsModelsByIds(
            @RequestBody GetTechnicsModelsByIdsDto dto) {

    }
}
