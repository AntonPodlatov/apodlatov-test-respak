package com.apodlatov.test.respak.service.api;

import com.apodlatov.test.respak.controllers.api_v1.dto.incoming.AddModelOptionValueDto;
import com.apodlatov.test.respak.data.models.TechnicsModel;
import com.apodlatov.test.respak.data.models.option.ModelOption;

import java.math.BigDecimal;
import java.util.List;

public interface TechnicsModelsService {
    List<TechnicsModel> getTechnicsModelsByIds(List<Long> ids);

    TechnicsModel addTechnicsModel(
            Long technicsTypeDataId,
            String name, String serialNumber,
            boolean inStock, BigDecimal price, Long modelSizeId,
            Long colorId, List<AddModelOptionValueDto> optionValueDtos);

    ModelOption addModelOption(Long technicsTypeId, String modelOptionName);
}