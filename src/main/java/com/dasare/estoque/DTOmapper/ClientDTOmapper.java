package com.dasare.estoque.DTOmapper;

import com.dasare.estoque.model.Client;
import com.dasare.estoque.record.reponse.ClientRecordResponse;

public class ClientDTOmapper {
	
	public ClientDTOmapper() {
	}
	
	public ClientRecordResponse ClientResponse (Client client) {
		return new ClientRecordResponse(client.getClientID(),client.getName(),client.getManager().getManagerID());
	}

}
