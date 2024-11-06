package com.apodlatov.test.respak.service.api;

import com.apodlatov.test.respak.data.models.TechnicsModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;

public interface SearchService {
    Page<TechnicsModel> search(
            String technicsModelNameTerm,
            Long colorId, Long technicsTypeId,
            BigDecimal priceFrom, BigDecimal priceTo, Pageable pageable);
}