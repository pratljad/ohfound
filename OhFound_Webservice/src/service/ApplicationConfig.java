package service;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class ApplicationConfig extends ResourceConfig {
	public ApplicationConfig() {
		packages("bll", "dal", "services");
	}
}
