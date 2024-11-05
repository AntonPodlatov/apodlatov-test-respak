package com.apodlatov.test.respak.data.models.items;

import com.apodlatov.test.respak.data.models.TechnicsTypeModel;
import com.apodlatov.test.respak.data.models.enums.CompressorType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;


@Entity
@Table(name = "refrigerators_models")
public class RefrigeratorModel extends TechnicsTypeModel {

    @Column(name = "rf_doors_count")
    private int doorsCount;

    @Column(name = "rf_model_compressor_type")
    private CompressorType compressorType;

    public RefrigeratorModel() {
    }

    public int getDoorsCount() {
        return doorsCount;
    }

    public void setDoorsCount(int doorsCount) {
        this.doorsCount = doorsCount;
    }

    public CompressorType getCompressorType() {
        return compressorType;
    }

    public void setCompressorType(CompressorType compressorType) {
        this.compressorType = compressorType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        if (!super.equals(o)) {
            return false;
        }

        RefrigeratorModel that = (RefrigeratorModel) o;

        return doorsCount == that.doorsCount &&
                compressorType == that.compressorType;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + doorsCount;
        result = 31 * result + Objects.hashCode(compressorType);
        return result;
    }
}