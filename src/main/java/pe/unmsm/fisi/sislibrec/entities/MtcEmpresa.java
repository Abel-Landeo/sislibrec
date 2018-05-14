package pe.unmsm.fisi.sislibrec.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the mtc_empresa database table.
 * 
 */
@Entity
@Table(name="mtc_empresa")
@NamedQuery(name="MtcEmpresa.findAll", query="SELECT m FROM MtcEmpresa m")
public class MtcEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_empresa")
	private Integer idEmpresa;

	private Integer activo;

	@Column(name="date_crea")
	private Timestamp dateCrea;

	@Column(name="date_modi")
	private Timestamp dateModi;

	private String nombre;

	private String rubro;

	@Column(name="user_crea")
	private String userCrea;

	@Column(name="user_modi")
	private String userModi;

	//bi-directional many-to-one association to MtcRazonSocial
	@ManyToOne
	@JoinColumn(name="id_razon_social")
	private MtcRazonSocial mtcRazonSocial;

	//bi-directional many-to-one association to MtcUsuario
	@ManyToOne
	@JoinColumn(name="id_usuario_contacto")
	private MtcUsuario mtcUsuario;

	//bi-directional many-to-one association to MtcReclamo
	@OneToMany(mappedBy="mtcEmpresa")
	private List<MtcReclamo> mtcReclamos;

	public MtcEmpresa() {
	}

	public Integer getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRubro() {
		return this.rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
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

	public MtcRazonSocial getMtcRazonSocial() {
		return this.mtcRazonSocial;
	}

	public void setMtcRazonSocial(MtcRazonSocial mtcRazonSocial) {
		this.mtcRazonSocial = mtcRazonSocial;
	}

	public MtcUsuario getMtcUsuario() {
		return this.mtcUsuario;
	}

	public void setMtcUsuario(MtcUsuario mtcUsuario) {
		this.mtcUsuario = mtcUsuario;
	}

	public List<MtcReclamo> getMtcReclamos() {
		return this.mtcReclamos;
	}

	public void setMtcReclamos(List<MtcReclamo> mtcReclamos) {
		this.mtcReclamos = mtcReclamos;
	}

	public MtcReclamo addMtcReclamo(MtcReclamo mtcReclamo) {
		getMtcReclamos().add(mtcReclamo);
		mtcReclamo.setMtcEmpresa(this);

		return mtcReclamo;
	}

	public MtcReclamo removeMtcReclamo(MtcReclamo mtcReclamo) {
		getMtcReclamos().remove(mtcReclamo);
		mtcReclamo.setMtcEmpresa(null);

		return mtcReclamo;
	}

}