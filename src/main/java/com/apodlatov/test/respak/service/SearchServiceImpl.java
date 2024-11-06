package com.apodlatov.test.respak.service;

import com.apodlatov.test.respak.data.models.TechnicsModel;
import com.apodlatov.test.respak.data.repo.TechnicsModelRepository;
import com.apodlatov.test.respak.service.api.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    private final TechnicsModelRepository technicsModelRepository;

    public SearchServiceImpl(TechnicsModelRepository technicsModelRepository) {
        this.technicsModelRepository = technicsModelRepository;
    }

    @Override
    public Page<TechnicsModel> search(
            String technicsModelNameTerm,
            Long colorId, Long technicsTypeId,
            BigDecimal priceFrom, BigDecimal priceTo, Pageable pageable) {
        return technicsModelRepository.search(
                technicsModelNameTerm,colorId, technicsTypeId, priceFrom, priceTo, pageable);
    }
}