package service;

import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.tomcat.util.buf.UEncoder;

import com.google.gson.Gson;

import bll.Ueberbegriff;
import dal.DatabaseManager;

@Path("UeberbegriffDetail")
public class Ueberbegriff_Detail {

	@Context
	private UriInfo context;

	DatabaseManager db = DatabaseManager.getInstance();

	public Ueberbegriff_Detail() {
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("{ueberbegriffid}")
	public Response getUeberbegriff(@PathParam("ueberbegriffid") String id) {
		DatabaseManager db = DatabaseManager.getInstance();
		Response.ResponseBuilder response = Response.status(Response.Status.OK);
		try {
			Ueberbegriff ueberbegriff = db.getUeberbegriff(Integer.parseInt(id));
			response.entity(new Gson().toJson(ueberbegriff));
		} catch (Exception e) {
			response.status(Response.Status.BAD_REQUEST);
			response.entity("[ERROR] " + e.getMessage());
		}
		System.out.println("======================webservice GET called");
		return response.build();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response newUeberbegriff(String ueberbegriff) throws Exception {
		Response.ResponseBuilder response = Response.status(Response.Status.CREATED);
		DatabaseManager db = DatabaseManager.getInstance();
		System.out.println("======================NEW Ueberbegriff: " + ueberbegriff);

		try {
			Ueberbegriff newUeberbegriff = new Gson().fromJson(ueberbegriff, Ueberbegriff.class);
			db.addUeberbegriff(newUeberbegriff);
			response.entity("Ueberbegriff added");
		} catch (Exception e) {
			response.status(Response.Status.BAD_REQUEST);
			response.entity("[ERROR] " + e.getMessage());
		}

		return response.build();
	}

	@DELETE
	@Consumes({ MediaType.TEXT_HTML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
	@Path("{ueberbegriffid}")
	public Response deleteGegenstand(@PathParam("ueberbegriffid") String id) throws IOException {

		Response.ResponseBuilder response = Response.status(Response.Status.OK);
		DatabaseManager db = DatabaseManager.getInstance();

		try {
			db.deleteUeberbegriff(Integer.parseInt(id));
			response.entity("Ueberbegriff deleted");
		} catch (Exception e) {
			response.status(Response.Status.BAD_REQUEST);
			response.entity("[ERROR] " + e.getMessage());
		}

		return response.build();
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Path("{ueberbegriffid}")
	public Response updateArtikel(@PathParam("ueberbegriffid") String id, String stringUeberbbegriff)
			throws IOException {
		DatabaseManager db = DatabaseManager.getInstance();
		Response.ResponseBuilder response = Response.status(Response.Status.OK);

		try {
			Ueberbegriff ueberbegriff = new Gson().fromJson(stringUeberbbegriff, Ueberbegriff.class);
			ueberbegriff.setId(Integer.parseInt(id));
			db.updateUeberbegriff(ueberbegriff);
			response.entity("Ueberbegriff updated");
		} catch (Exception e) {
			response.status(Response.Status.BAD_REQUEST);
			response.entity("[ERROR] " + e.getMessage());
		}

		return response.build();
	}

}
