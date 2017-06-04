package org.srogiboi.app.bouldermanager.boulders;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utils.DbConnector;

public class BoulderManager {

	List<Boulder> boulderList = null;

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
		String query = "Select * From boulders order by id";

		try {
			stmt = DbConnector.connectionToDataBase().createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Boulder boulder = new Boulder();
				boulder.setId(rs.getInt("id"));
				boulder.setAuthorId(rs.getInt("author_id"));
				boulder.setGrade(rs.getString("grade"));
				boulder.setSectorId(rs.getInt("sector_id"));
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
			System.out.println(boulder.getId() + " " + boulder.getAuthorId() + " " + boulder.getGrade() + " "
					+ boulder.getSectorId() + " " + boulder.getDescription());
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
}
