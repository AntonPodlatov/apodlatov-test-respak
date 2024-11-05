package com.apodlatov.test.respak.data.models.items;

import com.apodlatov.test.respak.data.models.TechnicsTypeModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "smartphones_models")
public class SmartphoneModel extends TechnicsTypeModel {

    @Column(nullable = false, name = "sm_memory_count_gb")
    private int memoryCountGb;

    @Column(nullable = false, name = "sm_cameras_count")
    private int camerasCount;

    public SmartphoneModel() {
    }

    public int getMemoryCountGb() {
        return memoryCountGb;
    }

    public void setMemoryCountGb(int memoryCountGb) {
        this.memoryCountGb = memoryCountGb;
    }

    public int getCamerasCount() {
        return camerasCount;
    }

    public void setCamerasCount(int camerasCount) {
        this.camerasCount = camerasCount;
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

        SmartphoneModel that = (SmartphoneModel) o;

        return memoryCountGb == that.memoryCountGb &&
                camerasCount == that.camerasCount;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + memoryCountGb;
        result = 31 * result + camerasCount;
        return result;
    }
}