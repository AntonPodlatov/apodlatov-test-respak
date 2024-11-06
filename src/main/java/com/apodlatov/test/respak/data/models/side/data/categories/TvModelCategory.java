package com.apodlatov.test.respak.data.models.side.data.categories;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
//@Entity(name = "tvs_model_categories")
public class TvModelCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "tm_cat_name")
    private String name;

    public TvModelCategory() {
    }

}
