package com.apodlatov.test.respak.data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tt_models")
public class TechnicsTypeModel {

    @Id
    @Column(name = "tt_model_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, name = "tt_model_name")
    private String name;

    @Column(nullable = false, name = "tt_model_color")
    private String color;

    @Column(nullable = false, name = "tt_model_serial_number", unique = true)
    private String serialNumber;

    @Column(nullable = false, name = "tt_model_size")
    private String size;

    @Column(nullable = false, name = "tt_model_price", precision = 12, scale = 2)
    private BigDecimal price;

    @Column(nullable = false, name = "tt_model_is_in_stock")
    private boolean isInStock = false;

    @ManyToOne
    @JoinColumn(name = "tt_id")
    private TechnicsType technicsType;

    @OneToMany(mappedBy = "technicsTypeModel", fetch = FetchType.LAZY)
    private Set<TechnicsTypeModelAttributeValue> attributeValues;

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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

    public Set<TechnicsTypeModelAttributeValue> getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(Set<TechnicsTypeModelAttributeValue> attributeValues) {
        this.attributeValues = attributeValues;
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
                Objects.equals(size, that.size) &&
                Objects.equals(price, that.price) &&
                Objects.equals(technicsType, that.technicsType) &&
                Objects.equals(attributeValues, that.attributeValues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id, name, color,
                serialNumber, size, price,
                isInStock, technicsType, attributeValues);
    }
}