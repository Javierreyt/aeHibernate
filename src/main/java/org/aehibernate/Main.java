package org.aehibernate;


import org.aehibernate.dao.HibernateUtil;
import org.aehibernate.dao.Servicios;
import org.aehibernate.model.Opinion;
import org.aehibernate.model.Pelicula;

public class Main {
    public static void main(String[] args) {
        //agregarPelicula("El señor de los anillos");
        //listaOpinionesPorUsuario("user1@example.com");
        //Opinion nuevaOpinion = new Opinion("Pelicula muy buena", "user1@example.com", 5);
        //agregarOpinion(1L, nuevaOpinion);

        listaPeliculasPorPuntuacion();
    }
    private static void agregarPelicula(String nombrePelicula) {
        //HISTORIA DE USUARIO 1: Crear nueva pelicula.
        Pelicula p = new Pelicula();
        p.setTitulo(nombrePelicula);

        new Servicios(HibernateUtil.getSessionFactory()).savePelicula(p);
    }

    private static void listaOpinionesPorUsuario(String usuario) {
        //HISTORIA DE USUARIO 2: Listar opiniones por usuario.
        new Servicios(HibernateUtil.getSessionFactory()).opinionesByUsuario(usuario).forEach(System.out::println);
    }

    private static void agregarOpinion(Long peliculaId, Opinion nuevaOpinion) {
        //HISTORIA DE USUARIO 3: Agregar opinion a pelicula.
        new Servicios(HibernateUtil.getSessionFactory()).saveOpinion(peliculaId, nuevaOpinion);
    }

    private static void listaPeliculasPorPuntuacion() {
        //HISTORIA DE USUARIO 4: Listar peliculas por puntuacion.
        new Servicios(HibernateUtil.getSessionFactory()).peliculasByPuntuacion().forEach(System.out::println);
    }
}