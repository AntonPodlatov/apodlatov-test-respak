package com.apodlatov.test.respak.data.models.items;

import com.apodlatov.test.respak.data.models.categories.ComputerModelCategory;
import com.apodlatov.test.respak.data.models.TechnicsTypeModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "computers_models")
public class ComputerModel extends TechnicsTypeModel {

    @ManyToOne
    @JoinColumn(name = "cm_cat_id")
    private ComputerModelCategory category;

    @Column(name = "cm_processor_type")
    private String processorType;

    public ComputerModel() {
    }

    public ComputerModelCategory getCategory() {
        return category;
    }

    public void setCategory(ComputerModelCategory category) {
        this.category = category;
    }

    public String getProcessorType() {
        return processorType;
    }

    public void setProcessorType(String processorType) {
        this.processorType = processorType;
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

        ComputerModel that = (ComputerModel) o;
        return Objects.equals(category, that.category) &&
                Objects.equals(processorType, that.processorType);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(category);
        result = 31 * result + Objects.hashCode(processorType);
        return result;
    }
}