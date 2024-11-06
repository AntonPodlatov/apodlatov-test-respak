package com.apodlatov.test.respak.controllers.dto.outgoing;

import com.apodlatov.test.respak.data.models.side.data.Color;
import com.apodlatov.test.respak.data.models.side.data.ModelSize;

import java.math.BigDecimal;
import java.util.List;

public class TechnicsModelDto {
    private Long id;
    private String name;
    private Color color;
    private String serialNumber;
    private ModelSize modelSize;
    private BigDecimal price;
    private boolean isInStock;
    private List<TechnicsModelOptionDto> modelOptionsValuesDtos;

    public TechnicsModelDto() {
    }

    public TechnicsModelDto(
            Long id, String name, Color color,
            String serialNumber, ModelSize modelSize,
            BigDecimal price, boolean isInStock, TechnicsTypeDataDto technicsTypeData,
            List<TechnicsModelOptionDto> modelOptionsValuesDtos) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.serialNumber = serialNumber;
        this.modelSize = modelSize;
        this.price = price;
        this.isInStock = isInStock;
        this.modelOptionsValuesDtos = modelOptionsValuesDtos;
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

    public List<TechnicsModelOptionDto> getModelOptionsValues() {
        return modelOptionsValuesDtos;
    }

    public void setModelOptionsValuesDtos(List<TechnicsModelOptionDto> dtos) {
        this.modelOptionsValuesDtos = dtos;
    }
}