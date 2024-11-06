package com.apodlatov.test.respak.data.models.option;

import com.apodlatov.test.respak.data.models.TechnicsModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "models_options_values")
public class ModelOptionValue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "models_option_value")
    private String modelOptionValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mo_id")
    private ModelOption modelOption;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tm_id")
    private TechnicsModel technicsModel;

    public ModelOptionValue() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelOptionValue() {
        return modelOptionValue;
    }

    public void setModelOptionValue(String modelOptionValue) {
        this.modelOptionValue = modelOptionValue;
    }

    public ModelOption getModelOption() {
        return modelOption;
    }

    public void setModelOption(ModelOption modelOption) {
        this.modelOption = modelOption;
    }

    public TechnicsModel getTechnicsModel() {
        return technicsModel;
    }

    public void setTechnicsModel(TechnicsModel technicsModel) {
        this.technicsModel = technicsModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModelOptionValue that = (ModelOptionValue) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(technicsModel, that.technicsModel) &&
                Objects.equals(modelOptionValue, that.modelOptionValue) &&
                Objects.equals(modelOption, that.modelOption);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(modelOptionValue);
        result = 31 * result + Objects.hashCode(technicsModel);
        result = 31 * result + Objects.hashCode(modelOption);
        return result;
    }
}