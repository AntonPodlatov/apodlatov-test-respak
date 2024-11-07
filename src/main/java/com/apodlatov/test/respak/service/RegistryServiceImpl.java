package com.apodlatov.test.respak.service;

import com.apodlatov.test.respak.data.models.TechnicsModel;
import com.apodlatov.test.respak.data.repo.TechnicsModelRepository;
import com.apodlatov.test.respak.service.api.RegistryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RegistryServiceImpl implements RegistryService {
    private final TechnicsModelRepository technicsModelRepository;

    public RegistryServiceImpl(TechnicsModelRepository technicsModelRepository) {
        this.technicsModelRepository = technicsModelRepository;
    }

    @Override
    public Page<TechnicsModel> search(
            String technicsModelNameTerm,
            Long colorId, Long technicsTypeId,
            BigDecimal priceFrom, BigDecimal priceTo,
            List<String> modelOptionValuesString, Pageable pageable) {

        if (modelOptionValuesString == null || modelOptionValuesString.isEmpty()) {
            return technicsModelRepository.searchWithoutOptionsValues(
                    technicsModelNameTerm,colorId, technicsTypeId,
                    priceFrom, priceTo, pageable);
        }

        return technicsModelRepository.searchWithOptionsValues(
                technicsModelNameTerm,colorId, technicsTypeId,
                priceFrom, priceTo, modelOptionValuesString, pageable);
    }
}