package pe.unmsm.fisi.sislibrec.boundary;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pe.unmsm.fisi.sislibrec.controller.ReclamoController;
import pe.unmsm.fisi.sislibrec.dto.Reclamo;
import pe.unmsm.fisi.sislibrec.dto.ResponseBody;

@Stateless
@Path("/reclamo")
public class ReclamoBoundary {
	
	@Inject
	ReclamoController reclamoc;
	
	@Path("/insert")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertReclamo(Reclamo reclamo){
		ResponseBody responseBody = new ResponseBody();
		try{
			reclamoc.insert(reclamo);
			responseBody.setStatus("OK");
			return Response.status(Response.Status.CREATED).entity(responseBody).build();
		}catch(Exception e){
			e.printStackTrace();
			responseBody.setStatus("FAIL");
			responseBody.setMsgServer(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(responseBody).build();
		}
	}
	
	@Path("/insertv2")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertReclamov2(Reclamo reclamo){
		ResponseBody responseBody = new ResponseBody();
		try{
			reclamoc.insertv2(reclamo);
			responseBody.setStatus("OKv2");
			return Response.status(Response.Status.CREATED).entity(responseBody).build();
		}catch(Exception e){
			e.printStackTrace();
			responseBody.setStatus("FAILv2");
			responseBody.setMsgServer(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(responseBody).build();
		}
	}
	
	@Path("/insertv3")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertReclamov3(Reclamo reclamo){
		ResponseBody responseBody = new ResponseBody();
		try{
			reclamoc.insertv3(reclamo);
			responseBody.setStatus("OKv3");
			return Response.status(Response.Status.CREATED).entity(responseBody).build();
		}catch(Exception e){
			e.printStackTrace();
			responseBody.setStatus("FAILv3");
			responseBody.setMsgServer(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(responseBody).build();
		}
	}

}
