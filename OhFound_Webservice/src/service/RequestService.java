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

import bll.Request;
import dal.DatabaseManager;

@Path("/requests")
public class RequestService {
	
	public RequestService() {}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response GETrequests() {
		Response.ResponseBuilder response = Response.status(Response.Status.OK);
		System.out.println("GET api/requests requested");
		
		try {
			response.entity(new Gson().toJson(DatabaseManager.getInstance().GETrequests()));
			System.out.println("GET api/requests successful!");
		} catch(Exception ex) {
			response.status(Response.Status.BAD_REQUEST);
			response.entity("[ERROR] " + ex.getMessage());
		}
		
		return response.build();
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public Response POSTrequests(String strRequest) {
		Response.ResponseBuilder response = Response.status(Response.Status.OK);
		System.out.println("POST api/requests requested");
		
		try {
			Request requestFromService = new Gson().fromJson(strRequest, Request.class);
			DatabaseManager.getInstance().POSTrequests(requestFromService);
			response.entity("request created");
			System.out.println("POST api/requests successful!");
		} catch(Exception ex) {
			response.status(Response.Status.BAD_REQUEST);
			response.entity("[ERROR] " + ex.getMessage());
		}
		
		return response.build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response UPDATErequests(@PathParam("id") String id, String strRequest) {
		Response.ResponseBuilder response = Response.status(Response.Status.OK);
		System.out.println("PUT api/requests requested + " + strRequest);
		
		try {
			Request requestFromService = new Gson().fromJson(strRequest, Request.class);
			DatabaseManager.getInstance().UPDATErequests(requestFromService);
			response.entity("request updated");
			System.out.println("PUT api/requests successful!" + requestFromService.toString());
		} catch(Exception ex) {
			response.status(Response.Status.BAD_REQUEST);
			response.entity("[ERROR] " + ex.getMessage());
		}
		
		return response.build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response DELETErequests(@PathParam("id") String id) {
		Response.ResponseBuilder response = Response.status(Response.Status.OK);
		System.out.println("DELETE api/requests requested");
		
		try {
			DatabaseManager.getInstance().DELETErequests(id);
			response.entity("request deleted");
			System.out.println("DELETE api/requests successful!");
		} catch(Exception ex) {
			response.status(Response.Status.BAD_REQUEST);
			response.entity("[ERROR] " + ex.getMessage());
		}
		
		return response.build();
	}
}
