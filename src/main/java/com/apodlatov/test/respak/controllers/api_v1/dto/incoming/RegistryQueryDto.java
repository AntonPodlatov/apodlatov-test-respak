package com.apodlatov.test.respak.controllers.api_v1.dto.incoming;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Schema(description = "Данные для запроса поиска моделей в реестре, " +
        "чтобы не использовать свойство (кроме свойств пагинации) " +
        "можно указать null или не включать свойство в тело запроса.")
public class RegistryQueryDto {
    @Null
    @Schema(description = "Регистр-независимая подстрока для поиска моделей техники",
     defaultValue = "a")
    private String technicsModelNameTerm;
    //filters

    @Null
    @Min(value = 1, message = "id вида техники не может быть меньше 1.")
    @Schema(description = "id типа(вида) техники", defaultValue = "1")
    private Long technicsTypeId;

    @Null
    @Min(value = 1, message = "id цвета не может быть меньше 1.")
    @Schema(description = "id цвета техники", defaultValue = "null")
    private Long colorId;

    @Null
    @Min(value = 0, message = "Не меньше 0.")
    @Schema(description = "цена от", defaultValue = "0", type = "number")
    private BigDecimal priceFrom;

    @Null
    @Min(value = 0, message = "Не меньше 0.")
    @Schema(description = "цена до", defaultValue = "9999999999", type = "number")
    private BigDecimal priceTo;

    @NotNull
    @Min(value = 0, message = "Не меньше 0.")
    @Schema(description = "Номер страницы", defaultValue = "0", type = "number")
    int pageNumber;

    @NotNull
    @Min(value = 1, message = "Минимальный размер страницы - 1 элемент.")
    @Schema(description = "Размер страницы", defaultValue = "10", type = "number")
    int pageSize = 10;

    @NotNull
    @Pattern(
            regexp="^(name|price|)$",
            message="Допустима сортировка только по полю имя(name) или цена(price)")
    @Schema(description = "Поле сортировки",
            defaultValue = "name",
            allowableValues = {"name", "price"})
    String sortBy;

    @NotNull
    @Pattern(
            regexp="^(ASC|DESC|)$",
            message="Допустимы значения для направления сортировки ASC, DESC")
    @Schema(description = "Направление сортировки",
            defaultValue = "ASC",
            allowableValues = {"ASC", "DESC"})
    String order;

    public RegistryQueryDto() {
    }

    public String getTechnicsModelNameTerm() {
        return technicsModelNameTerm;
    }

    public void setTechnicsModelNameTerm(String technicsModelNameTerm) {
        this.technicsModelNameTerm = technicsModelNameTerm;
    }

    public Long getTechnicsTypeId() {
        return technicsTypeId;
    }

    public void setTechnicsTypeId(Long technicsTypeId) {
        this.technicsTypeId = technicsTypeId;
    }

    public Long getColorId() {
        return colorId;
    }

    public void setColorId(Long colorId) {
        this.colorId = colorId;
    }

    public BigDecimal getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(BigDecimal priceFrom) {
        this.priceFrom = priceFrom;
    }

    public BigDecimal getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(BigDecimal priceTo) {
        this.priceTo = priceTo;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortBy() {
        return sortBy == null ? "name" :
                sortBy.isEmpty() ? "name" : sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getOrder() {
        if (order == null || order.isEmpty()) {
            return "ASC";
        }

        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}