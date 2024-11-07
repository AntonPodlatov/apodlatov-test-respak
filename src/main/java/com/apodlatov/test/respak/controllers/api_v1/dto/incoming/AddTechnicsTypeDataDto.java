package com.apodlatov.test.respak.controllers.api_v1.dto.incoming;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Schema(description = "Данные для запроса создания записи о экземпляре вида техники." +
        " Вид техники - пылесос. Экземпляр вида - пылесос с определенной страной производства, " +
        "производителем и условиями покупки и доставки.")
public class AddTechnicsTypeDataDto {
    @NotBlank(message = "Обязательное поле.")
    @Size(min = 3, message = "Название страны производителя техники должно содержать не менее 3 символов.")
    @Schema(
            description = "Название страны производителя техники",
            defaultValue = "CHI",
            type = "string"
    )
    private String manufactureCountry;

    @NotBlank(message = "Обязательное поле.")
    @Schema(
            description = "Название производителя техники",
            defaultValue = "Dell",
            type = "string"
    )
    @Size(min = 3, message = "Название производителя техники должно содержать не менее 3 символов.")
    private String manufacturerName;

    @NotNull
    @Schema(
            description = "доступно для онлайн-заказа",
            defaultValue = "true",
            type = "boolean"
    )
    private boolean isOnlineOrderAvailable;

    @NotNull
    @Schema(
            description = "доступно в рассрочку",
            defaultValue = "true",
            type = "boolean"
    )
    private boolean isInstallmentsAvailable;

    @NotNull
    @Schema(
            description = "id вида техники",
            defaultValue = "true",
            type = "boolean"
    )
    @Min(value = 1, message = "Id не может быть меньше 1")
    private Long technicsTypeId;

    public AddTechnicsTypeDataDto() {
    }

    public String getManufactureCountry() {
        return manufactureCountry;
    }

    public void setManufactureCountry(String manufactureCountry) {
        this.manufactureCountry = manufactureCountry;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public boolean isOnlineOrderAvailable() {
        return isOnlineOrderAvailable;
    }

    public void setOnlineOrderAvailable(boolean onlineOrderAvailable) {
        isOnlineOrderAvailable = onlineOrderAvailable;
    }

    public boolean isInstallmentsAvailable() {
        return isInstallmentsAvailable;
    }

    public void setInstallmentsAvailable(boolean installmentsAvailable) {
        isInstallmentsAvailable = installmentsAvailable;
    }

    public Long getTechnicsTypeId() {
        return technicsTypeId;
    }

    public void setTechnicsTypeId(Long technicsTypeId) {
        this.technicsTypeId = technicsTypeId;
    }
}