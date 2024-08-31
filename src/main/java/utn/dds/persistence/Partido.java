package utn.dds.persistence;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "partidos")
@RequiredArgsConstructor
@Getter
@Setter
public class Partido {

  @Id
  @GeneratedValue
  @Column(name= "partido_id")
  private Long id;

  @Column
  private LocalDate fecha;

  @Column
  private Integer cantidadEspectadores;

  @ManyToOne
  @JoinColumn(name = "formacion_local_id", foreignKey=@ForeignKey(name = "Fk_formacion_local_id"))
  private Formacion local;

  @ManyToOne
  @JoinColumn(name = "formacion_visitante_id", foreignKey=@ForeignKey(name = "Fk_formacion_visitante_id"))
  private Formacion visitante;

  public Formacion ganador() {
    if (local.getGoles().compareTo(visitante.getGoles()) > 0) {
      return local;
    } else {
      return visitante;
    }
  }

}
