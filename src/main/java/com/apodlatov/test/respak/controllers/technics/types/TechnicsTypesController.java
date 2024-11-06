package com.apodlatov.test.respak.controllers.technics.types;

import com.apodlatov.test.respak.controllers.technics.types.dto.incoming.AddTechnicsTypeDto;
import com.apodlatov.test.respak.controllers.technics.types.dto.incoming.DeleteTechnicsTypesByIdsDto;
import com.apodlatov.test.respak.controllers.technics.types.dto.incoming.GetTechnicsTypesByIdsDto;
import com.apodlatov.test.respak.controllers.technics.types.dto.outgoing.TechnicsTypeDataDto;
import com.apodlatov.test.respak.controllers.technics.types.dto.outgoing.TechnicsTypeDto;
import com.apodlatov.test.respak.data.models.TechnicsType;
import com.apodlatov.test.respak.service.api.TechnicsTypesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller("api_v1/technics_types/")
public class TechnicsTypesController {
    private final TechnicsTypesService technicsTypeService;

    public TechnicsTypesController(TechnicsTypesService technicsTypeService) {
        this.technicsTypeService = technicsTypeService;
    }

    @PostMapping("get_by_ids")
    public ResponseEntity<List<TechnicsTypeDto>> getTechnicsTypesByIds(
            @RequestBody GetTechnicsTypesByIdsDto dto) {
        List<TechnicsTypeDto> dtos = technicsTypeService
                        .getAllTechnicsWithFullDataTypeById(dto.getIds()).stream()
                        .map(this::mapToTechnicsTypeDto)
                        .collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }

    @PostMapping("add")
    public ResponseEntity<TechnicsTypeDto> addTechnicsType(
            @RequestBody AddTechnicsTypeDto dto) {
        TechnicsType newTechnicsType =
                technicsTypeService.addTechnicsType(dto.getName());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new TechnicsTypeDto(
                        newTechnicsType.getId(),
                        newTechnicsType.getName()));
    }

    @DeleteMapping("delete_by_ids")
    public ResponseEntity<?> deleteByIds(
            @RequestBody DeleteTechnicsTypesByIdsDto dto) {
        technicsTypeService.deleteByIds(dto.getIds());

        return ResponseEntity.ok().build();
    }


    private TechnicsTypeDto mapToTechnicsTypeDto(TechnicsType technicsType) {
        List<TechnicsTypeDataDto> dtos =
                technicsType.getTechnicsTypeDatas().stream()
                        .map(TechnicsTypeDataDto::new)
                        .collect(Collectors.toList());

        return new TechnicsTypeDto(technicsType.getId(), technicsType.getName(), dtos);
    }
}