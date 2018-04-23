package pe.unmsm.fisi.sislibrec.transformer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import pe.unmsm.fisi.sislibrec.dto.Reclamo;
import pe.unmsm.fisi.sislibrec.entities.MtcReclamo;

@ApplicationScoped
public class ReclamoTransformer {
	
	private DateTimeFormatter formatter;
	
	@Inject
	EstadoReclamoTransformer estadoReclamoT;
	
	public ReclamoTransformer(){
		formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	}
	
	public Reclamo getDTOFromEntity(MtcReclamo mtcReclamo){
		Reclamo reclamo = new Reclamo();
		if(mtcReclamo == null) return reclamo;
		
		reclamo.setIdReclamo(mtcReclamo.getIdReclamo());
		reclamo.setEstadoReclamo(estadoReclamoT.getDTOFromEntity(mtcReclamo.getMtcEstadoReclamo()));
		reclamo.setDate(mtcReclamo.getDate().format(this.formatter));
		reclamo.setTicket(mtcReclamo.getTicket());
		reclamo.setActivo(mtcReclamo.getActivo());
		
		return reclamo;
	}
	
	public List<Reclamo> getDTOFromEntity(List<MtcReclamo> mtcReclamos){
		List<Reclamo> reclamos = new ArrayList<>();
		for(MtcReclamo mtcReclamo : mtcReclamos) reclamos.add(this.getDTOFromEntity(mtcReclamo));
		return reclamos;
	}
	
	public MtcReclamo getEntityFromDTO(Reclamo reclamo){
		MtcReclamo mtcReclamo = new MtcReclamo();
		if(reclamo == null) return mtcReclamo;
		
		mtcReclamo.setIdReclamo(reclamo.getIdReclamo());
		mtcReclamo.setMtcEstadoReclamo(estadoReclamoT.getEntityFromDTO(reclamo.getEstadoReclamo()));
		mtcReclamo.setDescripcion(reclamo.getDescripcion());
		mtcReclamo.setDate(LocalDateTime.parse(reclamo.getDate(), this.formatter));
		mtcReclamo.setTicket(reclamo.getTicket());
		mtcReclamo.setActivo(reclamo.getActivo());
		
		return mtcReclamo;
	}
	
	public List<MtcReclamo> getEntityFromDTO(List<Reclamo> reclamos){
		List<MtcReclamo> mtcReclamos = new ArrayList<>();
		for(Reclamo reclamo : reclamos) mtcReclamos.add(this.getEntityFromDTO(reclamo));
		return mtcReclamos;
	}

}
