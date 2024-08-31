package utn.dds.persistence;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "formaciones")
public class Formacion {

  @Id
  @GeneratedValue
  @Column(name = "formacion_id")
  private Long id;

  @Column
  private Long goles;

  @ManyToOne
  @JoinColumn(name = "equipo_id")
  private Equipo equipo;

  @ManyToMany
  private List<Jugador> jugadores = new ArrayList<Jugador>();

}
