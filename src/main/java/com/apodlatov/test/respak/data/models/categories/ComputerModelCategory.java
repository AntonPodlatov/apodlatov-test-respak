package com.apodlatov.test.respak.data.models.categories;

import com.apodlatov.test.respak.data.models.items.ComputerModel;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Table
@Entity(name = "computers_model_categories")
public class ComputerModelCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "cm_cat_name")
    private String name;

    public ComputerModelCategory() {
    }

    @OneToMany(
            mappedBy = "technicsType",
            fetch = FetchType.LAZY
    )
    private Set<ComputerModel> computerModels;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComputerModelCategory that = (ComputerModelCategory) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(name);
        return result;
    }
}
