package com.apodlatov.test.respak.controllers.api_v1.dto.incoming;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Schema(description = "Данные для получения страницы экзкмпляров видов техники.")
public class GetTechnicsTypesDatasPaged {

    @Min(value = 0, message = "Не меньше 0.")
    @Schema(description = "Id вида техники", defaultValue = "1", type = "number")
    int technicsTypeId;

    @Min(value = 0, message = "Не меньше 0.")
    @Schema(description = "Номер страницы", defaultValue = "0", type = "number")
    int pageNumber;

    @Min(value = 1, message = "Минимальный размер страницы - 1 элемент.")
    @Schema(description = "Размер страницы", defaultValue = "10", type = "number")
    int pageSize = 10;

    @NotBlank(message = "обязательное поле")
    @Pattern(
            regexp="^(id|manufacturerName|)$",
            message="Допустима сортировка только по названию производителя" +
                    "(manufacturerName) или идентификатору(id)")
    @Schema(description = "Поле сортировки",
            defaultValue = "name",
            allowableValues = {"id", "manufacturerName"})
    String sortBy;

    @NotBlank(message = "обязательное поле")
    @Pattern(
            regexp="^(ASC|DESC|)$",
            message="Допустимы значения для направления сортировки ASC, DESC")
    @Schema(description = "Направление сортировки",
            defaultValue = "ASC",
            allowableValues = {"ASC", "DESC"})
    String order;

    public GetTechnicsTypesDatasPaged() {
    }

    @Min(value = 0, message = "Не меньше 0.")
    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(@Min(value = 0, message = "Не меньше 0.") int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Min(value = 1, message = "Минимальный размер страницы - 1 элемент.")
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(@Min(value = 1, message = "Минимальный размер страницы - 1 элемент.") int pageSize) {
        this.pageSize = pageSize;
    }

    public @NotBlank(message = "обязательное поле") @Pattern(
            regexp = "^(id|manufacturerName|)$",
            message = "Допустима сортировка только по названию производителя" +
                    "(manufacturerName) или идентификатору(id)") String getSortBy() {
        return sortBy;
    }

    public void setSortBy(@NotBlank(message = "обязательное поле") @Pattern(
            regexp = "^(id|manufacturerName|)$",
            message = "Допустима сортировка только по названию производителя" +
                    "(manufacturerName) или идентификатору(id)") String sortBy) {
        this.sortBy = sortBy;
    }

    public @NotBlank(message = "обязательное поле") @Pattern(
            regexp = "^(ASC|DESC|)$",
            message = "Допустимы значения для направления сортировки ASC, DESC") String getOrder() {
        return order;
    }

    public void setOrder(@NotBlank(message = "обязательное поле") @Pattern(
            regexp = "^(ASC|DESC|)$",
            message = "Допустимы значения для направления сортировки ASC, DESC") String order) {
        this.order = order;
    }

    @Min(value = 0, message = "Не меньше 0.")
    public int getTechnicsTypeId() {
        return technicsTypeId;
    }

    public void setTechnicsTypeId(@Min(value = 0, message = "Не меньше 0.") int technicsTypeId) {
        this.technicsTypeId = technicsTypeId;
    }
}
