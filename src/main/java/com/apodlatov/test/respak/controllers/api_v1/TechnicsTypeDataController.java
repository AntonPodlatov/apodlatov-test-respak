package com.apodlatov.test.respak.controllers.api_v1;

import com.apodlatov.test.respak.controllers.api_v1.dto.incoming.AddTechnicsTypeDataDto;
import com.apodlatov.test.respak.controllers.api_v1.dto.outgoing.TechnicsTypeDto;
import com.apodlatov.test.respak.service.api.TechnicsTypesDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api_v1/technics_type_data/")
public class TechnicsTypeDataController {
    private final TechnicsTypesDataService technicsTypesDataService;

    public TechnicsTypeDataController(TechnicsTypesDataService technicsTypesDataService) {
        this.technicsTypesDataService = technicsTypesDataService;
    }

    @PostMapping
    public ResponseEntity<TechnicsTypeDto> addTechnicsTypeData(@RequestBody AddTechnicsTypeDataDto dto) {
        technicsTypesDataService.addTechnicsTypeData(
                dto.getTechnicsTypeId(), dto.getManufacturerName(),
                dto.getManufactureCountry(), dto.isInstallmentsAvailable(),
                dto.isOnlineOrderAvailable());

        return ResponseEntity.ok().build();
    }
}