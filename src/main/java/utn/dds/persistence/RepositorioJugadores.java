package utn.dds.persistence;


import java.util.List;

import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

public class RepositorioJugadores implements WithSimplePersistenceUnit {

  public void registrar(Jugador jugador) {
    entityManager().persist(jugador);
  }

  public Jugador buscar(long id) {
    return entityManager().find(Jugador.class, id);
  }

  @SuppressWarnings("unchecked")
  public List<Jugador> todos() {
    return entityManager()
        .createQuery("from Jugador")
        .getResultList();
  }

  @SuppressWarnings("unchecked")
  public List<Jugador> filtrarPorNombre(String nombre) {
    return entityManager()
        .createQuery("from Jugador where nombre = :nombre")
        .setParameter("nombre", nombre)
        .getResultList();
  }

}
