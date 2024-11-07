package org.aehibernate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "opinion", schema = "aeHibernate")
public class Opinion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "usuario", nullable = false, length = 64)
    private String usuario;

    @Column(name = "puntuacion")
    private Integer puntuacion;

    @Column(name = "pelicula_id")
    private Integer peliculaId;

}