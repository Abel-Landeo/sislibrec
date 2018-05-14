package pe.unmsm.fisi.sislibrec.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the mtc_notificacion database table.
 * 
 */
@Entity
@Table(name="mtc_notificacion")
@NamedQuery(name="MtcNotificacion.findAll", query="SELECT m FROM MtcNotificacion m")
public class MtcNotificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_notificacion")
	private Integer idNotificacion;

	private Integer activo;

	@Column(name="date_crea")
	private Timestamp dateCrea;

	@Column(name="date_modi")
	private Timestamp dateModi;

	@Column(name="user_crea")
	private String userCrea;

	@Column(name="user_modi")
	private String userModi;

	//bi-directional many-to-one association to MtcEstadoNotificacion
	@ManyToOne
	@JoinColumn(name="id_estado_notificacion")
	private MtcEstadoNotificacion mtcEstadoNotificacion;

	//bi-directional many-to-one association to MtcReclamoRespuesta
	@ManyToOne
	@JoinColumn(name="id_reclamo_respuesta")
	private MtcReclamoRespuesta mtcReclamoRespuesta;

	public MtcNotificacion() {
	}

	public Integer getIdNotificacion() {
		return this.idNotificacion;
	}

	public void setIdNotificacion(Integer idNotificacion) {
		this.idNotificacion = idNotificacion;
	}

	public Integer getActivo() {
		return this.activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	public Timestamp getDateCrea() {
		return this.dateCrea;
	}

	public void setDateCrea(Timestamp dateCrea) {
		this.dateCrea = dateCrea;
	}

	public Timestamp getDateModi() {
		return this.dateModi;
	}

	public void setDateModi(Timestamp dateModi) {
		this.dateModi = dateModi;
	}

	public String getUserCrea() {
		return this.userCrea;
	}

	public void setUserCrea(String userCrea) {
		this.userCrea = userCrea;
	}

	public String getUserModi() {
		return this.userModi;
	}

	public void setUserModi(String userModi) {
		this.userModi = userModi;
	}

	public MtcEstadoNotificacion getMtcEstadoNotificacion() {
		return this.mtcEstadoNotificacion;
	}

	public void setMtcEstadoNotificacion(MtcEstadoNotificacion mtcEstadoNotificacion) {
		this.mtcEstadoNotificacion = mtcEstadoNotificacion;
	}

	public MtcReclamoRespuesta getMtcReclamoRespuesta() {
		return this.mtcReclamoRespuesta;
	}

	public void setMtcReclamoRespuesta(MtcReclamoRespuesta mtcReclamoRespuesta) {
		this.mtcReclamoRespuesta = mtcReclamoRespuesta;
	}

}