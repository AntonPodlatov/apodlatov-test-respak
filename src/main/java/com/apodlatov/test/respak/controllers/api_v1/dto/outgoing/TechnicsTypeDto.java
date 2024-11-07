package com.apodlatov.test.respak.controllers.api_v1.dto.outgoing;

public class TechnicsTypeDto {
    private Long id;
    private String name;

    public TechnicsTypeDto() {
    }

    public TechnicsTypeDto(Long id, String name) {
        this.id = id;
        this.name = name;
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
}