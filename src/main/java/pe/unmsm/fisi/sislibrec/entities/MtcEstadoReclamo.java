package pe.unmsm.fisi.sislibrec.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * The persistent class for the mtc_estado_reclamo database table.
 * 
 */
@Entity
@Table(name="mtc_estado_reclamo")
@NamedQuery(name="MtcEstadoReclamo.findAll", query="SELECT m FROM MtcEstadoReclamo m")
public class MtcEstadoReclamo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estado_reclamo")
	private Integer idEstadoReclamo;

	private Integer activo;

	@Column(name="date_crea")
	private LocalDateTime dateCrea;

	private String descripcion;

	@Column(name="user_crea")
	private String userCrea;

	public MtcEstadoReclamo() {
	}

	public Integer getIdEstadoReclamo() {
		return this.idEstadoReclamo;
	}

	public void setIdEstadoReclamo(Integer idEstadoReclamo) {
		this.idEstadoReclamo = idEstadoReclamo;
	}

	public Integer getActivo() {
		return this.activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	public LocalDateTime getDateCrea() {
		return this.dateCrea;
	}

	public void setDateCrea(LocalDateTime dateCrea) {
		this.dateCrea = dateCrea;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUserCrea() {
		return this.userCrea;
	}

	public void setUserCrea(String userCrea) {
		this.userCrea = userCrea;
	}
}