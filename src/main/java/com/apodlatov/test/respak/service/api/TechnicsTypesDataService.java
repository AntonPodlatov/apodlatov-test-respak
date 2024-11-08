package com.apodlatov.test.respak.service.api;

import com.apodlatov.test.respak.data.models.TechnicsTypeData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

public interface TechnicsTypesDataService {
    TechnicsTypeData addTechnicsTypeData(
            Long technicsTypeId,
            String manufacturerName, String manufactureCountry,
            boolean installmentsAvailable, boolean onlineOrderAvailable);

    Page<TechnicsTypeData> getPaged(long technicsTypeId, Pageable pageable);
}