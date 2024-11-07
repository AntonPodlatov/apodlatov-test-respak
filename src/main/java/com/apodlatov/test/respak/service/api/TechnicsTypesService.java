package com.apodlatov.test.respak.service.api;

import com.apodlatov.test.respak.data.models.TechnicsType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface TechnicsTypesService {
    List<TechnicsType> getAllTechnicsWithFullDataTypeById(List<Long> ids);
    Page<TechnicsType> getTypesPaged(PageRequest pageRequest);
    TechnicsType addTechnicsType(String typeName);
    void updateTypeName(long id, String name);
    void deleteByIds(List<Long> ids);
}