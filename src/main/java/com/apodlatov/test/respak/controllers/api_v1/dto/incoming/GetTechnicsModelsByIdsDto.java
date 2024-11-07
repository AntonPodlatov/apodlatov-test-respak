package com.apodlatov.test.respak.controllers.api_v1.dto.incoming;

import java.util.List;

public class GetTechnicsModelsByIdsDto {
    List<Long> ids;

    public GetTechnicsModelsByIdsDto() {
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}