package com.apodlatov.test.respak.controllers.api_v1.dto;

import com.apodlatov.test.respak.controllers.api_v1.dto.outgoing.*;
import com.apodlatov.test.respak.data.models.TechnicsModel;
import com.apodlatov.test.respak.data.models.TechnicsType;
import com.apodlatov.test.respak.data.models.TechnicsTypeData;
import com.apodlatov.test.respak.data.models.option.ModelOption;
import com.apodlatov.test.respak.data.models.option.ModelOptionValue;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DtoMapper {
    public TechnicsModelDto mapToTechnicsModelDto(TechnicsModel technicsModel) {
        TechnicsModelDto technicsModelDto = new TechnicsModelDto();
        technicsModelDto.setId(technicsModel.getId());
        technicsModelDto.setName(technicsModel.getName());
        technicsModelDto.setColor(technicsModel.getColor());
        technicsModelDto.setModelSize(technicsModel.getModelSize());
        technicsModelDto.setPrice(technicsModel.getPrice());
        technicsModelDto.setInStock(technicsModel.isInStock());
        technicsModelDto.setSerialNumber(technicsModel.getSerialNumber());

        List<TechnicsModelOptionValueDto> dtos = new ArrayList<>();

        List<ModelOptionValue> modelOptionsValues = technicsModel.getModelOptionsValues();

        if (modelOptionsValues != null) {
            for (ModelOptionValue optionValue : modelOptionsValues) {
                String modelOptionName = optionValue.getModelOption().getModelOptionName();
                String modelOptionValue = optionValue.getModelOptionValue();
                dtos.add(new TechnicsModelOptionValueDto(modelOptionName, modelOptionValue));
            }
        }

        technicsModelDto.setModelOptionsValuesDtos(dtos);

        return technicsModelDto;
    }

    public TechnicsTypeWithDatasDto mapToTechnicsTypeWithDatasDto(TechnicsType technicsType) {
        List<TechnicsTypeDataDto> dtos =
                technicsType.getTechnicsTypeDatas().stream()
                        .map(TechnicsTypeDataDto::new)
                        .collect(Collectors.toList());

        return new TechnicsTypeWithDatasDto(
                technicsType.getId(), technicsType.getName(), dtos);
    }

    public TechnicsTypeDto mapToTechnicsTypeDto(TechnicsType technicsType) {
        return new TechnicsTypeDto(technicsType.getId(), technicsType.getName());
    }

    public TechnicsTypeDataDto mapToTechnicsDataDto(TechnicsTypeData technicsTypeData) {
        TechnicsTypeDataDto typeDataDto = new TechnicsTypeDataDto();

        typeDataDto.setInstallmentsAvailable(technicsTypeData.isInstallmentsAvailable());
        typeDataDto.setOnlineOrderAvailable(technicsTypeData.isOnlineOrderAvailable());
        typeDataDto.setManufactureCountry(technicsTypeData.getManufactureCountry());
        typeDataDto.setManufacturerName(technicsTypeData.getManufacturerName());
        typeDataDto.setId(technicsTypeData.getId());

        return typeDataDto;
    }

    public TechnicsModelOptionDto mapToModelOptionDto(ModelOption technicsTypeData) {
        TechnicsModelOptionDto dto = new TechnicsModelOptionDto();
        dto.setModelOptionName(technicsTypeData.getModelOptionName());
        dto.setTechnicsTypeId(technicsTypeData.getTechnicsType().getId());
        dto.setId(technicsTypeData.getId());

        return dto;
    }
}