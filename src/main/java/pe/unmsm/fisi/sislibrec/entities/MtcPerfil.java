package pe.unmsm.fisi.sislibrec.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the mtc_perfil database table.
 * 
 */
@Entity
@Table(name="mtc_perfil")
@NamedQuery(name="MtcPerfil.findAll", query="SELECT m FROM MtcPerfil m")
public class MtcPerfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_perfil")
	private Integer idPerfil;

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

	//bi-directional many-to-one association to MtcUsuario
	@OneToMany(mappedBy="mtcPerfil")
	private List<MtcUsuario> mtcUsuarios;

	public MtcPerfil() {
	}

	public Integer getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
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

	public List<MtcUsuario> getMtcUsuarios() {
		return this.mtcUsuarios;
	}

	public void setMtcUsuarios(List<MtcUsuario> mtcUsuarios) {
		this.mtcUsuarios = mtcUsuarios;
	}

	public MtcUsuario addMtcUsuario(MtcUsuario mtcUsuario) {
		getMtcUsuarios().add(mtcUsuario);
		mtcUsuario.setMtcPerfil(this);

		return mtcUsuario;
	}

	public MtcUsuario removeMtcUsuario(MtcUsuario mtcUsuario) {
		getMtcUsuarios().remove(mtcUsuario);
		mtcUsuario.setMtcPerfil(null);

		return mtcUsuario;
	}

}