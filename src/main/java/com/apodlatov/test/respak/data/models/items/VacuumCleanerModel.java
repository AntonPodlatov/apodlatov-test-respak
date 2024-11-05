package com.apodlatov.test.respak.data.models.items;

import com.apodlatov.test.respak.data.models.TechnicsTypeModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vacuum_cleaners_models")
public class VacuumCleanerModel extends TechnicsTypeModel {

    @Column(nullable = false, name = "vc_dust_collector_volume")
    private int dustCollectorVolumeMilliliters;

    @Column(name = "vc_modes_count")
    private int modesCount;

    public VacuumCleanerModel() {
    }

    public int getDustCollectorVolumeMilliliters() {
        return dustCollectorVolumeMilliliters;
    }

    public void setDustCollectorVolumeMilliliters(int dustCollectorVolumeMilliliters) {
        this.dustCollectorVolumeMilliliters = dustCollectorVolumeMilliliters;
    }

    public int getModesCount() {
        return modesCount;
    }

    public void setModesCount(int modesCount) {
        this.modesCount = modesCount;
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

        VacuumCleanerModel that = (VacuumCleanerModel) o;

        return dustCollectorVolumeMilliliters == that.dustCollectorVolumeMilliliters &&
                modesCount == that.modesCount;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + dustCollectorVolumeMilliliters;
        result = 31 * result + modesCount;
        return result;
    }
}