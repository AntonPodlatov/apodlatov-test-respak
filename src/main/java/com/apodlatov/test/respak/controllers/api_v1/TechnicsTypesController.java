package com.apodlatov.test.respak.controllers.api_v1;

import com.apodlatov.test.respak.controllers.api_v1.dto.DtoMapper;
import com.apodlatov.test.respak.controllers.api_v1.dto.incoming.*;
import com.apodlatov.test.respak.controllers.api_v1.dto.outgoing.TechnicsTypeDto;
import com.apodlatov.test.respak.controllers.api_v1.dto.outgoing.TechnicsTypeWithDatasDto;
import com.apodlatov.test.respak.data.models.TechnicsType;
import com.apodlatov.test.respak.service.api.TechnicsTypesService;
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
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Tag(name = "Api видов техники")
@RequestMapping("/api_v1/technics_types/")
public class TechnicsTypesController {
    private final TechnicsTypesService technicsTypeService;
    private final DtoMapper mapper;

    public TechnicsTypesController(TechnicsTypesService technicsTypeService, DtoMapper mapper) {
        this.technicsTypeService = technicsTypeService;
        this.mapper = mapper;
    }

    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Сущность обновлена"),
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
            summary = "Обновить название вида техники",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    implementation = UpdateTechnicsTypeDto.class))))
    @PostMapping("update_type_name_by_id")
    public ResponseEntity<?> updateTechnicsType(
            @Valid @RequestBody UpdateTechnicsTypeDto dto) {
        technicsTypeService.updateTypeName(dto.getId(), dto.getName());
        return ResponseEntity.ok().build();
    }


    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Выдан список с результатом поиска"),
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
            summary = "Получение списка видов техники с вложенными экземплярами вида по списку id",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    implementation = GetTechnicsTypesByIdsDto.class))))
    @PostMapping("get_by_ids")
    public ResponseEntity<List<TechnicsTypeWithDatasDto>> getTechnicsTypesByIds(
            @Valid @RequestBody GetTechnicsTypesByIdsDto dto) {
        List<TechnicsTypeWithDatasDto> dtos = technicsTypeService
                .getAllTechnicsWithFullDataTypeById(dto.getIds()).stream()
                .map(mapper::mapToTechnicsTypeWithDatasDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }

    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Вид техники создан"),
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
            summary = "Создание нового вида(типа) техники.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    implementation = AddTechnicsTypeDto.class))))
    @PostMapping("add")
    public ResponseEntity<TechnicsTypeWithDatasDto> addTechnicsType(
            @Valid @RequestBody AddTechnicsTypeDto dto) {
        TechnicsType newTechnicsType =
                technicsTypeService.addTechnicsType(dto.getName());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new TechnicsTypeWithDatasDto(
                        newTechnicsType.getId(),
                        newTechnicsType.getName()));
    }

    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Выдана страница видов техники"),
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
            summary = "Постраничное получение видов техники.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    implementation = GetTechnicsTypesPaged.class))))
    @PostMapping("get_all_technics_types")
    public ResponseEntity<Page<TechnicsTypeDto>> getAllTypesPaged(
            @Valid @RequestBody GetTechnicsTypesPaged dto) {

        String sortBy = dto.getSortBy();
        String order = dto.getOrder();

        Sort sort = "ASC".equals(order) ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();

        PageRequest pageRequest =
                PageRequest.of(dto.getPageNumber(),
                        dto.getPageSize(), sort);

        Page<TechnicsTypeDto> dtoPage =
                technicsTypeService.getTypesPaged(pageRequest)
                .map(mapper::mapToTechnicsTypeDto);

        return ResponseEntity.ok().body(dtoPage);
    }
}