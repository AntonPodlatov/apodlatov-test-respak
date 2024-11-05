package com.apodlatov.test.respak.controller;

import com.apodlatov.test.respak.controller.data.incoming.AddTechnicsTypeDto;
import com.apodlatov.test.respak.controller.data.incoming.DeleteTechnicsTypesByIdsDto;
import com.apodlatov.test.respak.controller.data.incoming.GetTechnicsTypesByIdsDto;
import com.apodlatov.test.respak.controller.data.outgoing.TechnicsTypeDto;
import com.apodlatov.test.respak.data.models.TechnicsType;
import com.apodlatov.test.respak.service.api.TechnicsTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller("api_v1/technics_types/")
public class TechnicsTypeController {
    private final TechnicsTypeService technicsTypeService;

    public TechnicsTypeController(TechnicsTypeService technicsTypeService) {
        this.technicsTypeService = technicsTypeService;
    }

    @PostMapping("by_ids")
    public ResponseEntity<List<TechnicsTypeDto>> getTechnicsTypesByIds(
            @RequestBody GetTechnicsTypesByIdsDto dto) {
        List<TechnicsTypeDto> dtos = technicsTypeService
                .getAllTechnicsTypeById(dto.getIds()).stream()
                .map(TechnicsTypeDto::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }

    @PostMapping("add")
    public ResponseEntity<TechnicsTypeDto> addTechnicsType(
            @RequestBody AddTechnicsTypeDto dto) {
        TechnicsType newTechnicsType =
                technicsTypeService.addTechnicsType(
                        dto.getName(),
                        dto.getManufacturerName(),
                        dto.getManufactureCountry(),
                        dto.isOnlineOrderAvailable(),
                        dto.isInstallmentsAvailable());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new TechnicsTypeDto(newTechnicsType));
    }

    @DeleteMapping("delete_by_ids")
    public ResponseEntity<?> deleteByIds(
            @RequestBody DeleteTechnicsTypesByIdsDto dto) {
        technicsTypeService.deleteByIds(dto.getIds());

        return ResponseEntity.ok().build();
    }
}