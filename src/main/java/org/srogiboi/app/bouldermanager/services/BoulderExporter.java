package org.srogiboi.app.bouldermanager.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.srogiboi.app.bouldermanager.boulders.Boulder;
import org.srogiboi.app.bouldermanager.boulders.BoulderManager;

/**
 * @author Wojtek Gil
 *
 */
@Path("boulderlist")
public class BoulderExporter extends BoulderManager {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 *
	 * @return JSON with a list of all boulders loaded form DB.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Boulder> getAllBoulder() {
		loadBoulders();
		return getBoulderList();
	}

	/**
	 * Method add a boulder which was send by a POST from web browser to DB
	 * 
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addBoulder(Boulder boulder) {
		addBoulderToDatabase(boulder);
	}

	
	/**
 	 * @return JSON with a  single instance of boulder loaded form DB.
	 */
	@GET
	@Path("/{boulderId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Boulder getSingleBoulder(@PathParam("boulderId") int testId) {
		loadBoulders();
		return getBoulderById(testId);
	}
}