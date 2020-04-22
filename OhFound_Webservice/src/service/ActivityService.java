package service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import bll.Activity;
import dal.DatabaseManager;

@Path("/activities")
public class ActivityService {
	
	public ActivityService() {}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response GETactivities() {
		Response.ResponseBuilder response = Response.status(Response.Status.OK);
		System.out.println("GET api/activities requested");
		
		try {
			response.entity(new Gson().toJson(DatabaseManager.getInstance().GETactivities()));
			System.out.println("GET api/activities successful!");
		} catch(Exception ex) {
			response.status(Response.Status.BAD_REQUEST);
			response.entity("[ERROR] " + ex.getMessage());
		}
		
		return response.build();
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public Response POSTactivities(String strActivity) {
		Response.ResponseBuilder response = Response.status(Response.Status.OK);
		System.out.println("POST api/activities requested");
		
		try {
			Activity activityFromService = new Gson().fromJson(strActivity, Activity.class);
			DatabaseManager.getInstance().POSTactivities(activityFromService);
			response.entity("activity created");
			System.out.println("POST api/activities successful!");
		} catch(Exception ex) {
			response.status(Response.Status.BAD_REQUEST);
			response.entity("[ERROR] " + ex.getMessage());
		}
		
		return response.build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response UPDATEactivities(@PathParam("id") String id, String strActivity) {
		Response.ResponseBuilder response = Response.status(Response.Status.OK);
		System.out.println("PUT api/activities requested");
		
		try {
			Activity activityFromService = new Gson().fromJson(strActivity, Activity.class);
			DatabaseManager.getInstance().UPDATEactivities(activityFromService);
			response.entity("activity updated");
			System.out.println("PUT api/activities successful!");
		} catch(Exception ex) {
			response.status(Response.Status.BAD_REQUEST);
			response.entity("[ERROR] " + ex.getMessage());
		}
		
		return response.build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response DELETEactivities(@PathParam("id") String id) {
		Response.ResponseBuilder response = Response.status(Response.Status.OK);
		System.out.println("DELETE api/activities requested");
		
		try {
			DatabaseManager.getInstance().DELETEaccounts(id);
			response.entity("activity deleted");
			System.out.println("DELETE api/activities successful!");
		} catch(Exception ex) {
			response.status(Response.Status.BAD_REQUEST);
			response.entity("[ERROR] " + ex.getMessage());
		}
		
		return response.build();
	}
}
