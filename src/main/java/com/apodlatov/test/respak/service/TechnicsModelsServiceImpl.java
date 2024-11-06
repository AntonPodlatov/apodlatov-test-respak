package com.apodlatov.test.respak.service;

import com.apodlatov.test.respak.data.models.TechnicsModel;
import com.apodlatov.test.respak.data.repo.TechnicsModelRepository;
import com.apodlatov.test.respak.service.api.TechnicsModelsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicsModelsServiceImpl implements TechnicsModelsService {
    private final TechnicsModelRepository technicsModelRepository;

    public TechnicsModelsServiceImpl(TechnicsModelRepository technicsModelRepository) {
        this.technicsModelRepository = technicsModelRepository;
    }

    public List<TechnicsModel> getTechnicsModelsByIds(List<Long> ids) {
       return technicsModelRepository.fetchTechnicsModelsByIdsWithoutTypeData(ids);
    }
}