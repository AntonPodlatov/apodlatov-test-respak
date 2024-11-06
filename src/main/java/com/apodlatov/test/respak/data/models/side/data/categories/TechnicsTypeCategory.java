package com.apodlatov.test.respak.data.models.side.data.categories;

import com.apodlatov.test.respak.data.models.TechnicsTypeData;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Table
@Entity(name = "technics_types_categories")
public class TechnicsTypeCategory {

    @Id
    @Column(name = "ttc_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, name = "ttc_cat_name")
    private String name;

    @ManyToMany(mappedBy = "typeCategories", fetch = FetchType.LAZY)
    private List<TechnicsTypeData> technicsTypeData;

    public TechnicsTypeCategory() {
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

    public List<TechnicsTypeData> getTechnicsTypeData() {
        return technicsTypeData;
    }

    public void setTechnicsTypeData(List<TechnicsTypeData> technicsTypeData) {
        this.technicsTypeData = technicsTypeData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TechnicsTypeCategory that = (TechnicsTypeCategory) o;

        return Objects.equals(id, that.id) &&
                Objects.equals(technicsTypeData, that.technicsTypeData) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(technicsTypeData);
        return result;
    }
}
