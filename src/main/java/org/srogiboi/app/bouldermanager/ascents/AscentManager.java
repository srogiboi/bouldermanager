package org.srogiboi.app.bouldermanager.ascents;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.srogiboi.app.bouldermanager.boulders.Boulder;

import utils.DbConnector;

public class AscentManager {
	private List<Ascent> ascentsList;

	public List<Ascent> getAscents() {
		return ascentsList;
	}

	public void setAscents(List<Ascent> ascentsList) {
		this.ascentsList = ascentsList;
	}

	public void loadAscents() {
		this.ascentsList = new ArrayList<Ascent>();
		Statement stmt = null;
		String query = "Select * From ascents order by id";

		try {
			stmt = DbConnector.connectionToDataBase().createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Ascent ascent = new Ascent();
				ascent.setId(rs.getInt("id"));
				ascent.setUserId(rs.getInt("user_id"));
				ascent.setDateOfSent(rs.getTimestamp("date_of_sent"));
				ascent.setBoulderId(rs.getInt("boulder_id"));

				this.ascentsList.add(ascent);
			}
		} catch (SQLException e) {
			System.err.println("cannot load ascents");
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

		for (Ascent ascent : this.ascentsList) {
			System.out.println(ascent.getId() + " " + ascent.getUserId() + " " + ascent.getDateOfSent().toString() + " "
					+ ascent.getBoulderId() );
		}

	}
}
