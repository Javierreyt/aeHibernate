package org.aehibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pelicula", schema = "aeHibernate")
public class Pelicula {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

}