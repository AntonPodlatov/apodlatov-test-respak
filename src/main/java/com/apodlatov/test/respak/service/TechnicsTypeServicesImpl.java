package com.apodlatov.test.respak.service;

import com.apodlatov.test.respak.data.models.TechnicsType;
import com.apodlatov.test.respak.data.repo.TechnicsTypeRepository;
import com.apodlatov.test.respak.service.api.TechnicsTypesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicsTypeServicesImpl implements TechnicsTypesService {
    private final TechnicsTypeRepository technicsTypeRepository;

    public TechnicsTypeServicesImpl(TechnicsTypeRepository technicsTypeRepository) {
        this.technicsTypeRepository = technicsTypeRepository;
    }

    public List<TechnicsType> getAllTechnicsTypes() {
        return technicsTypeRepository.findAll();
    }

    public List<TechnicsType> getAllTechnicsWithFullDataTypeById(List<Long> ids) {
        return technicsTypeRepository.fetchAllTechnicsWithFullDataTypeById(ids);
    }

    @Override
    public TechnicsType addTechnicsType(String typeName) {
        TechnicsType technicsType = new TechnicsType();
        technicsType.setName(typeName);

        return technicsTypeRepository.save(technicsType);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        technicsTypeRepository.deleteAllById(ids);
    }

    @Override
    public void updateTypeName(long id, String name) {
        technicsTypeRepository.updateTechnicsTypeName(id, name);
    }
}