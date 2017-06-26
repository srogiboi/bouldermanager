package org.srogiboi.app.bouldermanager.boulders;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.srogiboi.app.bouldermanager.authors.Author;
import org.srogiboi.app.bouldermanager.authors.AuthorsManager;

import utils.DbConnector;

public class BoulderManager {

	List<Boulder> boulderList = null;

	AuthorsManager authorManager = null;

	public List<Boulder> getBoulderList() {
		return boulderList;
	}

	public void setBoulderList(List<Boulder> boulderList) {
		this.boulderList = boulderList;
	}

	/**
	 * loading a list of boulders form DBSE
	 */

	public void loadBoulders() {

		this.boulderList = new ArrayList<Boulder>();
		Statement stmt = null;
		// String query = "Select * From boulders order by id";
		String query = "SELECT b.id, b.grade, b.sector_id, b.description, b.author_id, a.author_firstname, a.author_lastname, s.name_of_sector "
				+ "from boulders b inner join authors a on b.author_id = a.id join sectors s on b.sector_id = s.id";
		try {
			stmt = DbConnector.connectionToDataBase().createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Boulder boulder = new Boulder();
				boulder.setId(rs.getInt("id"));
				boulder.setGrade(rs.getString("grade"));
				boulder.setAuthorFirstName(rs.getString("author_firstname"));
				boulder.setAuthorLastName(rs.getString("author_lastname"));
				boulder.setSectorName(rs.getString("name_of_sector"));
				boulder.setDescription(rs.getString("description"));

				this.boulderList.add(boulder);
			}
		} catch (SQLException e) {
			System.err.println("cannot load boulders");
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		for (Boulder boulder : this.boulderList) {
			System.out.println(boulder.getId() + " " + boulder.getAuthorFirstName() + " " + boulder.getAuthorLastName()
					+ " " + boulder.getSectorId() + " " + boulder.getSectorName() + " " + boulder.getDescription());
		}

	}

	// be careful with ID numeration
	public Boulder getBoulderById(int id) {
		if (boulderList != null)
			return boulderList.get(id - 1);
		else {
			loadBoulders();
			return boulderList.get(id - 1);
		}
	}

	/**
	 * adding a single boulder instance to DB
	 */
	public void addBoulderToDatabase(Boulder boulder) {
		Statement stmt = null;
		String insertTableSQL = "INSERT INTO boulders (author_id, grade, sector_id, description) VALUES ('"
				+ boulder.getAuthorId() + "','" + boulder.getGrade() + " ', '" + boulder.getSectorId() + "','"
				+ boulder.getDescription() + "' );";

		try {
			stmt = DbConnector.connectionToDataBase().createStatement();

			System.out.println(insertTableSQL);

			// be careful with that it is not: eqecutequery!!!
			stmt.executeUpdate(insertTableSQL);
			System.out.println("Record is inserted into DBUSER table!");

		} catch (SQLException e) {
			System.err.println("cannot load boulders");
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void searchboulders(String author, String grade, String sector) {

		this.boulderList = new ArrayList<Boulder>();
		Statement stmt = null;
		// String query = "Select * From boulders order by id";

		String query = "SELECT b.id, b.grade, b.sector_id, b.description, b.author_id, a.author_firstname, a.author_lastname, s.name_of_sector "
				+ "from boulders b inner join authors a on b.author_id = a.id join sectors s on b.sector_id = s.id ";

		if (!(author.equals("") && grade.equals("") && sector.equals(""))) {
			query += "WHERE ";

			if (!(author.equals(""))) {
				query += "a.author_lastname = '" + author + "'";
				if ((!(grade.equals(""))) || (!(sector.equals(""))))
					query += " AND ";
			}

			if (!(grade.equals(""))) {
				System.out.println("grade VALUE:" + grade);
				query += "b.grade = '" + grade + "'";
				if ((!(sector.equals(""))))
					query += " AND ";
			}

			if(!(sector.equals("")))
				query += "s.name_of_sector = '" + sector + "'";
		}

		System.out.println(query);
		System.out.println("SECTOR VALUE:" + sector);
		try {
			stmt = DbConnector.connectionToDataBase().createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Boulder boulder = new Boulder();
				boulder.setId(rs.getInt("id"));
				boulder.setGrade(rs.getString("grade"));
				boulder.setAuthorFirstName(rs.getString("author_firstname"));
				boulder.setAuthorLastName(rs.getString("author_lastname"));
				boulder.setSectorName(rs.getString("name_of_sector"));
				boulder.setDescription(rs.getString("description"));

				this.boulderList.add(boulder);
			}
		} catch (SQLException e) {
			System.err.println("cannot load boulders");
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		for (Boulder boulder : this.boulderList) {
			System.out.println(boulder.getId() + " " + boulder.getAuthorFirstName() + " " + boulder.getAuthorLastName()
					+ " " + boulder.getSectorId() + " " + boulder.getSectorName() + " " + boulder.getDescription());
		}

	}

}
