package com.apodlatov.test.respak.controllers.api_v1.dto.incoming;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Schema(description =
        "Данные для запроса создания записи о виде техники. Например: пылесос, кофемашина итд.")
public class AddTechnicsTypeDto {
    @NotBlank(message = "Обязательное поле.")
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
