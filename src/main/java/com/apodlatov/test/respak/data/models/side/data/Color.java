package com.apodlatov.test.respak.data.models.side.data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "colors")
public class Color {
    @Id
    @Column(name = "color_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, name = "color_name")
    private String colorName;

    @Column(nullable = false, name = "color_hex_value")
    private String hexValue;

    public Color() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getHexValue() {
        return hexValue;
    }

    public void setHexValue(String hexValue) {
        this.hexValue = hexValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Color color = (Color) o;

        return Objects.equals(id, color.id) &&
                Objects.equals(colorName, color.colorName) &&
                Objects.equals(hexValue, color.hexValue);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(colorName);
        result = 31 * result + Objects.hashCode(hexValue);
        return result;
    }
}