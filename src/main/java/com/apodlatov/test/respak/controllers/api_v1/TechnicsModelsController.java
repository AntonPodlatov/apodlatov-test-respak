package com.apodlatov.test.respak.controllers.api_v1;

import com.apodlatov.test.respak.controllers.api_v1.dto.DtoMapper;
import com.apodlatov.test.respak.controllers.api_v1.dto.incoming.AddTechnicsModelDto;
import com.apodlatov.test.respak.controllers.api_v1.dto.incoming.GetTechnicsModelsByIdsDto;
import com.apodlatov.test.respak.controllers.api_v1.dto.outgoing.TechnicsModelDto;
import com.apodlatov.test.respak.data.models.TechnicsModel;
import com.apodlatov.test.respak.service.api.TechnicsModelsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Tag(name = "Api моделей техники")
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
            @RequestBody @Valid GetTechnicsModelsByIdsDto dto) {
        List<TechnicsModelDto> dtos =
                technicsModelsService.getTechnicsModelsByIds(dto.getIds()).stream()
                        .map(dtoMapper::mapToTechnicsModelDto)
                        .collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }

    @PostMapping("add_model")
    public ResponseEntity<TechnicsModelDto> addTechnicsModel(
            @RequestBody @Valid AddTechnicsModelDto dto) {

        TechnicsModel newTechnicsmodel =
                technicsModelsService.addTechnicsModel(
                        dto.getTechnicsTypeDataId(), dto.getName(),
                        dto.getSerialNumber(), dto.isInStock(), dto.getPrice(),
                        dto.getModelSizeId(), dto.getColorId(), dto.getOptionValueDtos());

        TechnicsModelDto technicsModelDto =
                dtoMapper.mapToTechnicsModelDto(newTechnicsmodel);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(technicsModelDto);
    }
}