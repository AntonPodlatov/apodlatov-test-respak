package com.apodlatov.test.respak.controllers.api_v1.dto.outgoing;

import java.util.List;

public class TechnicsTypeWithDatasDto {
    private Long id;
    private String name;
    private List<TechnicsTypeDataDto> technicsTypeDtos;

    public TechnicsTypeWithDatasDto() {
    }

    public TechnicsTypeWithDatasDto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public TechnicsTypeWithDatasDto(long id, String name, List<TechnicsTypeDataDto> technicsTypeDataDtos) {
        this.id = id;
        this.name = name;
        this.technicsTypeDtos = technicsTypeDataDtos;
    }

    public List<TechnicsTypeDataDto> getTechnicsTypeDtos() {
        return technicsTypeDtos;
    }

    public void setTechnicsTypeDatas(List<TechnicsTypeDataDto> technicsTypeDataDtos) {
        this.technicsTypeDtos = getTechnicsTypeDtos();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}