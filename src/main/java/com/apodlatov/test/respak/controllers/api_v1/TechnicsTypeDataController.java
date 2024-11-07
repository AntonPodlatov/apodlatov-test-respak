package com.apodlatov.test.respak.controllers.api_v1;

import com.apodlatov.test.respak.controllers.api_v1.dto.incoming.AddTechnicsTypeDataDto;
import com.apodlatov.test.respak.controllers.api_v1.dto.outgoing.TechnicsTypeWithDatasDto;
import com.apodlatov.test.respak.service.api.TechnicsTypesDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Tag(name = "Апи экземпляров видов техники")
@RequestMapping("/api_v1/technics_type_data/")
public class TechnicsTypeDataController {
    private final TechnicsTypesDataService technicsTypesDataService;

    public TechnicsTypeDataController(TechnicsTypesDataService technicsTypesDataService) {
        this.technicsTypesDataService = technicsTypesDataService;
    }

    @PostMapping
    @Operation(
            summary = "Добавить экземпляр вида техники",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    implementation = AddTechnicsTypeDataDto.class))))
    public ResponseEntity<TechnicsTypeWithDatasDto> addTechnicsTypeData(@RequestBody AddTechnicsTypeDataDto dto) {
        technicsTypesDataService.addTechnicsTypeData(
                dto.getTechnicsTypeId(), dto.getManufacturerName(),
                dto.getManufactureCountry(), dto.isInstallmentsAvailable(),
                dto.isOnlineOrderAvailable());

        return ResponseEntity.ok().build();
    }
}