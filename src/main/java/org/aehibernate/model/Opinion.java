package org.aehibernate.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa una opinión sobre una película.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "opinion", schema = "aeHibernate")
public class Opinion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Lob
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "usuario", nullable = false)
    private String usuario;

    @Column(name = "puntuacion")
    private Integer puntuacion;

    @ManyToOne
    @JoinColumn(name = "pelicula_id")
    private Pelicula pelicula;

    /**
     * Constructor de la clase Opinion.
     *
     * @param opinion la descripción de la opinión
     * @param user el usuario que hizo la opinión
     * @param puntuacion la puntuación dada a la película
     */
    public Opinion(String opinion, String user, Integer puntuacion) {
        this.descripcion = opinion;
        this.usuario = user;
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "Opinion{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", usuario='" + usuario + '\'' +
                ", puntuacion=" + puntuacion +
                ", pelicula=" + (pelicula != null ? pelicula.getId() : null) +
                '}';
    }
}
