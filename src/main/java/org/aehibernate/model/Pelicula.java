package org.aehibernate.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una película.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "pelicula", schema = "aeHibernate")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @OneToMany(mappedBy = "pelicula", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Opinion> opiniones = new ArrayList<>(0);

    /**
     * Agrega una opinión a la lista de opiniones de la película.
     *
     * @param opinion la opinión a agregar
     */
    public void addOpinion(Opinion opinion) {
        opiniones.add(opinion);
        opinion.setPelicula(this);
    }
}