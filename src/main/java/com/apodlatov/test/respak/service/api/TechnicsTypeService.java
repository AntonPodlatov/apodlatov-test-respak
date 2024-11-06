package com.apodlatov.test.respak.service.api;

import com.apodlatov.test.respak.data.models.TechnicsType;

import java.util.List;

public interface TechnicsTypeService {
    List<TechnicsType> getAllTechnicsTypes();
    List<TechnicsType> getAllTechnicsTypeById(List<Long> ids);
    TechnicsType addTechnicsType(String typeName);
    void deleteByIds(List<Long> ids);
}