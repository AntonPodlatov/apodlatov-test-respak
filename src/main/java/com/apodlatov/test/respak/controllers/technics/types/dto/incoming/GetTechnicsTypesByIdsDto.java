package com.apodlatov.test.respak.controllers.technics.types.dto.incoming;

import java.util.List;

public class GetTechnicsTypesByIdsDto {
    private List<Long> ids;

    public GetTechnicsTypesByIdsDto() {
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}