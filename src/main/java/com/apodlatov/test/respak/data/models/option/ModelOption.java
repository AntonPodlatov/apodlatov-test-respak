package com.apodlatov.test.respak.data.models.option;

import com.apodlatov.test.respak.data.models.TechnicsTypeData;

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
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "models_options")
public class ModelOption {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "model_option_name")
    private String modelOptionName;

    @ManyToOne
    @JoinColumn(name = "ttd_id")
    private TechnicsTypeData technicsTypeData;

    @OneToMany(
            mappedBy = "modelOption",
            fetch = FetchType.LAZY
    )
    private Set<ModelOptionValue> modelOptionValues;

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

    public TechnicsTypeData getTechnicsTypeData() {
        return technicsTypeData;
    }

    public void setTechnicsTypeData(TechnicsTypeData technicsTypeData) {
        this.technicsTypeData = technicsTypeData;
    }

    public Set<ModelOptionValue> getModelOptionValues() {
        return modelOptionValues;
    }

    public void setModelOptionValues(Set<ModelOptionValue> modelOptionValues) {
        this.modelOptionValues = modelOptionValues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModelOption that = (ModelOption) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(modelOptionName, that.modelOptionName) &&
                Objects.equals(technicsTypeData, that.technicsTypeData) &&
                Objects.equals(modelOptionValues, that.modelOptionValues);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(modelOptionName);
        result = 31 * result + Objects.hashCode(technicsTypeData);
        result = 31 * result + Objects.hashCode(modelOptionValues);
        return result;
    }
}