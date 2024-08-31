package utn.dds.persistence;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "jugadores")
public class Jugador {

  @Id
  @GeneratedValue
  @Column(name = "jugador_id")
  private Long id;

  @Column
  private String nombre;

  @Column
  private String posicion;

  @OneToMany
  @JoinColumn(name = "mejor_jugador_id")
  private List<Partido> mejoresPartidos;

}
