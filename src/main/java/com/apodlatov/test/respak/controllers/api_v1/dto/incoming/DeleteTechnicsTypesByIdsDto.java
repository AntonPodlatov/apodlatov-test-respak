package com.apodlatov.test.respak.controllers.api_v1.dto.incoming;

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