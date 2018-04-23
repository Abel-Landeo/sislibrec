package pe.unmsm.fisi.sislibrec.dto;

import java.io.Serializable;

public class ResponseBody implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String status;
	private String msgServer;
	
	public ResponseBody(){ }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsgServer() {
		return msgServer;
	}

	public void setMsgServer(String msgServer) {
		this.msgServer = msgServer;
	}
}
