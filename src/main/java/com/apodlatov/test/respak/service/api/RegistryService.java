package com.apodlatov.test.respak.service.api;

import com.apodlatov.test.respak.data.models.TechnicsModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

public interface RegistryService {
    Page<TechnicsModel> search(
            String technicsModelNameTerm,
            Long colorId, Long technicsTypeId,
            BigDecimal priceFrom, BigDecimal priceTo,
            List<String> modelOptionValuesString, Pageable pageable);
}