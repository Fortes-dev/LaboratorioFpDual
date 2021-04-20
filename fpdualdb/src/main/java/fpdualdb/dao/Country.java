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
public class Country {
	int id;
	String country;
	Date lastUpdate;

	public Country(ResultSet result) {
		try {
			this.id = result.getInt("country_id");
			this.country = result.getString("country");
			this.lastUpdate = result.getDate("last_update");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}

	
