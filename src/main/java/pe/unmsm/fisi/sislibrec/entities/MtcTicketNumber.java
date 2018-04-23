package pe.unmsm.fisi.sislibrec.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the mtc_ticket_number database table.
 * 
 */
@Entity
@Table(name="mtc_ticket_number")
@NamedQuery(name="MtcTicketNumber.findAll", query="SELECT m FROM MtcTicketNumber m")
public class MtcTicketNumber implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ticket_number")
	private Integer idTicketNumber;

	private Integer activo;

	@Column(name="date_crea")
	private Timestamp dateCrea;

	private Integer number;

	private String prefix;

	@Column(name="user_crea")
	private String userCrea;

	public MtcTicketNumber() {
	}

	public Integer getIdTicketNumber() {
		return this.idTicketNumber;
	}

	public void setIdTicketNumber(Integer idTicketNumber) {
		this.idTicketNumber = idTicketNumber;
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

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getPrefix() {
		return this.prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getUserCrea() {
		return this.userCrea;
	}

	public void setUserCrea(String userCrea) {
		this.userCrea = userCrea;
	}

}