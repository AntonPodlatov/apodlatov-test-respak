package com.apodlatov.test.respak.service;

import com.apodlatov.test.respak.controllers.api_v1.dto.incoming.AddModelOptionValueDto;
import com.apodlatov.test.respak.data.models.TechnicsModel;
import com.apodlatov.test.respak.data.models.TechnicsTypeData;
import com.apodlatov.test.respak.data.models.option.ModelOption;
import com.apodlatov.test.respak.data.models.option.ModelOptionValue;
import com.apodlatov.test.respak.data.models.side.data.Color;
import com.apodlatov.test.respak.data.models.side.data.ModelSize;
import com.apodlatov.test.respak.data.repo.ModelOptionValueRepository;
import com.apodlatov.test.respak.data.repo.TechnicsModelRepository;
import com.apodlatov.test.respak.service.api.TechnicsModelsService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class TechnicsModelsServiceImpl implements TechnicsModelsService {
    private final ModelOptionValueRepository modelOptionValueRepository;
    private final TechnicsModelRepository technicsModelRepository;
    private final EntityManager entityManager;

    public TechnicsModelsServiceImpl(
            EntityManager entityManager,
            TechnicsModelRepository technicsModelRepository,
            ModelOptionValueRepository modelOptionValueRepository) {
        this.modelOptionValueRepository = modelOptionValueRepository;
        this.technicsModelRepository = technicsModelRepository;
        this.entityManager = entityManager;
    }

    public List<TechnicsModel> getTechnicsModelsByIds(List<Long> ids) {
        return technicsModelRepository.fetchTechnicsModelsByIdsWithoutTypeData(ids);
    }

    @Override
    public TechnicsModel addTechnicsModel(
            Long technicsTypeDataId,
            String name, String serialNumber,
            boolean inStock, BigDecimal price, Long modelSizeId,
            Long colorId, List<AddModelOptionValueDto> optionValueDtos) {

        TechnicsTypeData technicsTypeRef =
                entityManager.getReference(
                        TechnicsTypeData.class, technicsTypeDataId);

        TechnicsModel model = new TechnicsModel();

        model.setTechnicsTypeData(technicsTypeRef);
        model.setSerialNumber(serialNumber);
        model.setInStock(inStock);
        model.setPrice(price);
        model.setName(name);

        if (modelSizeId != null) {
            model.setModelSize(
                    entityManager.getReference(
                            ModelSize.class, modelSizeId));
        }

        if (colorId != null) {
            model.setColor(
                    entityManager.getReference(
                            Color.class, colorId));
        }

        TechnicsModel newTechnicsModel = technicsModelRepository.save(model);

        if (optionValueDtos != null) {
            List<ModelOptionValue> newValues = new ArrayList<>();

            for (AddModelOptionValueDto optionValueDto: optionValueDtos) {
                ModelOption optionRef =
                        entityManager.getReference(ModelOption.class,
                                optionValueDto.getModelOptionId());

                ModelOptionValue optionValue = new ModelOptionValue();
                optionValue.setModelOptionValue(optionValueDto.getModelOptionValue());
                optionValue.setTechnicsModel(newTechnicsModel);
                optionValue.setModelOption(optionRef);

                newValues.add(optionValue);
            }

            newTechnicsModel.setModelOptionsValues(
                    modelOptionValueRepository.saveAll(newValues));

            technicsModelRepository.save(newTechnicsModel);
        }

        return newTechnicsModel;
    }
}