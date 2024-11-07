package com.apodlatov.test.respak.controllers.api_v1.dto.outgoing;

public class TechnicsModelOptionValueDto {
    String name;
    String value;

    public TechnicsModelOptionValueDto() {
    }

    public TechnicsModelOptionValueDto(String modelOptionName, String modelOptionValue) {
        this.name = modelOptionName;
        this.value = modelOptionValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
