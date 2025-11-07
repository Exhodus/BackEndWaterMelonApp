package exhodus.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonMerge;
import exhodus.demo.enums.Difficulty;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Patrons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "patron_name", nullable = false)
    private String _patronName;

    @Column(name = "description")
    private String _description;

    @Column(name="difficulty")
    private Difficulty _difficulty;

    @Column(name = "estimated_time")
    private int _estimatedTime;


    @JoinColumn(name = "user_id")
    private int _userId;

    @OneToMany(mappedBy = "patron", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<PatronsMaterials> _materials;

    @OneToMany(mappedBy = "_idPatron", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Images> _images;

    public Patrons() {
    }

    public Patrons(int id, String _patronName, String _description, Difficulty _difficulty, int _estimatedTime, int _userId, List<PatronsMaterials> _materials, List<Images> _images) {
        this.id = id;
        this._patronName = _patronName;
        this._description = _description;
        this._difficulty = _difficulty;
        this._estimatedTime = _estimatedTime;
        this._userId = _userId;
        this._materials = _materials;
        this._images = _images;
    }

    public int getId() {
        return id;
    }

    public String get_patronName() {
        return _patronName;
    }

    public void set_patronName(String _patronName) {
        this._patronName = _patronName;
    }

    public String get_description() {
        return _description;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    public Difficulty get_difficulty() {
        return _difficulty;
    }

    public void set_difficulty(Difficulty _difficulty) {
        this._difficulty = _difficulty;
    }

    public int get_estimatedTime() {
        return _estimatedTime;
    }

    public void set_estimatedTime(int _estimatedTime) {
        this._estimatedTime = _estimatedTime;
    }

    public int get_userId() {
        return _userId;
    }

    public void set_userId(int _userId) {
        this._userId = _userId;
    }

    @Override
    public String toString() {
        return "Patrons{" +
                "id=" + id +
                ", _patronName='" + _patronName + '\'' +
                ", _description='" + _description + '\'' +
                ", _difficulty=" + _difficulty +
                ", _estimatedTime=" + _estimatedTime +
                ", _userId=" + _userId +
                ", _materials=" + _materials +
                ", _images=" + _images +
                '}';
    }
}
