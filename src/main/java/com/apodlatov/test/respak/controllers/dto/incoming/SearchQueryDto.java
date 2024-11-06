package com.apodlatov.test.respak.controllers.dto.incoming;

import java.math.BigDecimal;

public class SearchQueryDto {
    private String technicsModelNameTerm;
    //filters
    private Long technicsTypeId;
    private Long colorId;
    private BigDecimal priceFrom;
    private BigDecimal priceTo;

    public SearchQueryDto() {
    }

    public String getTechnicsModelNameTerm() {
        return technicsModelNameTerm;
    }

    public void setTechnicsModelNameTerm(String technicsModelNameTerm) {
        this.technicsModelNameTerm = technicsModelNameTerm;
    }

    public Long getTechnicsTypeId() {
        return technicsTypeId;
    }

    public void setTechnicsTypeId(Long technicsTypeId) {
        this.technicsTypeId = technicsTypeId;
    }

    public Long getColorId() {
        return colorId;
    }

    public void setColorId(Long colorId) {
        this.colorId = colorId;
    }

    public BigDecimal getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(BigDecimal priceFrom) {
        this.priceFrom = priceFrom;
    }

    public BigDecimal getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(BigDecimal priceTo) {
        this.priceTo = priceTo;
    }
}