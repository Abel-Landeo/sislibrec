package pe.unmsm.fisi.sislibrec.transformer;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import pe.unmsm.fisi.sislibrec.dto.EstadoReclamo;
import pe.unmsm.fisi.sislibrec.entities.MtcEstadoReclamo;

@ApplicationScoped
public class EstadoReclamoTransformer {
	
	public EstadoReclamo getDTOFromEntity(MtcEstadoReclamo mtcEstadoReclamo){
		EstadoReclamo estadoReclamo = new EstadoReclamo();
		if(mtcEstadoReclamo == null) return estadoReclamo;
		
		estadoReclamo.setIdEstadoReclamo(mtcEstadoReclamo.getIdEstadoReclamo());
		estadoReclamo.setDescripcion(mtcEstadoReclamo.getDescripcion());
		estadoReclamo.setActivo(mtcEstadoReclamo.getActivo());
		
		return estadoReclamo;
	}
	
	public List<EstadoReclamo> getDTOFromEntity(List<MtcEstadoReclamo> mtcEstadoReclamos){
		List<EstadoReclamo> estadoReclamos = new ArrayList<>();
		for(MtcEstadoReclamo mtcEstadoReclamo : mtcEstadoReclamos) estadoReclamos.add(this.getDTOFromEntity(mtcEstadoReclamo));
		return estadoReclamos;
	}
	
	public MtcEstadoReclamo getEntityFromDTO(EstadoReclamo estadoReclamo){
		MtcEstadoReclamo mtcEstadoReclamo = new MtcEstadoReclamo();
		if(estadoReclamo == null) return mtcEstadoReclamo;
		
		mtcEstadoReclamo.setIdEstadoReclamo(estadoReclamo.getIdEstadoReclamo());
		mtcEstadoReclamo.setDescripcion(estadoReclamo.getDescripcion());
		mtcEstadoReclamo.setActivo(estadoReclamo.getActivo());
		
		return mtcEstadoReclamo;
	}
	
	public List<MtcEstadoReclamo> getEntityFromDTO(List<EstadoReclamo> estadoReclamos){
		List<MtcEstadoReclamo> mtcEstadoReclamos = new ArrayList<>();
		for(EstadoReclamo estadoReclamo : estadoReclamos) mtcEstadoReclamos.add(this.getEntityFromDTO(estadoReclamo));
		return mtcEstadoReclamos;
	}
}
