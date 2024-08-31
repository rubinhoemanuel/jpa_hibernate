package utn.dds.persistence;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "equipos")
@RequiredArgsConstructor
@Getter
@Setter
public class Equipo {

	@Id
	@GeneratedValue
	@Column(name = "equipo_id")
	private Long id;

	@Column
	private String nombre;

	@Column
	private Long cantidadAfiliados;

}
