package com.apodlatov.test.respak.controllers.api_v1;

import com.apodlatov.test.respak.controllers.api_v1.dto.DtoMapper;
import com.apodlatov.test.respak.controllers.api_v1.dto.incoming.GetTechnicsModelsByIdsDto;
import com.apodlatov.test.respak.controllers.api_v1.dto.outgoing.TechnicsModelDto;
import com.apodlatov.test.respak.service.api.TechnicsModelsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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