package com.apodlatov.test.respak.controllers.api_v1.dto.outgoing;

import com.apodlatov.test.respak.data.models.TechnicsTypeData;

public class TechnicsTypeDataDto {
    private Long id;
    private String manufactureCountry;
    private String manufacturerName;
    private boolean isOnlineOrderAvailable;
    private boolean isInstallmentsAvailable;

    public TechnicsTypeDataDto() {
    }

    public TechnicsTypeDataDto(TechnicsTypeData technicsTypeData) {
        this.id = technicsTypeData.getId();
        this.manufactureCountry = technicsTypeData.getManufactureCountry();
        this.manufacturerName = technicsTypeData.getManufacturerName();
        this.isOnlineOrderAvailable = technicsTypeData.isOnlineOrderAvailable();
        this.isInstallmentsAvailable = technicsTypeData.isInstallmentsAvailable();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
