package com.apodlatov.test.respak.data.models.items;

import com.apodlatov.test.respak.data.models.TechnicsTypeModel;
import com.apodlatov.test.respak.data.models.categories.TvModelCategory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "tvs_models")
public class TvModel extends TechnicsTypeModel {

    @ManyToOne
    @JoinColumn(name = "tv_model_cat_id")
    private TvModelCategory tvModelCategory;

    @Column(name = "tv_model_technology")
    private String technology;

    public TvModel() {
    }

    public TvModelCategory getTvModelCategory() {
        return tvModelCategory;
    }

    public void setTvModelCategory(TvModelCategory tvModelCategory) {
        this.tvModelCategory = tvModelCategory;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        if (!super.equals(o)) {
            return false;
        }

        TvModel tvModel = (TvModel) o;

        return Objects.equals(tvModelCategory, tvModel.tvModelCategory) &&
                Objects.equals(technology, tvModel.technology);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(tvModelCategory);
        result = 31 * result + Objects.hashCode(technology);
        return result;
    }
}