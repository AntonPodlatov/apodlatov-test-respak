package com.apodlatov.test.respak.controller.data.outgoing;

import com.apodlatov.test.respak.data.models.TechnicsTypeData;
import com.apodlatov.test.respak.data.models.TechnicsModel;

import java.util.Set;

public class TechnicsTypeDto {
    private Long id;
    private String manufactureCountry;
    private String manufacturerName;
    private boolean isOnlineOrderAvailable;
    private boolean isInstallmentsAvailable;
    private Set<TechnicsModel> technicsTypeModels;

    public TechnicsTypeDto() {
    }

    public TechnicsTypeDto(TechnicsTypeData technicsType) {
        id = technicsType.getId();
        manufactureCountry = technicsType.getManufactureCountry();
        manufacturerName = technicsType.getManufacturerName();
        isOnlineOrderAvailable = technicsType.isOnlineOrderAvailable();
        isInstallmentsAvailable = technicsType.isInstallmentsAvailable();
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

    public Set<TechnicsModel> getTechnicsTypeModels() {
        return technicsTypeModels;
    }

    public void setTechnicsTypeModels(Set<TechnicsModel> technicsTypeModels) {
        this.technicsTypeModels = technicsTypeModels;
    }
}