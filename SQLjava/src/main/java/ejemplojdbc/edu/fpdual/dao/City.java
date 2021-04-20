package ejemplojdbc.edu.fpdual.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class City {

	int id;
	String name;
	Country country;
	String district;
	BigDecimal population;

	public City(ResultSet result) {
		try {
			this.id = result.getInt("ID");
			this.name = result.getString("name");
			this.district = result.getString("District");
			this.population = result.getBigDecimal("Population");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}