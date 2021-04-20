package fpdualdb.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class Actor {
	int id;
	String firstName;
	String lastName;
	Date lastUpdate;

	public Actor(ResultSet result) {
		try {
			this.id = result.getInt("actor_id");
			this.firstName = result.getString("first_name");
			this.lastName = result.getString("last_name");
			this.lastUpdate = result.getDate("last_update");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}