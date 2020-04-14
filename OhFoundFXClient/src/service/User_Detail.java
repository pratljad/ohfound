package service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.google.gson.Gson;

import bll.Gegenstand;
import bll.User;
import dal.DatabaseManager;

@Path("UserDetail")
public class User_Detail {
	
	@Context
	private UriInfo context;

	DatabaseManager db = DatabaseManager.getInstance();
	
	public User_Detail() {
	}
	
  
	 @POST
	    @Path("/register")
	    @Consumes({MediaType.APPLICATION_JSON})
	    public Response registerUser(String newUser) throws Exception {
	        Response r = Response.status(Response.Status.CREATED).entity("user registered").build();
	        try {
	            db.registerUser(new Gson().fromJson(newUser, User.class));
	        } catch (Exception ex) {
	            r = Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
	        }
	        return r;
	    }

	    @POST
	    @Path("/login")
	    @Consumes({MediaType.APPLICATION_JSON})
	    public Response loginUser(String newUser) throws Exception {
	        Response r = null;
	        try {
	            User u = new Gson().fromJson(newUser, User.class);
	            u = db.loginUser(u);
	            if (u == null) {
	                throw new Exception("no user found");
	            }
	            r = Response.ok().entity(new Gson().toJson(u)).build();
	        } catch (Exception ex) {
	            r = Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
	        }
	        return r;
	    }

}
