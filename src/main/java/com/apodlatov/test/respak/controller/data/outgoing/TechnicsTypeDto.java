package com.apodlatov.test.respak.controller.data.outgoing;

import com.apodlatov.test.respak.data.models.TechnicsType;
import com.apodlatov.test.respak.data.models.TechnicsTypeModel;

import java.util.Set;

public class TechnicsTypeDto {
    private Long id;
    private String name;
    private String manufactureCountry;
    private String manufacturerName;
    private boolean isOnlineOrderAvailable;
    private boolean isInstallmentsAvailable;
    private Set<TechnicsTypeModel> technicsTypeModels;

    public TechnicsTypeDto() {
    }

    public TechnicsTypeDto(TechnicsType technicsType) {
        id = technicsType.getId();
        name = technicsType.getName();
        manufactureCountry = technicsType.getManufactureCountry();
        manufacturerName = technicsType.getManufacturerName();
        isOnlineOrderAvailable = technicsType.isOnlineOrderAvailable();
        isInstallmentsAvailable = technicsType.isInstallmentsAvailable();
        technicsTypeModels = technicsType.getTechnicsTypeModels();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<TechnicsTypeModel> getTechnicsTypeModels() {
        return technicsTypeModels;
    }

    public void setTechnicsTypeModels(Set<TechnicsTypeModel> technicsTypeModels) {
        this.technicsTypeModels = technicsTypeModels;
    }
}