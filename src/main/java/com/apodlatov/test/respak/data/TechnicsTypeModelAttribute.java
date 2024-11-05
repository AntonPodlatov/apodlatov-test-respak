package com.apodlatov.test.respak.data;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "tt_model_attributes")
public class TechnicsTypeModelAttribute {

    @Id
    @Column(name = "tt_model_attribute_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, name = "tt_model_attribute_name", unique = true)
    private String name;

    @OneToMany(mappedBy = "technicsTypeModelAttribute", fetch = FetchType.LAZY)
    private Set<TechnicsTypeModelAttributeValue> attributeValues;

    public TechnicsTypeModelAttribute() {}

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

    public Set<TechnicsTypeModelAttributeValue> getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(Set<TechnicsTypeModelAttributeValue> attributeValues) {
        this.attributeValues = attributeValues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TechnicsTypeModelAttribute that = (TechnicsTypeModelAttribute) o;

        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(attributeValues, that.attributeValues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, attributeValues);
    }
}