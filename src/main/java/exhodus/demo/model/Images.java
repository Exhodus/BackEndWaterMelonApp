package exhodus.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table
public class Images {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "_images")
    @JsonBackReference
    private int _idPatron;

    @Column(name = "url", unique = true)
    private String _url;

    @Column(name = "type")
    private String _type;

    public Images() {
    }

    public int getId() {
        return id;
    }

    public int get_idPatron() {
        return _idPatron;
    }

    public void set_idPatron(int _idPatron) {
        this._idPatron = _idPatron;
    }

    public String get_url() {
        return _url;
    }

    public void set_url(String _url) {
        this._url = _url;
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public Images(int _idPatron, String _url, String _type) {
        this.id = id;
        this._idPatron = _idPatron;
        this._url = _url;
        this._type = _type;
    }

    @Override
    public String toString() {
        return "Images{" +
                "id=" + id +
                ", _idPatron=" + _idPatron +
                ", _url='" + _url + '\'' +
                ", _type='" + _type + '\'' +
                '}';
    }
}
