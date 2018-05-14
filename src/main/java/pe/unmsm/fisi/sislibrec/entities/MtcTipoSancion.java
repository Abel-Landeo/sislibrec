package pe.unmsm.fisi.sislibrec.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the mtc_tipo_sancion database table.
 * 
 */
@Entity
@Table(name="mtc_tipo_sancion")
@NamedQuery(name="MtcTipoSancion.findAll", query="SELECT m FROM MtcTipoSancion m")
public class MtcTipoSancion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_sancion")
	private Integer idTipoSancion;

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

	//bi-directional many-to-one association to MtcSancion
	@OneToMany(mappedBy="mtcTipoSancion")
	private List<MtcSancion> mtcSancions;

	public MtcTipoSancion() {
	}

	public Integer getIdTipoSancion() {
		return this.idTipoSancion;
	}

	public void setIdTipoSancion(Integer idTipoSancion) {
		this.idTipoSancion = idTipoSancion;
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

	public List<MtcSancion> getMtcSancions() {
		return this.mtcSancions;
	}

	public void setMtcSancions(List<MtcSancion> mtcSancions) {
		this.mtcSancions = mtcSancions;
	}

	public MtcSancion addMtcSancion(MtcSancion mtcSancion) {
		getMtcSancions().add(mtcSancion);
		mtcSancion.setMtcTipoSancion(this);

		return mtcSancion;
	}

	public MtcSancion removeMtcSancion(MtcSancion mtcSancion) {
		getMtcSancions().remove(mtcSancion);
		mtcSancion.setMtcTipoSancion(null);

		return mtcSancion;
	}

}