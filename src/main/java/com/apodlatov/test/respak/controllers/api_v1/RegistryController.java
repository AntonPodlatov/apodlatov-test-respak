package com.apodlatov.test.respak.controllers.api_v1;

import com.apodlatov.test.respak.controllers.api_v1.dto.DtoMapper;
import com.apodlatov.test.respak.controllers.api_v1.dto.incoming.RegistryQueryDto;
import com.apodlatov.test.respak.controllers.api_v1.dto.outgoing.TechnicsModelDto;
import com.apodlatov.test.respak.data.models.TechnicsModel;
import com.apodlatov.test.respak.service.api.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api_v1/registry_main/technic_models")
public class RegistryController {
    private final SearchService searchService;
    private final DtoMapper mapper;

    public RegistryController(SearchService searchService, DtoMapper mapper) {
        this.searchService = searchService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<?> search(@RequestBody RegistryQueryDto registryQueryDto) {
        String sortBy = registryQueryDto.getSortBy();
        boolean ascending = registryQueryDto.isAscending();
        int pageNumber = registryQueryDto.getPageNumber();
        int pageSize = registryQueryDto.getPageSize();

        Sort sort = ascending ?
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