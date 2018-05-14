package pe.unmsm.fisi.sislibrec.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the mtc_reclamo database table.
 * 
 */
@Entity
@Table(name="mtc_reclamo")
@NamedQuery(name="MtcReclamo.findAll", query="SELECT m FROM MtcReclamo m")
public class MtcReclamo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_reclamo")
	private Integer idReclamo;

	private Integer activo;

	@Column(name="date_crea")
	private Timestamp dateCrea;

	@Column(name="date_modi")
	private Timestamp dateModi;

	private String descripcion;

	@Column(name="fecha_hora")
	private Timestamp fechaHora;

	private String observacion;

	private String ticket;

	@Column(name="user_crea")
	private String userCrea;

	@Column(name="user_modi")
	private String userModi;
	
	@Version
	private Integer version;

	//bi-directional many-to-one association to MtcDependencia
	@ManyToOne
	@JoinColumn(name="id_dependencia")
	private MtcDependencia mtcDependencia;

	//bi-directional many-to-one association to MtcEmpresa
	@ManyToOne
	@JoinColumn(name="id_empresa")
	private MtcEmpresa mtcEmpresa;

	//bi-directional many-to-one association to MtcEstadoReclamo
	@ManyToOne
	@JoinColumn(name="id_estado_reclamo")
	private MtcEstadoReclamo mtcEstadoReclamo;

	//bi-directional many-to-one association to MtcTipoReclamo
	@ManyToOne
	@JoinColumn(name="id_tipo_reclamo")
	private MtcTipoReclamo mtcTipoReclamo;

	//bi-directional many-to-one association to MtcReclamoRespuesta
	@OneToMany(mappedBy="mtcReclamo")
	private List<MtcReclamoRespuesta> mtcReclamoRespuestas;

	//bi-directional many-to-one association to MtcSancion
	@OneToMany(mappedBy="mtcReclamo")
	private List<MtcSancion> mtcSancions;

	public MtcReclamo() {
	}

	public Integer getIdReclamo() {
		return this.idReclamo;
	}

	public void setIdReclamo(Integer idReclamo) {
		this.idReclamo = idReclamo;
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

	public Timestamp getFechaHora() {
		return this.fechaHora;
	}

	public void setFechaHora(Timestamp fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getTicket() {
		return this.ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
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

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public MtcDependencia getMtcDependencia() {
		return this.mtcDependencia;
	}

	public void setMtcDependencia(MtcDependencia mtcDependencia) {
		this.mtcDependencia = mtcDependencia;
	}

	public MtcEmpresa getMtcEmpresa() {
		return this.mtcEmpresa;
	}

	public void setMtcEmpresa(MtcEmpresa mtcEmpresa) {
		this.mtcEmpresa = mtcEmpresa;
	}

	public MtcEstadoReclamo getMtcEstadoReclamo() {
		return this.mtcEstadoReclamo;
	}

	public void setMtcEstadoReclamo(MtcEstadoReclamo mtcEstadoReclamo) {
		this.mtcEstadoReclamo = mtcEstadoReclamo;
	}

	public MtcTipoReclamo getMtcTipoReclamo() {
		return this.mtcTipoReclamo;
	}

	public void setMtcTipoReclamo(MtcTipoReclamo mtcTipoReclamo) {
		this.mtcTipoReclamo = mtcTipoReclamo;
	}

	public List<MtcReclamoRespuesta> getMtcReclamoRespuestas() {
		return this.mtcReclamoRespuestas;
	}

	public void setMtcReclamoRespuestas(List<MtcReclamoRespuesta> mtcReclamoRespuestas) {
		this.mtcReclamoRespuestas = mtcReclamoRespuestas;
	}

	public MtcReclamoRespuesta addMtcReclamoRespuesta(MtcReclamoRespuesta mtcReclamoRespuesta) {
		getMtcReclamoRespuestas().add(mtcReclamoRespuesta);
		mtcReclamoRespuesta.setMtcReclamo(this);

		return mtcReclamoRespuesta;
	}

	public MtcReclamoRespuesta removeMtcReclamoRespuesta(MtcReclamoRespuesta mtcReclamoRespuesta) {
		getMtcReclamoRespuestas().remove(mtcReclamoRespuesta);
		mtcReclamoRespuesta.setMtcReclamo(null);

		return mtcReclamoRespuesta;
	}

	public List<MtcSancion> getMtcSancions() {
		return this.mtcSancions;
	}

	public void setMtcSancions(List<MtcSancion> mtcSancions) {
		this.mtcSancions = mtcSancions;
	}

	public MtcSancion addMtcSancion(MtcSancion mtcSancion) {
		getMtcSancions().add(mtcSancion);
		mtcSancion.setMtcReclamo(this);

		return mtcSancion;
	}

	public MtcSancion removeMtcSancion(MtcSancion mtcSancion) {
		getMtcSancions().remove(mtcSancion);
		mtcSancion.setMtcReclamo(null);

		return mtcSancion;
	}

}