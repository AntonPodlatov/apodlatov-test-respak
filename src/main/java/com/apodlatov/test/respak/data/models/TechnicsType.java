package com.apodlatov.test.respak.data.models;

import com.apodlatov.test.respak.data.models.option.ModelOption;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

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
    private Set<TechnicsTypeData> technicsTypeDataSet;

    @Column(nullable = false, name = "tt_name")
    private String name;

    @OneToMany(
            mappedBy = "technicsType",
            fetch = FetchType.LAZY
    )
    private Set<ModelOption> modelOptions;

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

    public Set<TechnicsTypeData> getTechnicsTypeDataSet() {
        return technicsTypeDataSet;
    }

    public void setTechnicsTypeDataSet(Set<TechnicsTypeData> technicsTypeDataSet) {
        this.technicsTypeDataSet = technicsTypeDataSet;
    }

    public Set<ModelOption> getModelOptions() {
        return modelOptions;
    }

    public void setModelOptions(Set<ModelOption> modelOptions) {
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