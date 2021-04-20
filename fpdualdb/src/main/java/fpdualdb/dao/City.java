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
public class City {
	int cityId;
	String name;
	int countryId;
	Date lastUpdate;

	public City(ResultSet result) {
		try {
			this.cityId = result.getInt("city_id");
			this.name = result.getString("city");
			this.countryId = result.getInt("country_id");
			this.lastUpdate = result.getDate("last_update");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}