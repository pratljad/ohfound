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

import bll.Ueberbegriff;
import dal.DatabaseManager;

@Path("UeberbegriffListe")
public class Ueberbegriff_Liste {

	@Context
	private UriInfo context;

	DatabaseManager db = DatabaseManager.getInstance();
	
	public Ueberbegriff_Liste() {
	}

	@GET
	@Path("/alleUeberbegriffe")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllUeberbegriffe() {
		Response.ResponseBuilder response = Response.status(Response.Status.OK);
		ArrayList<Ueberbegriff> allUeberbegriffe = null;
		try {
			allUeberbegriffe = db.getAllUeberbegriff();

			response.entity(new Gson().toJson(allUeberbegriffe));
		} catch (Exception ex) {
			response.status(Response.Status.BAD_REQUEST);
			response.entity("[ERROR] " + ex.getMessage());
		}
		System.out.println("======================webservice GET called");
		return response.build();
	}
}
