package com.apodlatov.test.respak.controllers.api_v1.dto.incoming;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddTechnicsTypeDataDto {
    @NotNull
    @Size(min = 3, message = "Название страны производителя техники должно содержать не менее 3 символов.")
    private String manufactureCountry;

    @NotNull
    @Size(min = 3, message = "Название производителя техники должно содержать не менее 3 символов.")
    private String manufacturerName;

    @NotNull
    private boolean isOnlineOrderAvailable;

    @NotNull
    private boolean isInstallmentsAvailable;

    @NotNull
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