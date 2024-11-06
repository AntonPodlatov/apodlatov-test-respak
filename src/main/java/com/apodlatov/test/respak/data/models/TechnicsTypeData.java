package com.apodlatov.test.respak.data.models;

import com.apodlatov.test.respak.data.models.option.ModelOption;
import com.apodlatov.test.respak.data.models.side.data.categories.TechnicsTypeCategory;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "technics_types_data")
public class TechnicsTypeData {

    @Id
    @Column(name = "ttd_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, name = "ttd_name")
    private String name;

    @Column(nullable = false, name = "ttd_manufacture_country")
    private String manufactureCountry;

    @Column(nullable = false, name = "ttd_manufacturer_name")
    private String manufacturerName;

    @Column(nullable = false, name = "ttd_is_online_order_available")
    private boolean isOnlineOrderAvailable = false;

    @Column(nullable = false, name = "ttd_is_installments_available")
    private boolean isInstallmentsAvailable = false;

    @OneToMany(
            mappedBy = "technicsTypeData",
            fetch = FetchType.LAZY
    )
    private Set<TechnicsModel> technicsTypeModels;

    @OneToMany(
            mappedBy = "technicsTypeData",
            fetch = FetchType.LAZY
    )
    private Set<ModelOption> modelOptions;

    @ManyToOne
    @JoinColumn(name = "tt_id")
    private TechnicsType technicsType;

    @OneToMany(
            mappedBy = "technicsTypeData",
            fetch = FetchType.LAZY
    )
    private Set<TechnicsTypeCategory> typeCategories;

    public TechnicsTypeData() {
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

    public Set<TechnicsModel> getTechnicsTypeModels() {
        return technicsTypeModels;
    }

    public void setTechnicsTypeModels(Set<TechnicsModel> technicsTypeModels) {
        this.technicsTypeModels = technicsTypeModels;
    }

    public Set<ModelOption> getModelOptions() {
        return modelOptions;
    }

    public void setModelOptions(Set<ModelOption> modelOptions) {
        this.modelOptions = modelOptions;
    }

    public Set<TechnicsTypeCategory> getTypeCategories() {
        return typeCategories;
    }

    public void setTypeCategories(Set<TechnicsTypeCategory> typeCategories) {
        this.typeCategories = typeCategories;
    }

    public TechnicsType getTechnicsType() {
        return technicsType;
    }

    public void setTechnicsType(TechnicsType technicsType) {
        this.technicsType = technicsType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TechnicsTypeData that = (TechnicsTypeData) o;

        return isInstallmentsAvailable == that.isInstallmentsAvailable &&
                isOnlineOrderAvailable == that.isOnlineOrderAvailable &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(technicsType, that.technicsType) &&
                Objects.equals(manufactureCountry, that.manufactureCountry) &&
                Objects.equals(manufacturerName, that.manufacturerName) &&
                Objects.equals(modelOptions, that.modelOptions) &&
                Objects.equals(typeCategories, that.typeCategories) &&
                Objects.equals(technicsTypeModels, that.technicsTypeModels);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Boolean.hashCode(isOnlineOrderAvailable);
        result = 31 * result + Boolean.hashCode(isInstallmentsAvailable);
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(manufactureCountry);
        result = 31 * result + Objects.hashCode(manufacturerName);
        result = 31 * result + Objects.hashCode(technicsTypeModels);
        result = 31 * result + Objects.hashCode(modelOptions);
        result = 31 * result + Objects.hashCode(technicsType);
        result = 31 * result + Objects.hashCode(typeCategories);
        return result;
    }
}