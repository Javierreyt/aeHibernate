package org.aehibernate.dao;

import org.aehibernate.model.Opinion;
import org.aehibernate.model.Pelicula;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Servicios que proporciona métodos para interactuar con la base de datos.
 */
public class Servicios {

    private SessionFactory sessionFactory;
    /**
     * Constructor de la clase Servicios.
     *
     * @param sessionFactory la fábrica de sesiones de Hibernate
     */
    public Servicios(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    /**
     * Guarda una nueva película en la base de datos.
     *
     * @param pelicula la película a guardar
     */
    public void savePelicula(Pelicula pelicula) {
        sessionFactory.inTransaction(session -> session.persist(pelicula));
    }
    /**
     * Obtiene una lista de opiniones de un usuario específico.
     *
     * @param usuario el nombre del usuario
     * @return una lista de opiniones del usuario
     */
    public List<Opinion> opinionesByUsuario(String usuario) {
        List<Opinion> lista = new ArrayList<>(0);
        try(Session session = sessionFactory.openSession()){
            lista = session.createQuery("from Opinion where usuario = :usuario", Opinion.class)
                    .setParameter("usuario", usuario)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    /**
     * Guarda una nueva opinión asociada a una película existente.
     *
     * @param idPelicula el ID de la película
     * @param opinion la opinión a guardar
     */
    public void saveOpinion(Long idPelicula, Opinion opinion) {
        sessionFactory.inTransaction(session -> {
                    Pelicula pelicula = session.get(Pelicula.class, idPelicula);
                    pelicula.addOpinion(opinion);
                    session.persist(opinion);
                });
    }
    /**
     * Obtiene una lista de películas con una puntuación menor o igual a 3.
     *
     * @return una lista de películas con baja puntuación
     */
    public List<String> peliculasByPuntuacion() {
        Integer puntuacion=3;
        List<String> lista = new ArrayList<>(0);
        try(Session session = sessionFactory.openSession()){
            lista= session.createQuery("select p.titulo from Pelicula p join p.opiniones o where o.puntuacion <= :puntuacion", String.class)
                    .setParameter("puntuacion", puntuacion)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
