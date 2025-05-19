package mx.unam.aragon.ico.te.musicamvc.modelos;

import jakarta.persistence.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Objects;

@Entity
@Table(name="artists")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name ="name", nullable=false)
    private String nombre;
    private String genero;
    private Integer edad;
    private String descripcion;
    private String imagen;

    public Artista() {
    }

    public Artista(int id, String nombre, String genero, String descripcion, Integer edad, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.descripcion = descripcion;
        this.edad = edad;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Artista artista = (Artista) o;
        return id == artista.id && Objects.equals(nombre, artista.nombre) && Objects.equals(genero, artista.genero) && Objects.equals(edad, artista.edad) && Objects.equals(descripcion, artista.descripcion) && Objects.equals(imagen, artista.imagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, genero, edad, descripcion, imagen);
    }

    @Override
    public String toString() {
        return "Artista{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", edad=" + edad +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
