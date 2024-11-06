package com.apodlatov.test.respak.controllers.technics.types.dto.incoming;

import java.util.List;

public class DeleteTechnicsTypesByIdsDto {
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