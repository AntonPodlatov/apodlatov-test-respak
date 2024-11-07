package com.apodlatov.test.respak.service.api;

import com.apodlatov.test.respak.data.models.TechnicsTypeData;

public interface TechnicsTypesDataService {
    TechnicsTypeData addTechnicsTypeData(
            Long technicsTypeId,
            String manufacturerName, String manufactureCountry,
            boolean installmentsAvailable, boolean onlineOrderAvailable);
}