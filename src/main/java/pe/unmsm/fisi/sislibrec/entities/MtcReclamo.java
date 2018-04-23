package pe.unmsm.fisi.sislibrec.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * The persistent class for the mtc_reclamo database table.
 * 
 */
@Entity
@Table(name="mtc_reclamo")
@NamedQuery(name="MtcReclamo.findAll", query="SELECT m FROM MtcReclamo m")
public class MtcReclamo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_reclamo")
	private Integer idReclamo;

	private Integer activo;

	private LocalDateTime date;

	@Column(name="date_crea")
	private LocalDateTime dateCrea;

	private String descripcion;

	private String ticket;

	@Column(name="user_crea")
	private String userCrea;

	//bi-directional many-to-one association to MtcEstadoReclamo
	@ManyToOne
	@JoinColumn(name="id_estado_reclamo")
	private MtcEstadoReclamo mtcEstadoReclamo;
	
	@Version
	private Integer version;

	public MtcReclamo() {
	}

	public Integer getIdReclamo() {
		return this.idReclamo;
	}

	public void setIdReclamo(Integer idReclamo) {
		this.idReclamo = idReclamo;
	}

	public Integer getActivo() {
		return this.activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	public LocalDateTime getDate() {
		return this.date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
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

	public String getTicket() {
		return this.ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getUserCrea() {
		return this.userCrea;
	}

	public void setUserCrea(String userCrea) {
		this.userCrea = userCrea;
	}

	public MtcEstadoReclamo getMtcEstadoReclamo() {
		return this.mtcEstadoReclamo;
	}

	public void setMtcEstadoReclamo(MtcEstadoReclamo mtcEstadoReclamo) {
		this.mtcEstadoReclamo = mtcEstadoReclamo;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}	

}