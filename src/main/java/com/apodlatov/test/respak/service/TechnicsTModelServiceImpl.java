package com.apodlatov.test.respak.service;

import com.apodlatov.test.respak.data.models.TechnicsModel;
import com.apodlatov.test.respak.data.repo.TechnicsModelRepository;
import com.apodlatov.test.respak.data.repo.TechnicsTypeRepository;
import com.apodlatov.test.respak.service.api.TechnicsTypeModelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicsTModelServiceImpl implements TechnicsTypeModelService {
    private final TechnicsModelRepository technicsModelRepository;

    public TechnicsTModelServiceImpl(
            TechnicsModelRepository technicsModelRepository) {
        this.technicsModelRepository = technicsModelRepository;
    }

    public List<TechnicsModel> getAllTechnicsTypes() {
        return technicsModelRepository.findAll();
    }

    public List<TechnicsModel> getAllTechnicsTypeById(List<Long> ids) {
        return technicsModelRepository.findAllById(ids);
    }

    public TechnicsModel addTechnicsType(
            String name,
            String manufacturerName, String manufactureCountry,
            boolean onlineOrderAvailable, boolean installmentsAvailable) {



        return null;
    }

    public void deleteByIds(List<Long> ids) {

    }
}