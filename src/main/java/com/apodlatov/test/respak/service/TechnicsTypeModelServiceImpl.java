package com.apodlatov.test.respak.service;

import com.apodlatov.test.respak.data.models.TechnicsModel;
import com.apodlatov.test.respak.data.repo.CommonModelRepository;
import com.apodlatov.test.respak.service.api.TechnicsTypeModelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicsTypeModelServiceImpl implements TechnicsTypeModelService {
    private final CommonModelRepository commonModelRepository;

    public TechnicsTypeModelServiceImpl(
            CommonModelRepository technicsTypeModelRepository) {
        this.commonModelRepository = technicsTypeModelRepository;
    }

    public List<TechnicsModel> getAllTechnicsTypes() {
        return commonModelRepository.findAll();
    }

    public List<TechnicsModel> getAllTechnicsTypeById(List<Long> ids) {
        return commonModelRepository.findAllById(ids);
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