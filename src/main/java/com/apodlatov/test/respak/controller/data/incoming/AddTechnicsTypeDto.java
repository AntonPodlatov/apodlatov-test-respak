package com.apodlatov.test.respak.controller.data.incoming;

public class AddTechnicsTypeDto {
    private String name;
    private String manufactureCountry;
    private String manufacturerName;
    private boolean isOnlineOrderAvailable;
    private boolean isInstallmentsAvailable;

    public AddTechnicsTypeDto() {
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
}
