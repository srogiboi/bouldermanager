package utils;

import org.srogiboi.app.bouldermanager.ascents.AscentManager;
import org.srogiboi.app.bouldermanager.authors.AuthorsManager;
import org.srogiboi.app.bouldermanager.boulders.BoulderManager;



public class FirstClass {

	// FOR CONNECIOTN TESTS

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
//		AuthorsManager authors = new AuthorsManager();
//		authors.loadAuthorsFromDb(); 
		
		System.out.println("BOULDERS: ");
		BoulderManager boulders = new BoulderManager();
		//boulders.loadBoulders();
		boulders.searchboulders("Pustelka", "red", "");
//		AscentManager ascents = new AscentManager();
//		ascents.loadAscents();
		
		//to do sectors
		//to do users
		
	}
}
