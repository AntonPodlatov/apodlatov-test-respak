package com.apodlatov.test.respak.service.api;

import com.apodlatov.test.respak.data.models.TechnicsModel;

import java.util.List;

public interface TechnicsModelsService {
    List<TechnicsModel> getTechnicsModelsByIds(List<Long> ids);
}