package com.apodlatov.test.respak.controllers.api_v1;

import com.apodlatov.test.respak.controllers.api_v1.dto.DtoMapper;
import com.apodlatov.test.respak.controllers.api_v1.dto.incoming.RegistryQueryDto;
import com.apodlatov.test.respak.controllers.api_v1.dto.outgoing.TechnicsModelDto;
import com.apodlatov.test.respak.data.models.TechnicsModel;
import com.apodlatov.test.respak.service.api.SearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Tag(name = "Реестр техники")
@Controller
@RequestMapping("/api_v1/registry_main/technic_models")
public class RegistryController {
    private final SearchService searchService;
    private final DtoMapper mapper;

    public RegistryController(SearchService searchService, DtoMapper mapper) {
        this.searchService = searchService;
        this.mapper = mapper;
    }

    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Страница с результатами поиска"),

            @ApiResponse(
                    responseCode = "400",
                    description = "Невалидный запрос",
                    content = {@Content(
                            mediaType = "application/json;charset=utf-8",
                            schema = @Schema(implementation = Error.class))}),
            @ApiResponse(
                    responseCode = "500",
                    description = "Ошибка сервера",
                    content = {@Content(mediaType = "application/json;charset=utf-8",
                            schema = @Schema(implementation = Error.class))}
            )
    })
    @Operation(
            summary = "Поиск и фильтрация моделей техники",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    implementation = RegistryQueryDto.class))))
    @PostMapping
    public ResponseEntity<Page<TechnicsModelDto>> search(
            @Valid @RequestBody RegistryQueryDto registryQueryDto) {
        String sortBy = registryQueryDto.getSortBy();
        String order = registryQueryDto.getOrder();
        int pageNumber = registryQueryDto.getPageNumber();
        int pageSize = registryQueryDto.getPageSize();

        Sort sort = "ASC".equals(order) ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();

        Page<TechnicsModel> searchResults = searchService.search(
                registryQueryDto.getTechnicsModelNameTerm(),
                registryQueryDto.getColorId(),
                registryQueryDto.getTechnicsTypeId(),
                registryQueryDto.getPriceFrom(),
                registryQueryDto.getPriceTo(), PageRequest.of(pageNumber, pageSize, sort));

        Page<TechnicsModelDto> map = searchResults
                .map(mapper::mapToTechnicsModelDto);

        return ResponseEntity.ok().body(map);
    }
}