package com.apodlatov.test.respak.data.models.option;

import com.apodlatov.test.respak.data.models.TechnicsType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "models_options")
public class ModelOption {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "model_option_name")
    private String modelOptionName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tt_id")
    private TechnicsType technicsType;

    @OneToMany(
            mappedBy = "modelOption",
            fetch = FetchType.LAZY
    )
    private List<ModelOptionValue> modelOptionValues;

    public ModelOption() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelOptionName() {
        return modelOptionName;
    }

    public void setModelOptionName(String modelOptionName) {
        this.modelOptionName = modelOptionName;
    }

    public TechnicsType getTechnicsType() {
        return technicsType;
    }

    public void setTechnicsType(TechnicsType technicsType) {
        this.technicsType = technicsType;
    }

    public List<ModelOptionValue> getModelOptionValues() {
        return modelOptionValues;
    }

    public void setModelOptionValues(List<ModelOptionValue> modelOptionValues) {
        this.modelOptionValues = modelOptionValues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModelOption that = (ModelOption) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(modelOptionName, that.modelOptionName) &&
                Objects.equals(technicsType, that.technicsType) &&
                Objects.equals(modelOptionValues, that.modelOptionValues);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(modelOptionName);
        result = 31 * result + Objects.hashCode(technicsType);
        result = 31 * result + Objects.hashCode(modelOptionValues);
        return result;
    }
}