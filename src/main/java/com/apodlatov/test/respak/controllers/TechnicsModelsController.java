package com.apodlatov.test.respak.controllers;

import com.apodlatov.test.respak.controllers.dto.DtoMapper;
import com.apodlatov.test.respak.controllers.dto.incoming.GetTechnicsModelsByIdsDto;
import com.apodlatov.test.respak.controllers.dto.outgoing.TechnicsModelDto;
import com.apodlatov.test.respak.controllers.dto.outgoing.TechnicsModelOptionDto;
import com.apodlatov.test.respak.data.models.TechnicsModel;
import com.apodlatov.test.respak.data.models.option.ModelOptionValue;
import com.apodlatov.test.respak.service.api.TechnicsModelsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api_v1/technics_models/")
public class TechnicsModelsController {
    private final TechnicsModelsService technicsModelsService;
    private final DtoMapper dtoMapper;

    public TechnicsModelsController(TechnicsModelsService technicsModelsService, DtoMapper dtoMapper) {
        this.technicsModelsService = technicsModelsService;
        this.dtoMapper = dtoMapper;
    }

    @PostMapping("get_by_ids")
    public ResponseEntity<List<TechnicsModelDto>> getTechnicsModelsByIds(
            @RequestBody GetTechnicsModelsByIdsDto dto) {
        List<TechnicsModelDto> dtos =
                technicsModelsService.getTechnicsModelsByIds(dto.getIds()).stream()
                        .map(dtoMapper::mapToTechnicsModelDto)
                        .collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }
}