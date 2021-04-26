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
public class Language {
	int id;
	String name;
	Date lastUpdate;
	
	public Language(ResultSet result) {
		try {
			this.id = result.getInt("language_id");
			this.name = result.getString("name");
			this.lastUpdate = result.getDate("last_update");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
