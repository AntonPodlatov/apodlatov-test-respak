package com.apodlatov.test.respak.data.models.categories;

import com.apodlatov.test.respak.data.models.items.TvModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Table
@Entity(name = "tvs_model_categories")
public class TvModelCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "tm_cat_name")
    private String name;

    public TvModelCategory() {
    }

    @OneToMany(
            mappedBy = "technicsType",
            fetch = FetchType.LAZY
    )
    private Set<TvModel> tvModels;
}
