package com.apodlatov.test.respak.controllers.api_v1.dto.incoming;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddTechnicsTypeDto {
    @NotNull
    @Size(min = 3, message = "Название вида техники должно содержать не менее 3 символов.")
    private String name;

    public AddTechnicsTypeDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
