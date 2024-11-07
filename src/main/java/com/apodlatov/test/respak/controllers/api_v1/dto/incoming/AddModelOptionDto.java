package com.apodlatov.test.respak.controllers.api_v1.dto.incoming;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Schema(description = "Данные добавления опции " +
        "специфичной для определенного вида техники")
public class AddModelOptionDto {
    @NotBlank(message = "Обязательное поле.")
    @Size(min = 1, message = "Значения названия опции должно быть не менее 1 символа.")
    @Schema(description = "Название опции", type = "string")
    private String modelOptionName;

    @NotNull(message = "нельзя создать опцию не указывая вид техники.")
    @Schema(
            description = "id опции модели",
            defaultValue = "1",
            type = "number"
    )
    @Min(value = 1, message = "modelOptionId не может быть меньше 1")
    private Long technicsTypeId;

    public AddModelOptionDto() {
    }

    public String getModelOptionName() {
        return modelOptionName;
    }

    public void setModelOptionName(String modelOptionName) {
        this.modelOptionName = modelOptionName;
    }

    public Long getTechnicsTypeId() {
        return technicsTypeId;
    }

    public void setTechnicsTypeId(Long technicsTypeId) {
        this.technicsTypeId = technicsTypeId;
    }
}