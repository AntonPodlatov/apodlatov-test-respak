package com.apodlatov.test.respak.controllers.api_v1.dto.incoming;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Schema(description = "Данные для запроса создания записи о модели техники.")
public class AddTechnicsModelDto {
    @NotBlank(message = "Обязательное поле.")
    @Size(min = 3, message = "Наименование модели техники должно содержать не менее 3 символов.")
    @Schema(description = "Наименование модели техники", type = "string")
    private String name;

    @NotBlank(message = "Обязательное поле.")
    @Size(min = 10, message = "Серийный номер не может быть меньше 10 символов.")
    @Schema(description = "Серийный номер", type = "string", defaultValue = "AIX34KER333_DDF")
    private String serialNumber;

    @NotNull
    @Min(value = 0, message = "Не меньше 0.")
    @Schema(description = "Цена", defaultValue = "999.99", type = "number")
    private BigDecimal price;

    @NotNull
    @Schema(description = "Признак наличия", defaultValue = "false", type = "boolean")
    private boolean isInStock;

    @Null
    @Min(value = 1, message = "id цета должен быть больше нуля.")
    @Schema(description = "Id записи в таблице Цвет", type = "number", defaultValue = "1")
    private Long colorId;

    @Null
    @Min(value = 1, message = "id размеров должен быть больше нуля.")
    @Schema(description = "id записи в таблице Размеры", type = "number", defaultValue = "1")
    private Long modelSizeId;

    @NotNull
    @Min(value = 1, message = "id экземпляра вида техники должен быть больше нуля.")
    @Schema(description = "id записи в таблице TechnicsTypeData", type = "number", defaultValue = "1")
    private Long technicsTypeDataId;

    @Null(message =
            "Список значений доп. опций должен содержать значения " +
            "или быть null или не быть включенным в атрибуты тела запроса")
    @Schema(description = "список значений доп. опций, специфичных для модели техники")
    private List<AddModelOptionValueDto> optionValueDtos;

    public AddTechnicsModelDto() {
    }

    public @Null List<AddModelOptionValueDto> getOptionValueDtos() {
        return optionValueDtos;
    }

    public void setOptionValueDtos(@Null List<AddModelOptionValueDto> optionValueDtos) {
        this.optionValueDtos = optionValueDtos;
    }

    public @NotBlank(message = "Обязательное поле.") @Size(min = 3, message = "Наименование модели техники должно содержать не менее 3 символов.") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Обязательное поле.") @Size(min = 3, message = "Наименование модели техники должно содержать не менее 3 символов.") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Обязательное поле.") @Size(min = 10, message = "Серийный номер не может быть меньше 10 символов.") String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(@NotBlank(message = "Обязательное поле.") @Size(min = 10, message = "Серийный номер не может быть меньше 10 символов.") String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public @NotNull @Min(value = 0, message = "Не меньше 0.") BigDecimal getPrice() {
        return price;
    }

    public void setPrice(@NotNull @Min(value = 0, message = "Не меньше 0.") BigDecimal price) {
        this.price = price;
    }

    @NotNull
    public boolean isInStock() {
        return isInStock;
    }

    public void setInStock(@NotNull boolean inStock) {
        isInStock = inStock;
    }

    public @Null @Min(value = 1, message = "id цета должен быть больше нуля.") Long getColorId() {
        return colorId;
    }

    public void setColorId(@Null @Min(value = 1, message = "id цета должен быть больше нуля.") Long colorId) {
        this.colorId = colorId;
    }

    public @Null @Min(value = 1, message = "id размеров должен быть больше нуля.") Long getModelSizeId() {
        return modelSizeId;
    }

    public void setModelSizeId(@Null @Min(value = 1, message = "id размеров должен быть больше нуля.") Long modelSizeId) {
        this.modelSizeId = modelSizeId;
    }

    public @NotNull @Min(value = 1, message = "id экземпляра вида техники должен быть больше нуля.") Long getTechnicsTypeDataId() {
        return technicsTypeDataId;
    }

    public void setTechnicsTypeDataId(@NotNull @Min(value = 1, message = "id экземпляра вида техники должен быть больше нуля.") Long technicsTypeDataId) {
        this.technicsTypeDataId = technicsTypeDataId;
    }
}