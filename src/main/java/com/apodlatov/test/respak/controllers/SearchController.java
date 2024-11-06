package com.apodlatov.test.respak.controllers;

import com.apodlatov.test.respak.controllers.dto.incoming.SearchQueryDto;
import com.apodlatov.test.respak.service.api.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api_v1/models_search")
public class SearchController {
    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping
    public ResponseEntity<?> search(@RequestBody SearchQueryDto searchQueryDto) {
        List<?> search = searchService.search(
                searchQueryDto.getTechnicsModelNameTerm(),
                searchQueryDto.getColorId(),
                searchQueryDto.getTechnicsTypeId(),
                searchQueryDto.getPriceFrom(),
                searchQueryDto.getPriceTo());

       return ResponseEntity.ok().body(search);
    }
}