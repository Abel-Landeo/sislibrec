package pe.unmsm.fisi.sislibrec.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the mtc_sancion database table.
 * 
 */
@Entity
@Table(name="mtc_sancion")
@NamedQuery(name="MtcSancion.findAll", query="SELECT m FROM MtcSancion m")
public class MtcSancion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_sancion")
	private Integer idSancion;

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
	@ManyToOne
	@JoinColumn(name="id_reclamo")
	private MtcReclamo mtcReclamo;

	//bi-directional many-to-one association to MtcTipoSancion
	@ManyToOne
	@JoinColumn(name="id_tipo_sancion")
	private MtcTipoSancion mtcTipoSancion;

	public MtcSancion() {
	}

	public Integer getIdSancion() {
		return this.idSancion;
	}

	public void setIdSancion(Integer idSancion) {
		this.idSancion = idSancion;
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

	public MtcReclamo getMtcReclamo() {
		return this.mtcReclamo;
	}

	public void setMtcReclamo(MtcReclamo mtcReclamo) {
		this.mtcReclamo = mtcReclamo;
	}

	public MtcTipoSancion getMtcTipoSancion() {
		return this.mtcTipoSancion;
	}

	public void setMtcTipoSancion(MtcTipoSancion mtcTipoSancion) {
		this.mtcTipoSancion = mtcTipoSancion;
	}

}