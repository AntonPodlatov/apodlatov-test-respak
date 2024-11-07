package com.apodlatov.test.respak.controllers.api_v1.dto.incoming;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Schema(description = "Данные для получения списка моделей техники.")
public class GetTechnicsModelsByIdsDto {
    @NotNull
    @Size(min = 1, message = "Список id моделей техники должен содержать не менее 1 элемента")
    List<Long> ids;

    public GetTechnicsModelsByIdsDto() {
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}