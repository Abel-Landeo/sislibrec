package pe.unmsm.fisi.sislibrec.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the mtc_usuario database table.
 * 
 */
@Entity
@Table(name="mtc_usuario")
@NamedQuery(name="MtcUsuario.findAll", query="SELECT m FROM MtcUsuario m")
public class MtcUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Integer idUsuario;

	private Integer activo;

	@Column(name="apellido_materno")
	private String apellidoMaterno;

	@Column(name="apellido_paterno")
	private String apellidoPaterno;

	@Column(name="date_crea")
	private Timestamp dateCrea;

	@Column(name="date_modi")
	private Timestamp dateModi;

	private String dni;

	private String login;

	private String nombres;

	private String password;

	@Column(name="user_crea")
	private String userCrea;

	@Column(name="user_modi")
	private String userModi;

	//bi-directional many-to-one association to MtcEmpresa
	@OneToMany(mappedBy="mtcUsuario")
	private List<MtcEmpresa> mtcEmpresas;

	//bi-directional many-to-one association to MtcPerfil
	@ManyToOne
	@JoinColumn(name="id_perfil")
	private MtcPerfil mtcPerfil;

	public MtcUsuario() {
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getActivo() {
		return this.activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	public String getApellidoMaterno() {
		return this.apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getApellidoPaterno() {
		return this.apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
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

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		mtcEmpresa.setMtcUsuario(this);

		return mtcEmpresa;
	}

	public MtcEmpresa removeMtcEmpresa(MtcEmpresa mtcEmpresa) {
		getMtcEmpresas().remove(mtcEmpresa);
		mtcEmpresa.setMtcUsuario(null);

		return mtcEmpresa;
	}

	public MtcPerfil getMtcPerfil() {
		return this.mtcPerfil;
	}

	public void setMtcPerfil(MtcPerfil mtcPerfil) {
		this.mtcPerfil = mtcPerfil;
	}

}