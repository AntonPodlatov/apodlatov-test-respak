package com.apodlatov.test.respak.controllers.api_v1;

import com.apodlatov.test.respak.controllers.api_v1.dto.DtoMapper;
import com.apodlatov.test.respak.controllers.api_v1.dto.incoming.AddTechnicsTypeDataDto;
import com.apodlatov.test.respak.controllers.api_v1.dto.outgoing.TechnicsTypeDataDto;
import com.apodlatov.test.respak.data.models.TechnicsTypeData;
import com.apodlatov.test.respak.service.api.TechnicsTypesDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Tag(name = "Api экземпляров видов техники")
@RequestMapping("/api_v1/technics_type_data/")
public class TechnicsTypeDataController {
    private final TechnicsTypesDataService technicsTypesDataService;
    private final DtoMapper dtoMapper;

    public TechnicsTypeDataController(
            DtoMapper dtoMapper,
            TechnicsTypesDataService technicsTypesDataService) {
        this.technicsTypesDataService = technicsTypesDataService;
        this.dtoMapper = dtoMapper;
    }

    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "сущность создана"),
            @ApiResponse(
                    responseCode = "400",
                    description = "Невалидный запрос",
                    content = {@Content(mediaType = "application/json;charset=utf-8")}),
            @ApiResponse(
                    responseCode = "500",
                    description = "Ошибка сервера",
                    content = {@Content(mediaType = "application/json;charset=utf-8")})
    })
    @Operation(
            summary = "Добавить экземпляр вида техники",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    implementation = AddTechnicsTypeDataDto.class))))
    @PostMapping("add")
    public ResponseEntity<TechnicsTypeDataDto> addTechnicsTypeData(
            @RequestBody AddTechnicsTypeDataDto dto) {
        TechnicsTypeData technicsTypeData =
                technicsTypesDataService.addTechnicsTypeData(
                dto.getTechnicsTypeId(), dto.getManufacturerName(),
                dto.getManufactureCountry(), dto.isInstallmentsAvailable(),
                dto.isOnlineOrderAvailable());

        TechnicsTypeDataDto technicsTypeDataDto =
                dtoMapper.mapToTechnicsDataDto(technicsTypeData);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(technicsTypeDataDto);
    }
}