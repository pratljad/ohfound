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

import bll.Item;
import dal.DatabaseManager;

@Path("/items")
public class ItemService {
	
	public ItemService() {}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response GETitems() {
		Response.ResponseBuilder response = Response.status(Response.Status.OK);
		System.out.println("GET api/items requested");
		
		try {
			response.entity(new Gson().toJson(DatabaseManager.getInstance().GETitems()));
			System.out.println("GET api/items successful!");
		} catch(Exception ex) {
			response.status(Response.Status.BAD_REQUEST);
			response.entity("[ERROR] " + ex.getMessage());
		}
		
		return response.build();
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public Response POSTitems(String strItem) {
		Response.ResponseBuilder response = Response.status(Response.Status.OK);
		System.out.println("POST api/items requested");
		
		try {
			Item itemFromService = new Gson().fromJson(strItem, Item.class);
			DatabaseManager.getInstance().POSTitems(itemFromService);
			response.entity("item created");
			System.out.println("POST api/items successful!");
		} catch(Exception ex) {
			response.status(Response.Status.BAD_REQUEST);
			response.entity("[ERROR] " + ex.getMessage());
		}
		
		return response.build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response UPDATEitems(@PathParam("id") String id, String strItem) {
		Response.ResponseBuilder response = Response.status(Response.Status.OK);
		System.out.println("PUT api/items requested");
		
		try {
			Item itemFromService = new Gson().fromJson(strItem, Item.class);
			DatabaseManager.getInstance().UPDATEitems(itemFromService);
			response.entity("item updated");
			System.out.println("PUT api/items successful!");
		} catch(Exception ex) {
			response.status(Response.Status.BAD_REQUEST);
			response.entity("[ERROR] " + ex.getMessage());
		}
		
		return response.build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response DELETEitems(@PathParam("id") String id) {
		Response.ResponseBuilder response = Response.status(Response.Status.OK);
		System.out.println("DELETE api/items requested");
		
		try {
			DatabaseManager.getInstance().DELETEitems(id);
			response.entity("item deleted");
			System.out.println("DELETE api/items successful!");
		} catch(Exception ex) {
			response.status(Response.Status.BAD_REQUEST);
			response.entity("[ERROR] " + ex.getMessage());
		}
		
		return response.build();
	}
}
