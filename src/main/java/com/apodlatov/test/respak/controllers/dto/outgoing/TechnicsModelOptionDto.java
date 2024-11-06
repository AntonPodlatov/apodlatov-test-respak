package com.apodlatov.test.respak.controllers.dto.outgoing;

public class TechnicsModelOptionDto {
    String name;
    String value;

    public TechnicsModelOptionDto() {
    }

    public TechnicsModelOptionDto(String modelOptionName, String modelOptionValue) {
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
