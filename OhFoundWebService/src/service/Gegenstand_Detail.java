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

import com.google.gson.Gson;

import bll.Gegenstand;
import dal.DatabaseManager;

@Path("GegenstandDetail")
public class Gegenstand_Detail {
	
	@Context
	private UriInfo context;

	DatabaseManager db = DatabaseManager.getInstance();
	
	public Gegenstand_Detail() {
	}
	
	 @GET
	 @Produces({MediaType.APPLICATION_JSON})
	 @Path("/filter/{filterValue}")
	 public Response filterGegenstaende(@PathParam("filterValue") String filterValue) throws Exception {

	        Response.ResponseBuilder response = Response.status(Response.Status.OK);
			ArrayList<Gegenstand> allGegenstaende = null;
			try {
				allGegenstaende = (ArrayList<Gegenstand>) db.filterGegenstaende(filterValue);

				response.entity(new Gson().toJson(allGegenstaende));
			} catch (Exception ex) {
				response.status(Response.Status.BAD_REQUEST);
				response.entity("[ERROR] " + ex.getMessage());
			}
			System.out.println("======================webservice GET called");
			return response.build();
	    }
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("{gegenstandid}")
	public Response getGegenstand(@PathParam("gegenstandid") String id) {
		DatabaseManager db = DatabaseManager.getInstance();
		Response.ResponseBuilder response = Response.status(Response.Status.OK);
		try {
			Gegenstand gegenstand = db.getGegensatnd(Integer.parseInt(id));
			response.entity(new Gson().toJson(gegenstand));
		} catch (Exception e) {
			response.status(Response.Status.BAD_REQUEST);
			response.entity("[ERROR] " + e.getMessage());
		}
		System.out.println("====================== webservice GET called");
		return response.build();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response newGegenstand(String gegenstand) throws Exception {
		Response.ResponseBuilder response = Response.status(Response.Status.CREATED);
		DatabaseManager db = DatabaseManager.getInstance();
		System.out.println("====================== NEW Gegenstand: " + gegenstand);

		try {
			Gegenstand newGegenstand = new Gson().fromJson(gegenstand, Gegenstand.class);
			db.addGegenstand(newGegenstand);
			response.entity("Gegenstand added");
		} catch (Exception e) {
			response.status(Response.Status.BAD_REQUEST);
			response.entity("[ERROR] " + e.getMessage());
					}

		return response.build();
	}
	
	@DELETE
    @Consumes({MediaType.TEXT_HTML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
	@Path("{gegenstandid}")
    public Response deleteGegenstand(@PathParam("gegenstandid") String id) throws IOException {

        Response.ResponseBuilder response = Response.status(Response.Status.OK);
        DatabaseManager db = DatabaseManager.getInstance();

        try {
            db.deleteGegenstand(Integer.parseInt(id));
            response.entity("Gegenstand deleted");
        } catch (Exception e) {
            response.status(Response.Status.BAD_REQUEST);
            response.entity("[ERROR] " + e.getMessage());
        }

        return response.build();
    }
	
	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
	@Path("{gegenstandid}")
    public Response updateArtikel(@PathParam("gegenstandid") String id,String stringGegenstand) throws IOException {
        DatabaseManager db = DatabaseManager.getInstance();
        Response.ResponseBuilder response = Response.status(Response.Status.OK);

        try {
            Gegenstand gegenstand = new Gson().fromJson(stringGegenstand, Gegenstand.class);
            gegenstand.setId(Integer.parseInt(id));
            db.updateGegenstand(gegenstand);
            response.entity("Gegenstand updated");
        } catch (Exception e) {
            response.status(Response.Status.BAD_REQUEST);
            response.entity("[ERROR] " + e.getMessage());
        }

        return response.build();
    }

}
