package service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.google.gson.Gson;

import bll.Gegenstand;
import dal.DatabaseManager;

@Path("GegenstandListe")
public class Gegenstand_Liste {
	
	@Context
	private UriInfo context;

	DatabaseManager db = DatabaseManager.getInstance();
	
	public Gegenstand_Liste() {
	}
	
	@GET
	@Path("/alleGegenstaende")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllGegenstaendel() {
		Response.ResponseBuilder response = Response.status(Response.Status.OK);
		ArrayList<Gegenstand> allGegenstaende = null;
		try {
			allGegenstaende = db.getAllGegenstaende();

			response.entity(new Gson().toJson(allGegenstaende));
		} catch (Exception ex) {
			response.status(Response.Status.BAD_REQUEST);
			response.entity("[ERROR] " + ex.getMessage());
		}
		System.out.println("======================webservice GET called");
		return response.build();
	}

}
