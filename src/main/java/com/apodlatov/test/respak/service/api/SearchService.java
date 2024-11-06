package com.apodlatov.test.respak.service.api;

import java.math.BigDecimal;
import java.util.List;

public interface SearchService {
    List<?> search(
            String technicsModelNameTerm,
            Long colorId, Long technicsTypeId,
            BigDecimal priceFrom, BigDecimal priceTo);
}