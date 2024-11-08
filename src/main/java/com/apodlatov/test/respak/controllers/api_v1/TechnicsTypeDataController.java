package com.apodlatov.test.respak.controllers.api_v1;

import com.apodlatov.test.respak.controllers.api_v1.dto.DtoMapper;
import com.apodlatov.test.respak.controllers.api_v1.dto.incoming.AddTechnicsTypeDataDto;
import com.apodlatov.test.respak.controllers.api_v1.dto.incoming.GetTechnicsTypesDatasPaged;


import com.apodlatov.test.respak.controllers.api_v1.dto.outgoing.TechnicsTypeDataDto;
import com.apodlatov.test.respak.data.models.TechnicsTypeData;
import com.apodlatov.test.respak.service.api.TechnicsTypesDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


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
           @Valid @RequestBody AddTechnicsTypeDataDto dto) {
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

    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Страница выдана"),
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
            summary = "получить страницу экземпляров вида техники",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    implementation = GetTechnicsTypesDatasPaged.class))))
    @PostMapping("get_paged")
    public ResponseEntity<Page<TechnicsTypeDataDto>> getTechnicsTypeDataPaged(
           @Valid @RequestBody GetTechnicsTypesDatasPaged dto) {

        Sort sort = "ASC".equals(dto.getOrder()) ?
                Sort.by(dto.getSortBy()).ascending() :
                Sort.by(dto.getSortBy()).descending();

        PageRequest pageRequest = PageRequest.of(
                dto.getPageNumber(), dto.getPageSize(), sort);

        Page<TechnicsTypeData> technicsTypeDataPage =
                technicsTypesDataService.getPaged(
                        dto.getTechnicsTypeId(), pageRequest);

        Page<TechnicsTypeDataDto> dtoPage = technicsTypeDataPage
                .map(dtoMapper::mapToTechnicsDataDto);

        return ResponseEntity.ok()
                .body(dtoPage);
    }
}