package pe.unmsm.fisi.sislibrec.dto;

import java.io.Serializable;

public class Reclamo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer idReclamo;
	private EstadoReclamo estadoReclamo;
	private String descripcion;
	private String date;
	private String ticket;
	private Integer activo;
	private String userSession;
	
	public Reclamo(){ }

	public Integer getIdReclamo() {
		return idReclamo;
	}

	public void setIdReclamo(Integer idReclamo) {
		this.idReclamo = idReclamo;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public EstadoReclamo getEstadoReclamo() {
		return estadoReclamo;
	}

	public void setEstadoReclamo(EstadoReclamo reclamo) {
		this.estadoReclamo = reclamo;
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
}
