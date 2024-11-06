package com.apodlatov.test.respak.data.models;

import com.apodlatov.test.respak.data.models.option.ModelOption;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "technics_type")
public class TechnicsType {
    @Id
    @Column(name = "tt_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(
            mappedBy = "technicsType",
            fetch = FetchType.LAZY
    )
    private List<TechnicsTypeData> technicsTypeDataSet;

    @Column(nullable = false, name = "tt_name")
    private String name;

    @OneToMany(
            mappedBy = "technicsType",
            fetch = FetchType.LAZY
    )
    private List<ModelOption> modelOptions;

    public TechnicsType() {
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

    public List<TechnicsTypeData> getTechnicsTypeDataSet() {
        return technicsTypeDataSet;
    }

    public void setTechnicsTypeDataSet(List<TechnicsTypeData> technicsTypeDataSet) {
        this.technicsTypeDataSet = technicsTypeDataSet;
    }

    public List<ModelOption> getModelOptions() {
        return modelOptions;
    }

    public void setModelOptions(List<ModelOption> modelOptions) {
        this.modelOptions = modelOptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TechnicsType that = (TechnicsType) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(modelOptions, that.modelOptions) &&
                Objects.equals(technicsTypeDataSet, that.technicsTypeDataSet);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(technicsTypeDataSet);
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(modelOptions);
        return result;
    }
}