package com.apodlatov.test.respak.controller.data.outgoing;

import com.apodlatov.test.respak.data.models.TechnicsType;

public class TechnicsTypeDto {
    private Long id;
    private String name;

    public TechnicsTypeDto(TechnicsType technicsType) {
        this.id = technicsType.getId();
        this.name = technicsType.getName();
    }

    public TechnicsTypeDto() {
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