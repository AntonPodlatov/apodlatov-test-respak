package com.apodlatov.test.respak.controllers.api_v1.dto.incoming;


import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Schema(description = "Данные добавления значения опции " +
        "специфичной для определенного вида техники")
public class AddModelOptionValueDto {

    @NotBlank(message = "Обязательное поле.")
    @Size(min = 1, message = "Значения опции должно быть не менее 1 символа.")
    @Schema(description = "Значения опции", type = "string")
    private String modelOptionValue;

    @NotNull
    @Schema(
            description = "id опции модели",
            defaultValue = "1",
            type = "number"
    )
    @Min(value = 1, message = "modelOptionId не может быть меньше 1")
    private Long modelOptionId;

    public @NotBlank(message = "Обязательное поле.") @Size(min = 1, message = "Значения опции должно быть не менее 1 символа.") String getModelOptionValue() {
        return modelOptionValue;
    }

    public void setModelOptionValue(@NotBlank(message = "Обязательное поле.") @Size(min = 1, message = "Значения опции должно быть не менее 1 символа.") String modelOptionValue) {
        this.modelOptionValue = modelOptionValue;
    }

    public @NotNull @Min(value = 1, message = "modelOptionId не может быть меньше 1") Long getModelOptionId() {
        return modelOptionId;
    }

    public void setModelOptionId(@NotNull @Min(value = 1, message = "modelOptionId не может быть меньше 1") Long modelOptionId) {
        this.modelOptionId = modelOptionId;
    }
}