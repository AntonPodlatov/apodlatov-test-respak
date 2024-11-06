package com.apodlatov.test.respak.data.models;

import com.apodlatov.test.respak.data.models.option.ModelOptionValue;
import com.apodlatov.test.respak.data.models.side.data.Color;
import com.apodlatov.test.respak.data.models.side.data.ModelSize;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "technics_models")
public class TechnicsModel {

    @Id
    @Column(name = "tm_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, name = "tm_name")
    private String name;

    @OneToOne
    @JoinColumn(name = "color_id", referencedColumnName = "color_id")
    private Color color;

    @Column(nullable = false, name = "tm_serial_number", unique = true)
    private String serialNumber;

    @OneToOne
    @JoinColumn(
            name = "tm_size_id",
            referencedColumnName = "ms_size_id")
    private ModelSize modelSize;

    @Column(nullable = false, name = "tm_price", precision = 12, scale = 2)
    private BigDecimal price;

    @Column(nullable = false, name = "tm_is_in_stock")
    private boolean isInStock = false;

    @ManyToOne
    @JoinColumn(name = "tt_id")
    private TechnicsType technicsType;

    @OneToMany(
            mappedBy = "technicsModel",
            fetch = FetchType.LAZY
    )
    private Set<ModelOptionValue> modelOptionsValues;

    public TechnicsModel() {
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public ModelSize getModelSize() {
        return modelSize;
    }

    public void setModelSize(ModelSize modelSize) {
        this.modelSize = modelSize;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isInStock() {
        return isInStock;
    }

    public void setInStock(boolean inStock) {
        isInStock = inStock;
    }

    public TechnicsType getTechnicsType() {
        return technicsType;
    }

    public void setTechnicsType(TechnicsType technicsType) {
        this.technicsType = technicsType;
    }

    public Set<ModelOptionValue> getModelOptionsValues() {
        return modelOptionsValues;
    }

    public void setModelOptionsValues(Set<ModelOptionValue> modelOptionsValues) {
        this.modelOptionsValues = modelOptionsValues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TechnicsModel that = (TechnicsModel) o;

        return isInStock == that.isInStock &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(color, that.color) &&
                Objects.equals(serialNumber, that.serialNumber) &&
                Objects.equals(modelSize, that.modelSize) &&
                Objects.equals(technicsType, that.technicsType) &&
                Objects.equals(modelOptionsValues, that.modelOptionsValues) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(color);
        result = 31 * result + Objects.hashCode(serialNumber);
        result = 31 * result + Objects.hashCode(price);
        result = 31 * result + Boolean.hashCode(isInStock);
        result = 31 * result + Objects.hashCode(modelSize);
        result = 31 * result + Objects.hashCode(technicsType);
        result = 31 * result + Objects.hashCode(modelOptionsValues);
        return result;
    }
}