package com.apodlatov.test.respak.controllers.api_v1.dto;

import com.apodlatov.test.respak.controllers.api_v1.dto.outgoing.TechnicsModelDto;
import com.apodlatov.test.respak.controllers.api_v1.dto.outgoing.TechnicsModelOptionDto;
import com.apodlatov.test.respak.controllers.api_v1.dto.outgoing.TechnicsTypeDataDto;
import com.apodlatov.test.respak.controllers.api_v1.dto.outgoing.TechnicsTypeDto;
import com.apodlatov.test.respak.data.models.TechnicsModel;
import com.apodlatov.test.respak.data.models.TechnicsType;
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

        List<TechnicsModelOptionDto> dtos = new ArrayList<>();

        for (ModelOptionValue optionValue: technicsModel.getModelOptionsValues()) {
            String modelOptionName = optionValue.getModelOption().getModelOptionName();
            String modelOptionValue = optionValue.getModelOptionValue();
            dtos.add(new TechnicsModelOptionDto(modelOptionName, modelOptionValue));
        }

        technicsModelDto.setModelOptionsValuesDtos(dtos);

        return technicsModelDto;
    }

    public TechnicsTypeDto mapToTechnicsTypeDto(TechnicsType technicsType) {
        List<TechnicsTypeDataDto> dtos =
                technicsType.getTechnicsTypeDatas().stream()
                        .map(TechnicsTypeDataDto::new)
                        .collect(Collectors.toList());

        return new TechnicsTypeDto(technicsType.getId(), technicsType.getName(), dtos);
    }
}