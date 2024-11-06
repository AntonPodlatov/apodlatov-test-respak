package com.apodlatov.test.respak.controllers;

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

    public TechnicsModelsController(TechnicsModelsService technicsModelsService) {
        this.technicsModelsService = technicsModelsService;
    }

    @PostMapping("get_by_ids")
    public ResponseEntity<List<TechnicsModelDto>> getTechnicsModelsByIds(
            @RequestBody GetTechnicsModelsByIdsDto dto) {
        List<TechnicsModelDto> dtos =
                technicsModelsService.getTechnicsModelsByIds(dto.getIds()).stream()
                        .map(this::mapToTechnicsModelDto)
                        .collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }

    private TechnicsModelDto mapToTechnicsModelDto(TechnicsModel technicsModel) {
        TechnicsModelDto technicsModelDto = new TechnicsModelDto();
        technicsModelDto.setId(technicsModel.getId());
        technicsModelDto.setName(technicsModel.getName());
        technicsModelDto.setColor(technicsModel.getColor());
        technicsModelDto.setModelSize(technicsModel.getModelSize());
        technicsModelDto.setPrice(technicsModel.getPrice());
        technicsModelDto.setInStock(technicsModel.isInStock());
        technicsModelDto.setSerialNumber(technicsModel.getSerialNumber());

        List<TechnicsModelOptionDto> dtos = new ArrayList<>();

        for (ModelOptionValue optionValue: technicsModel.getModelOptionsValues()) {
            String modelOptionName = optionValue.getModelOption().getModelOptionName();
            String modelOptionValue = optionValue.getModelOptionValue();
            dtos.add(new TechnicsModelOptionDto(modelOptionName, modelOptionValue));
        }

        technicsModelDto.setModelOptionsValuesDtos(dtos);

        return technicsModelDto;
    }
}