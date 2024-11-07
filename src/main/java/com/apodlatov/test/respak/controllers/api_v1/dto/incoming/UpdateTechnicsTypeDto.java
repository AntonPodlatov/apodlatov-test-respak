package com.apodlatov.test.respak.controllers.api_v1.dto.incoming;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateTechnicsTypeDto {
    @NotBlank(message = "Обязательное поле.")
    @Size(min = 3, message = "Название вида техники должно содержать не менее 3 символов.")
    String name;

    @Min(value = 1, message = "Id не может быть меньше 1")
    @NotNull
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