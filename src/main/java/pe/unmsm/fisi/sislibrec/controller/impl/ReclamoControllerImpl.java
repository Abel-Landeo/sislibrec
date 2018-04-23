package pe.unmsm.fisi.sislibrec.controller.impl;

import java.time.LocalDateTime;

import javax.ejb.Stateless;
import javax.inject.Inject;

import pe.unmsm.fisi.sislibrec.controller.ReclamoController;
import pe.unmsm.fisi.sislibrec.dao.ReclamoDao;
import pe.unmsm.fisi.sislibrec.dto.Reclamo;
import pe.unmsm.fisi.sislibrec.entities.MtcReclamo;
import pe.unmsm.fisi.sislibrec.transformer.ReclamoTransformer;

@Stateless
public class ReclamoControllerImpl implements ReclamoController{
	
	@Inject
	ReclamoDao reclamod;
	
	@Inject
	ReclamoTransformer reclamot;

	@Override
	public void insert(Reclamo reclamo) {
		MtcReclamo mtcReclamo = reclamot.getEntityFromDTO(reclamo);
		mtcReclamo.setUserCrea(reclamo.getUserSession());
		mtcReclamo.setDateCrea(LocalDateTime.now());
		
		reclamod.insert(mtcReclamo);
	}
	
	@Override
	public void insertv2(Reclamo reclamo) {
		MtcReclamo mtcReclamo = reclamot.getEntityFromDTO(reclamo);
		mtcReclamo.setUserCrea(reclamo.getUserSession());
		mtcReclamo.setDateCrea(LocalDateTime.now());
		
		reclamod.insertv2(mtcReclamo);
	}
	
	@Override
	public void insertv3(Reclamo reclamo) {
		MtcReclamo mtcReclamo = reclamot.getEntityFromDTO(reclamo);
		mtcReclamo.setUserCrea(reclamo.getUserSession());
		mtcReclamo.setDateCrea(LocalDateTime.now());
		
		reclamod.insertv3(mtcReclamo);
	}

}
