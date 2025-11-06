package exhodus.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "materials_patrons")
public class PatronsMaterials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "patron_id")
    @JsonBackReference
    private Patrons patron;

    @ManyToOne
    @JoinColumn(name = "material_id")
    @JsonManagedReference
    private Materials material;
    private int quantity;

}
