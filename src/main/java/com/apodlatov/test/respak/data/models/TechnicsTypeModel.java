package com.apodlatov.test.respak.data.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tt_models")
@Inheritance(strategy = InheritanceType.JOINED)
public class TechnicsTypeModel {

    @Id
    @Column(name = "tt_model_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "tt_model_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "color_id", nullable = false)
    private Color color;

    @Column(nullable = false, name = "tt_model_serial_number", unique = true)
    private String serialNumber;

    @OneToOne
    @JoinColumn(
            name = "tt_model_size_id",
            referencedColumnName = "tt_model_size_id")
    private ModelSize modelSize;

    @Column(nullable = false, name = "tt_model_price", precision = 12, scale = 2)
    private BigDecimal price;

    @Column(nullable = false, name = "tt_model_is_in_stock")
    private boolean isInStock = false;

    @ManyToOne
    @JoinColumn(name = "tt_id")
    private TechnicsType technicsType;

    public TechnicsTypeModel() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TechnicsTypeModel that = (TechnicsTypeModel) o;

        return isInStock == that.isInStock &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(color, that.color) &&
                Objects.equals(serialNumber, that.serialNumber) &&
                Objects.equals(modelSize, that.modelSize) &&
                Objects.equals(price, that.price) &&
                Objects.equals(technicsType, that.technicsType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id, name, color,
                serialNumber, modelSize, price,
                isInStock, technicsType);
    }
}