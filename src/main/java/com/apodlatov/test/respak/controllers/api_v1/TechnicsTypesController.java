package com.apodlatov.test.respak.controllers.api_v1;

import com.apodlatov.test.respak.controllers.api_v1.dto.DtoMapper;
import com.apodlatov.test.respak.controllers.api_v1.dto.incoming.AddTechnicsTypeDto;
import com.apodlatov.test.respak.controllers.api_v1.dto.incoming.DeleteTechnicsTypesByIdsDto;
import com.apodlatov.test.respak.controllers.api_v1.dto.incoming.GetTechnicsTypesByIdsDto;
import com.apodlatov.test.respak.controllers.api_v1.dto.incoming.UpdateTechnicsTypeDto;
import com.apodlatov.test.respak.controllers.api_v1.dto.outgoing.TechnicsTypeDto;
import com.apodlatov.test.respak.data.models.TechnicsType;
import com.apodlatov.test.respak.service.api.TechnicsTypesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api_v1/technics_types/")
public class TechnicsTypesController {
    private final TechnicsTypesService technicsTypeService;
    private final DtoMapper mapper;

    public TechnicsTypesController(TechnicsTypesService technicsTypeService, DtoMapper mapper) {
        this.technicsTypeService = technicsTypeService;
        this.mapper = mapper;
    }

    @PostMapping("update_type_name_by_id")
    public ResponseEntity<?> updateTechnicsType(
            @RequestBody UpdateTechnicsTypeDto dto) {
        technicsTypeService.updateTypeName(dto.getId(), dto.getName());
        return ResponseEntity.ok().build();
    }

    @PostMapping("get_by_ids")
    public ResponseEntity<List<TechnicsTypeDto>> getTechnicsTypesByIds(
            @RequestBody GetTechnicsTypesByIdsDto dto) {
        List<TechnicsTypeDto> dtos = technicsTypeService
                        .getAllTechnicsWithFullDataTypeById(dto.getIds()).stream()
                        .map(mapper::mapToTechnicsTypeDto)
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

    @PostMapping("delete_by_ids")
    public ResponseEntity<?> deleteByIds(
            @RequestBody DeleteTechnicsTypesByIdsDto dto) {
        technicsTypeService.deleteByIds(dto.getIds());

        return ResponseEntity.ok().build();
    }

}