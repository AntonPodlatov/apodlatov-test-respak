package com.apodlatov.test.respak.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "tt_model_attribute_values")
public class TechnicsTypeModelAttributeValue {
    @Id
    @Column(name = "tt_model_attribute_value_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "tt_model_attribute_value_value")
    private String value;

    @ManyToOne
    @JoinColumn(name = "tt_model_id")
    private TechnicsTypeModel technicsTypeModel;

    @ManyToOne
    @JoinColumn(name = "tt_model_attribute_id")
    private TechnicsTypeModelAttribute technicsTypeModelAttribute;

    public TechnicsTypeModelAttributeValue() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TechnicsTypeModel getTechnicsTypeModel() {
        return technicsTypeModel;
    }

    public void setTechnicsTypeModel(TechnicsTypeModel technicsTypeModel) {
        this.technicsTypeModel = technicsTypeModel;
    }

    public TechnicsTypeModelAttribute getTechnicsTypeModelAttribute() {
        return technicsTypeModelAttribute;
    }

    public void setTechnicsTypeModelAttribute(TechnicsTypeModelAttribute technicsTypeModelAttribute) {
        this.technicsTypeModelAttribute = technicsTypeModelAttribute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TechnicsTypeModelAttributeValue that = (TechnicsTypeModelAttributeValue) o;

        return Objects.equals(id, that.id) &&
                Objects.equals(value, that.value) &&
                Objects.equals(technicsTypeModel, that.technicsTypeModel) &&
                Objects.equals(technicsTypeModelAttribute, that.technicsTypeModelAttribute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, technicsTypeModel, technicsTypeModelAttribute);
    }
}