package pe.unmsm.fisi.sislibrec.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the mtc_razon_social database table.
 * 
 */
@Entity
@Table(name="mtc_razon_social")
@NamedQuery(name="MtcRazonSocial.findAll", query="SELECT m FROM MtcRazonSocial m")
public class MtcRazonSocial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_razon_social")
	private Integer idRazonSocial;

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

	//bi-directional many-to-one association to MtcEmpresa
	@OneToMany(mappedBy="mtcRazonSocial")
	private List<MtcEmpresa> mtcEmpresas;

	public MtcRazonSocial() {
	}

	public Integer getIdRazonSocial() {
		return this.idRazonSocial;
	}

	public void setIdRazonSocial(Integer idRazonSocial) {
		this.idRazonSocial = idRazonSocial;
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

	public List<MtcEmpresa> getMtcEmpresas() {
		return this.mtcEmpresas;
	}

	public void setMtcEmpresas(List<MtcEmpresa> mtcEmpresas) {
		this.mtcEmpresas = mtcEmpresas;
	}

	public MtcEmpresa addMtcEmpresa(MtcEmpresa mtcEmpresa) {
		getMtcEmpresas().add(mtcEmpresa);
		mtcEmpresa.setMtcRazonSocial(this);

		return mtcEmpresa;
	}

	public MtcEmpresa removeMtcEmpresa(MtcEmpresa mtcEmpresa) {
		getMtcEmpresas().remove(mtcEmpresa);
		mtcEmpresa.setMtcRazonSocial(null);

		return mtcEmpresa;
	}

}