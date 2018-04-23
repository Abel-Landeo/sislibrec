package pe.unmsm.fisi.sislibrec.dto;

import java.io.Serializable;

public class EstadoReclamo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer idEstadoReclamo;
	private String descripcion;
	private Integer activo;
	private String userSession;
	private String dateSession;
	
	public EstadoReclamo(){ }

	public Integer getIdEstadoReclamo() {
		return idEstadoReclamo;
	}

	public void setIdEstadoReclamo(Integer idEstadoReclamo) {
		this.idEstadoReclamo = idEstadoReclamo;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUserSession() {
		return userSession;
	}

	public void setUserSession(String userSession) {
		this.userSession = userSession;
	}

	public String getDateSession() {
		return dateSession;
	}

	public void setDateSession(String dateSession) {
		this.dateSession = dateSession;
	}
}
