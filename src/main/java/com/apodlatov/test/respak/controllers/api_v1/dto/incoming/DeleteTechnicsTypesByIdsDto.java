package com.apodlatov.test.respak.controllers.api_v1.dto.incoming;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class DeleteTechnicsTypesByIdsDto {
    @NotNull
    @Size(min = 1, message = "Список id видов техники должен содержать не менее 1 элемента")
    private List<Long> ids;

    public DeleteTechnicsTypesByIdsDto() {
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}