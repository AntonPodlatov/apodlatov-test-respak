package com.apodlatov.test.respak.service;

import com.apodlatov.test.respak.data.models.TechnicsType;
import com.apodlatov.test.respak.data.repo.TechnicsTypeRepository;
import com.apodlatov.test.respak.service.api.TechnicsTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicsTypeServiceImpl implements TechnicsTypeService {
    private final TechnicsTypeRepository technicsTypeRepository;

    public TechnicsTypeServiceImpl(TechnicsTypeRepository technicsTypeRepository) {
        this.technicsTypeRepository = technicsTypeRepository;
    }

    public List<TechnicsType> getAllTechnicsTypes() {
        return technicsTypeRepository.findAll();
    }

    public List<TechnicsType> getAllTechnicsTypeById(List<Long> ids) {
        return technicsTypeRepository.findAllById(ids);
    }

    @Override
    public TechnicsType addTechnicsType(String name,
            String manufacturerName, String manufactureCountry,
            boolean onlineOrderAvailable, boolean installmentsAvailable) {

        TechnicsType technicsType = new TechnicsType();
        technicsType.setName(name);
        technicsType.setManufacturerName(manufacturerName);
        technicsType.setManufactureCountry(manufactureCountry);
        technicsType.setOnlineOrderAvailable(onlineOrderAvailable);
        technicsType.setInstallmentsAvailable(installmentsAvailable);

        return technicsTypeRepository.save(technicsType);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        technicsTypeRepository.deleteAllById(ids);
    }
}