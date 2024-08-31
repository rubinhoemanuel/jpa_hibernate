package utn.dds.persistence;

import io.github.flbulgarelli.jpa.extras.test.SimplePersistenceTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ContextTest implements SimplePersistenceTest {

  RepositorioJugadores repo = new RepositorioJugadores();

  @Test
  public void testInsertarYTraerTodos() {

    withTransaction(() -> {

      Jugador dani = new Jugador();
      dani.setNombre("Dani");
      dani.setPosicion("11");

      Jugador pedro = new Jugador();
      pedro.setNombre("Pedro");
      pedro.setPosicion("10");

      repo.registrar(dani);
      repo.registrar(pedro);

      assertEquals(2, repo.todos().size());

    });

  }

  @Test
  public void testInsertarYTraerUno() {

    withTransaction(() -> {

      var dani = new Jugador();
      dani.setNombre("Dani");
      dani.setPosicion("11");

      repo.registrar(dani);

      assertNotNull(dani.getId());

      assertNotNull(repo.buscar(dani.getId()));
    });
  }

  @Test
  void persistirEquipo() {

    withTransaction(() -> {

      var equipo = new Equipo();
      equipo.setNombre("Boca Juniors");
      equipo.setCantidadAfiliados(Long.parseLong("330000"));

      entityManager().persist(equipo);

      assertNotNull(
          entityManager().find(Equipo.class, equipo.getId())
      );
      assertEquals(
          equipo.getId(),
          entityManager().find(Equipo.class, equipo.getId()).getId()
      );
      // si implementamos equals
      assertEquals(
          equipo,
          entityManager().find(Equipo.class, equipo.getId())
      );
      // esto NO siempre será cierto, :(
      assertSame(
          equipo,
          entityManager().find(Equipo.class, equipo.getId())
      );

    });
  }

  @Test
  public void testInsertarYTraerTodasLasFormaciones() {

    withTransaction(() -> {

      var jugadoresBocaJuniors = new ArrayList<Jugador>();
      

      var formacionBocaJuniors = new Formacion();
      formacionBocaJuniors.setJugadores();
      dani.setNombre("Dani");
      dani.setPosicion("11");

      Jugador pedro = new Jugador();
      pedro.setNombre("Pedro");
      pedro.setPosicion("10");

      repo.registrar(dani);
      repo.registrar(pedro);

      assertEquals(2, repo.todos().size());

    });

  }

}
