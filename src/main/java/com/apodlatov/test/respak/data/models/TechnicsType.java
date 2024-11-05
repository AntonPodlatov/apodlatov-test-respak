package com.apodlatov.test.respak.data.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "technics_types")
public class TechnicsType {

    @Id
    @Column(name = "tt_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "tt_name")
    private String name;

    @Column(nullable = false, name = "tt_manufacture_country")
    private String manufactureCountry;

    @Column(nullable = false, name = "tt_manufacturer_name")
    private String manufacturerName;

    @Column(nullable = false, name = "tt_is_online_order_available")
    private boolean isOnlineOrderAvailable = false;

    @Column(nullable = false, name = "tt_is_installments_available")
    private boolean isInstallmentsAvailable = false;

    @OneToMany(
            mappedBy = "technicsType",
            fetch = FetchType.LAZY
    )
    private Set<TechnicsTypeModel> technicsTypeModels;

    public TechnicsType() {}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TechnicsType that = (TechnicsType) o;

        return isInstallmentsAvailable == that.isInstallmentsAvailable &&
                isOnlineOrderAvailable == that.isOnlineOrderAvailable &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(manufactureCountry, that.manufactureCountry) &&
                Objects.equals(manufacturerName, that.manufacturerName) &&
                Objects.equals(technicsTypeModels, that.technicsTypeModels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id, name, manufactureCountry,
                manufacturerName, isOnlineOrderAvailable,
                isInstallmentsAvailable, technicsTypeModels);
    }
}