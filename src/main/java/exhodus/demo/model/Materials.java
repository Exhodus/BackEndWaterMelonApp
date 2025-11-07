package exhodus.demo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import exhodus.demo.enums.MaterialTypes;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Materials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="material_name")
    private String _materialName;

    @Column(name = "material_tipe")
    private MaterialTypes _materialTipe;

    @Column(name="color")
    private String _color;

    @OneToMany(mappedBy = "material")
    @JsonBackReference
    private List<PatronsMaterials> _patrons;

    public Materials() {
    }

    public Materials(int id, String _materialName, MaterialTypes _materialTipe, String _color) {
        this.id = id;
        this._materialName = _materialName;
        this._materialTipe = _materialTipe;
        this._color = _color;
    }

    public int getId() {
        return id;
    }

    public String get_materialName() {
        return _materialName;
    }

    public void set_materialName(String _materialName) {
        this._materialName = _materialName;
    }

    public MaterialTypes get_materialTipe() {
        return _materialTipe;
    }

    public void set_materialTipe(MaterialTypes _materialTipe) {
        this._materialTipe = _materialTipe;
    }

    public String get_color() {
        return _color;
    }

    public void set_color(String _color) {
        this._color = _color;
    }

    @Override
    public String toString() {
        return "Materials{" +
                "id=" + id +
                ", _materialName='" + _materialName + '\'' +
                ", _materialTipe=" + _materialTipe +
                ", _color='" + _color + '\'' +
                '}';
    }
}
