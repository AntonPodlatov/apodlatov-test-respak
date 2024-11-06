package com.apodlatov.test.respak.data.models.side.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "model_sizes")
public class ModelSize {
    @Id
    @Column(name = "ms_size_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, name = "ms_size_height")
    private long height;

    @Column(nullable = false, name = "ms_size_width")
    private long width;

    @Column(nullable = false, name = "ms_size_depth")
    private long depth;

    public ModelSize() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public long getWidth() {
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    public long getDepth() {
        return depth;
    }

    public void setDepth(long depth) {
        this.depth = depth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ModelSize modelSize = (ModelSize) o;
        
        return height == modelSize.height &&
                width == modelSize.width && 
                depth == modelSize.depth && 
                Objects.equals(id, modelSize.id);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Long.hashCode(height);
        result = 31 * result + Long.hashCode(width);
        result = 31 * result + Long.hashCode(depth);
        return result;
    }
}