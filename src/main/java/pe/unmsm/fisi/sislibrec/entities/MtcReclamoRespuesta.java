package pe.unmsm.fisi.sislibrec.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the mtc_reclamo_respuesta database table.
 * 
 */
@Entity
@Table(name="mtc_reclamo_respuesta")
@NamedQuery(name="MtcReclamoRespuesta.findAll", query="SELECT m FROM MtcReclamoRespuesta m")
public class MtcReclamoRespuesta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_reclamo_respuesta")
	private Integer idReclamoRespuesta;

	private Integer activo;

	@Column(name="date_crea")
	private Timestamp dateCrea;

	@Column(name="date_modi")
	private Timestamp dateModi;

	private String respuesta;

	@Column(name="user_crea")
	private String userCrea;

	@Column(name="user_modi")
	private String userModi;

	//bi-directional many-to-one association to MtcNotificacion
	@OneToMany(mappedBy="mtcReclamoRespuesta")
	private List<MtcNotificacion> mtcNotificacions;

	//bi-directional many-to-one association to MtcReclamo
	@ManyToOne
	@JoinColumn(name="id_reclamo")
	private MtcReclamo mtcReclamo;

	public MtcReclamoRespuesta() {
	}

	public Integer getIdReclamoRespuesta() {
		return this.idReclamoRespuesta;
	}

	public void setIdReclamoRespuesta(Integer idReclamoRespuesta) {
		this.idReclamoRespuesta = idReclamoRespuesta;
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

	public String getRespuesta() {
		return this.respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
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

	public List<MtcNotificacion> getMtcNotificacions() {
		return this.mtcNotificacions;
	}

	public void setMtcNotificacions(List<MtcNotificacion> mtcNotificacions) {
		this.mtcNotificacions = mtcNotificacions;
	}

	public MtcNotificacion addMtcNotificacion(MtcNotificacion mtcNotificacion) {
		getMtcNotificacions().add(mtcNotificacion);
		mtcNotificacion.setMtcReclamoRespuesta(this);

		return mtcNotificacion;
	}

	public MtcNotificacion removeMtcNotificacion(MtcNotificacion mtcNotificacion) {
		getMtcNotificacions().remove(mtcNotificacion);
		mtcNotificacion.setMtcReclamoRespuesta(null);

		return mtcNotificacion;
	}

	public MtcReclamo getMtcReclamo() {
		return this.mtcReclamo;
	}

	public void setMtcReclamo(MtcReclamo mtcReclamo) {
		this.mtcReclamo = mtcReclamo;
	}

}