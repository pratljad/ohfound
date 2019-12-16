package dal;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.JsonSyntaxException;

import bll.Gegenstand;

public class DatabaseManager {
	
	private static DatabaseManager dbManager = null;
	
	public static DatabaseManager newInstance() {
		if (dbManager == null)
			dbManager = new DatabaseManager();

		return dbManager;
	}
	
	private DatabaseManager() {
	}
	
	Client client = ClientBuilder.newClient();
	// TODO: auslagern in Config
	String resource = "http://localhost:8080/";
	WebTarget webTarget = client.target(resource);
	WebTarget webTargetUeberbegriffListe = webTarget.path("OhFoundWebService/Ohfound/UeberbegriffListe/");
	WebTarget webTargetGegenstandListe = webTarget.path("OhFoundWebService/Ohfound/GegenstandListe/");
	WebTarget webTargetUeberbegriffDetail = webTarget.path("OhFoundWebService/Ohfound/UeberbegriffDetail/");
	WebTarget webTargetGegenstandDetail = webTarget.path("OhFoundWebService/Ohfound/GegenstandDetail/");

	public ArrayList<Gegenstand> getGegenstaende() throws Exception {

		String retGegenstandAsJson = null;
		List<Gegenstand> gegenstaendeAsList = null;

		Invocation.Builder invocationBuilder = null;
		Response response = null;

		try {
			WebTarget webtarget = this.webTargetGegenstandListe.path("alleGegenstaende");
			invocationBuilder = webtarget.request(MediaType.APPLICATION_JSON);
			response = invocationBuilder.accept(MediaType.APPLICATION_JSON).get();
			gegenstaendeAsList = response.readEntity(new GenericType<List<Gegenstand>>() {
			});
			System.out.println(response.getStatus());

		} catch (JsonSyntaxException ex) {
			throw new Exception(retGegenstandAsJson);
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}

		return (ArrayList) gegenstaendeAsList;
	}
	
	public Gegenstand getGegenstand(int id) {

		WebTarget webtarget = this.webTargetGegenstandDetail.path(String.valueOf(id));
		Invocation.Builder invocationBuilder = webtarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.accept(MediaType.APPLICATION_JSON).get();
		Gegenstand gegenstand = response.readEntity(Gegenstand.class);
		System.out.println(response.getStatus());
		System.out.println(gegenstand);
		return gegenstand;
	}

	public boolean addGegenstand(Gegenstand gegenstand) {

		Invocation.Builder invocationBuilder = this.webTargetGegenstandDetail.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(gegenstand, MediaType.APPLICATION_JSON));

		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		if (response.getStatus() == 201) {
			return true;
		} else {
			return false;
		}
	}

	public boolean removeGegenstand(int id) {
		WebTarget webtarget = this.webTargetGegenstandDetail.path(String.valueOf(id));
		Invocation.Builder invocationBuilder = webtarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.delete();

		System.out.println(response.getStatus());
		if (response.getStatus() == 201) {
			return true;
		} else {
			return false;
		}
	}

	public boolean updateGegenstand(Gegenstand gegenstand) {
		WebTarget webtarget = this.webTargetGegenstandDetail.path(String.valueOf(gegenstand.getId()));

		Invocation.Builder invocationBuilder = webtarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.put(Entity.entity(gegenstand, MediaType.APPLICATION_JSON));

		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		if (response.getStatus() == 201) {
			return true;
		} else {
			return false;
		}
	}
	
	

}