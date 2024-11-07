package com.apodlatov.test.respak.controllers.api_v1.dto.outgoing;

public class TechnicsModelOptionDto {
    private Long id;
    private String modelOptionName;
    private Long technicsTypeId;

    public TechnicsModelOptionDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelOptionName() {
        return modelOptionName;
    }

    public void setModelOptionName(String modelOptionName) {
        this.modelOptionName = modelOptionName;
    }

    public Long getTechnicsTypeId() {
        return technicsTypeId;
    }

    public void setTechnicsTypeId(Long technicsTypeId) {
        this.technicsTypeId = technicsTypeId;
    }
}