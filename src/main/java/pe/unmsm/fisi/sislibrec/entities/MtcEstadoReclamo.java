package pe.unmsm.fisi.sislibrec.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


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
	private Timestamp dateCrea;

	@Column(name="date_modi")
	private Timestamp dateModi;

	private String descripcion;

	@Column(name="user_crea")
	private String userCrea;

	@Column(name="user_modi")
	private String userModi;

	//bi-directional many-to-one association to MtcReclamo
	@OneToMany(mappedBy="mtcEstadoReclamo")
	private List<MtcReclamo> mtcReclamos;

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

	public List<MtcReclamo> getMtcReclamos() {
		return this.mtcReclamos;
	}

	public void setMtcReclamos(List<MtcReclamo> mtcReclamos) {
		this.mtcReclamos = mtcReclamos;
	}

	public MtcReclamo addMtcReclamo(MtcReclamo mtcReclamo) {
		getMtcReclamos().add(mtcReclamo);
		mtcReclamo.setMtcEstadoReclamo(this);

		return mtcReclamo;
	}

	public MtcReclamo removeMtcReclamo(MtcReclamo mtcReclamo) {
		getMtcReclamos().remove(mtcReclamo);
		mtcReclamo.setMtcEstadoReclamo(null);

		return mtcReclamo;
	}

}