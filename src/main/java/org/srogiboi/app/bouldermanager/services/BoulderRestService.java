package org.srogiboi.app.bouldermanager.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.srogiboi.app.bouldermanager.boulders.Boulder;
import org.srogiboi.app.bouldermanager.boulders.BoulderManager;

/**
 * @author Wojtek Gil
 *
 */
@Path("boulderlist")
public class BoulderRestService {

	private BoulderManager bouldermanager;

	public BoulderRestService() {
		this.bouldermanager = new BoulderManager();
	}

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 *
	 * @return JSON with a list of all boulders loaded form DB.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Boulder> getAllBoulder() {
		this.bouldermanager.loadBoulders();
		return this.bouldermanager.getBoulderList();
	}

	/**
	 * Method add a boulder which was send by a POST from web browser to DB
	 * 
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addBoulder(Boulder boulder) {
		this.bouldermanager.addBoulderToDatabase(boulder);
	}

	/**
	 * @return JSON with a single instance of boulder loaded form DB.
	 */
	@GET
	@Path("/{boulderId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Boulder getSingleBoulder(@PathParam("boulderId") int testId) {
		this.bouldermanager.loadBoulders();
		return this.bouldermanager.getBoulderById(testId);
	}
	
	/**
	 * @return JSON with a single instance of boulder loaded form DB.
	 */
	@GET
	@Path("/query")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Boulder> getSearchBoulders(@QueryParam("author") String author,
			@QueryParam("grade") String grade,
			@QueryParam("sector") String sector) {
		
		this.bouldermanager.searchboulders(author,grade,sector);
		return this.bouldermanager.getBoulderList();
	}																	
}