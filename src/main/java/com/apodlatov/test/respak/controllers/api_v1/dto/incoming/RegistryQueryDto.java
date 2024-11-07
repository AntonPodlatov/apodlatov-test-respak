package com.apodlatov.test.respak.controllers.api_v1.dto.incoming;

import java.math.BigDecimal;

public class RegistryQueryDto {
    private String technicsModelNameTerm;
    //filters
    private Long technicsTypeId;
    private Long colorId;
    private BigDecimal priceFrom;
    private BigDecimal priceTo;

    int pageNumber;
    int pageSize = 10;
    String sortBy;
    boolean ascending;

    public RegistryQueryDto() {
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

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortBy() {
        return sortBy == null ? "name" :
                sortBy.isEmpty() ? "name" : sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public boolean isAscending() {
        return ascending;
    }

    public void setAscending(boolean ascending) {
        this.ascending = ascending;
    }
}