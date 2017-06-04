package org.srogiboi.app.bouldermanager.authors;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utils.DbConnector;

public class AuthorsManager {

	private List<Author> authors;

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public void loadAuthorsFromDb() {
		this.authors = new ArrayList<Author>();
		Statement stmt = null;
		String query = "Select * From authors order by id";
		
		try {
			stmt = DbConnector.connectionToDataBase().createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Author author = new Author();
				author.setId(rs.getInt("id"));
				author.setFirstName(rs.getString("author_firstname"));
				author.setLastName(rs.getString("author_lastname"));
				author.setBoulderCount(rs.getInt("boulder_count"));

				this.authors.add(author);
			}
		} catch (SQLException e) {
			System.err.println("cannot load authors");
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

		for (Author author : this.authors) {
			System.out.println(author.getId() + " " + author.getFirstName() + " " + author.getLastName() + " "
					+ author.getBoulderCount());
		}

	}

}
