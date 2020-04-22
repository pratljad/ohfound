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

import bll.Account;
import dal.DatabaseManager;

@Path("/accounts")
public class AccountService {
	
	public AccountService() {}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response GETaccounts() {
		Response.ResponseBuilder response = Response.status(Response.Status.OK);
		System.out.println("GET api/accounts requested");
		
		try {
			response.entity(new Gson().toJson(DatabaseManager.getInstance().GETaccounts()));
			System.out.println("GET api/accounts successful!");
		} catch(Exception ex) {
			response.status(Response.Status.BAD_REQUEST);
			response.entity("[ERROR] " + ex.getMessage());
		}
		
		return response.build();
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public Response POSTaccounts(String strAccount) {
		Response.ResponseBuilder response = Response.status(Response.Status.OK);
		System.out.println("POST api/accounts requested");
		
		try {
			Account accountFromService = new Gson().fromJson(strAccount, Account.class);
			DatabaseManager.getInstance().POSTaccounts(accountFromService);
			response.entity("account created");
			System.out.println("POST api/accounts successful!");
		} catch(Exception ex) {
			response.status(Response.Status.BAD_REQUEST);
			response.entity("[ERROR] " + ex.getMessage());
		}
		
		return response.build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response UPDATEaccounts(@PathParam("id") String id, String strAccount) {
		Response.ResponseBuilder response = Response.status(Response.Status.OK);
		System.out.println("PUT api/accounts requested");
		
		try {
			Account accountFromService = new Gson().fromJson(strAccount, Account.class);
			DatabaseManager.getInstance().UPDATEaccounts(accountFromService);
			response.entity("account updated");
			System.out.println("PUT api/accounts successful!");
		} catch(Exception ex) {
			response.status(Response.Status.BAD_REQUEST);
			response.entity("[ERROR] " + ex.getMessage());
		}
		
		return response.build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response DELETEaccounts(@PathParam("id") String id) {
		Response.ResponseBuilder response = Response.status(Response.Status.OK);
		System.out.println("DELETE api/accounts requested");
		
		try {
			DatabaseManager.getInstance().DELETEaccounts(id);
			response.entity("account deleted");
			System.out.println("DELETE api/accounts successful!");
		} catch(Exception ex) {
			response.status(Response.Status.BAD_REQUEST);
			response.entity("[ERROR] " + ex.getMessage());
		}
		
		return response.build();
	}
}
