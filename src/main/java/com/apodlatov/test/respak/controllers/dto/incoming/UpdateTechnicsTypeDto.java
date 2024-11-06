package com.apodlatov.test.respak.controllers.dto.incoming;

public class UpdateTechnicsTypeDto {
    String name;
    long id;

    public UpdateTechnicsTypeDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
