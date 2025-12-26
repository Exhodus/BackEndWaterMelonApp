package exhodus.demo.DTOS;

public class PatronInsertDTO {

    private String nombre;
    private String descripcion;
    private String dificultad;
    private Integer tiempoEstimadoHoras;

    public PatronInsertDTO() {
    }

    public PatronInsertDTO(String nombre,
                           String descripcion,
                           String dificultad,
                           Integer tiempoEstimadoHoras) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dificultad = dificultad;
        this.tiempoEstimadoHoras = tiempoEstimadoHoras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public Integer getTiempoEstimadoHoras() {
        return tiempoEstimadoHoras;
    }

    public void setTiempoEstimadoHoras(Integer tiempoEstimadoHoras) {
        this.tiempoEstimadoHoras = tiempoEstimadoHoras;
    }

    @Override
    public String toString() {
        return "PatronInsertDTO{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", dificultad=" + dificultad +
                ", tiempoEstimadoHoras=" + tiempoEstimadoHoras +
                '}';
    }
}
