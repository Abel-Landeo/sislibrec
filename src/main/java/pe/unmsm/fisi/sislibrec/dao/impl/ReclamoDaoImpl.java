package pe.unmsm.fisi.sislibrec.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.unmsm.fisi.sislibrec.dao.ReclamoDao;
import pe.unmsm.fisi.sislibrec.entities.MtcReclamo;
import pe.unmsm.fisi.sislibrec.entities.MtcTicketNumber;

@Stateless
public class ReclamoDaoImpl implements ReclamoDao{
	
	@PersistenceContext
	protected EntityManager em;

	@Override
	public void insert(MtcReclamo mtcReclamo) {
		MtcTicketNumber ticketNumber = em.find(MtcTicketNumber.class, 1);
		Integer number = ticketNumber.getNumber();
		number = number + 1;
		ticketNumber.setNumber(number);
		em.persist(ticketNumber);
		String ticket = ticketNumber.getPrefix() + String.format("%09d", number);
		mtcReclamo.setTicket(ticket);
		
		em.persist(mtcReclamo);
	}
	
	@Override
	public void insertv2(MtcReclamo mtcReclamo) {
		synchronized(em){
			MtcTicketNumber ticketNumber = em.find(MtcTicketNumber.class, 2);
			Integer number = ticketNumber.getNumber();
			number = number + 1;
			ticketNumber.setNumber(number);
			em.persist(ticketNumber);
			String ticket = ticketNumber.getPrefix() + String.format("%09d", number);
			mtcReclamo.setTicket(ticket);
			em.persist(mtcReclamo);
		}
	}

	@Override
	public void insertv3(MtcReclamo mtcReclamo) {
		synchronized(em){
			em.createNativeQuery("select public.insert_reclamo(:p_idEstadoReclamo, :p_descripcion) ")
			.setParameter("p_idEstadoReclamo", mtcReclamo.getMtcEstadoReclamo().getIdEstadoReclamo())
			.setParameter("p_descripcion", mtcReclamo.getDescripcion())
			.getSingleResult();
		}
	}
}
