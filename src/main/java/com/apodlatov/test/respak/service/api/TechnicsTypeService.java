package com.apodlatov.test.respak.service.api;

import com.apodlatov.test.respak.data.models.TechnicsTypeData;

import java.util.List;

public interface TechnicsTypeService {
    public List<TechnicsTypeData> getAllTechnicsTypes();
    public List<TechnicsTypeData> getAllTechnicsTypeById(List<Long> ids);

    TechnicsTypeData addTechnicsType(
            String name,
            String manufacturerName, String manufactureCountry,
            boolean onlineOrderAvailable, boolean installmentsAvailable);

    void deleteByIds(List<Long> ids);
}