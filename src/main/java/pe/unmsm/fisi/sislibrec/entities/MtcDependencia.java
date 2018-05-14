package pe.unmsm.fisi.sislibrec.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the mtc_dependencia database table.
 * 
 */
@Entity
@Table(name="mtc_dependencia")
@NamedQuery(name="MtcDependencia.findAll", query="SELECT m FROM MtcDependencia m")
public class MtcDependencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_dependencia")
	private Integer idDependencia;

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
	@OneToMany(mappedBy="mtcDependencia")
	private List<MtcReclamo> mtcReclamos;

	public MtcDependencia() {
	}

	public Integer getIdDependencia() {
		return this.idDependencia;
	}

	public void setIdDependencia(Integer idDependencia) {
		this.idDependencia = idDependencia;
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
		mtcReclamo.setMtcDependencia(this);

		return mtcReclamo;
	}

	public MtcReclamo removeMtcReclamo(MtcReclamo mtcReclamo) {
		getMtcReclamos().remove(mtcReclamo);
		mtcReclamo.setMtcDependencia(null);

		return mtcReclamo;
	}

}