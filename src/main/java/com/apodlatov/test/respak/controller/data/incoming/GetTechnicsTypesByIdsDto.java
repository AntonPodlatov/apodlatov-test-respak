package com.apodlatov.test.respak.controller.data.incoming;

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