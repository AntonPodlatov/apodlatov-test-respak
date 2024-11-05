package com.apodlatov.test.respak.service.api;

import com.apodlatov.test.respak.data.models.TechnicsType;

import java.util.List;

public interface TechnicsTypeService {
    public List<TechnicsType> getAllTechnicsTypes();
    public List<TechnicsType> getAllTechnicsTypeById(List<Long> ids);

    TechnicsType addTechnicsType(
            String name,
            String manufacturerName, String manufactureCountry,
            boolean onlineOrderAvailable, boolean installmentsAvailable);

    void deleteByIds(List<Long> ids);
}