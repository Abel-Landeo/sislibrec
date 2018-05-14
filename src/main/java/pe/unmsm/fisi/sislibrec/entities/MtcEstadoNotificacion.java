package pe.unmsm.fisi.sislibrec.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the mtc_estado_notificacion database table.
 * 
 */
@Entity
@Table(name="mtc_estado_notificacion")
@NamedQuery(name="MtcEstadoNotificacion.findAll", query="SELECT m FROM MtcEstadoNotificacion m")
public class MtcEstadoNotificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estado_notificacion")
	private Integer idEstadoNotificacion;

	private Integer activo;

	@Column(name="date_crea")
	private Timestamp dateCrea;

	@Column(name="date_modi")
	private Timestamp dateModi;

	private String descripcion;

	@Column(name="user_crea")
	private String userCrea;

	@Column(name="user_modi")
	private String userModi;

	//bi-directional many-to-one association to MtcNotificacion
	@OneToMany(mappedBy="mtcEstadoNotificacion")
	private List<MtcNotificacion> mtcNotificacions;

	public MtcEstadoNotificacion() {
	}

	public Integer getIdEstadoNotificacion() {
		return this.idEstadoNotificacion;
	}

	public void setIdEstadoNotificacion(Integer idEstadoNotificacion) {
		this.idEstadoNotificacion = idEstadoNotificacion;
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
		mtcNotificacion.setMtcEstadoNotificacion(this);

		return mtcNotificacion;
	}

	public MtcNotificacion removeMtcNotificacion(MtcNotificacion mtcNotificacion) {
		getMtcNotificacions().remove(mtcNotificacion);
		mtcNotificacion.setMtcEstadoNotificacion(null);

		return mtcNotificacion;
	}

}