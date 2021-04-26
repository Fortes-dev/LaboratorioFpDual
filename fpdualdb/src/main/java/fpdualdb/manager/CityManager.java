package fpdualdb.manager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fpdualdb.dao.City;

public class CityManager {
	public List<City> findAll(Connection con) {
		try (Statement stmt = con.createStatement()) {
			ResultSet result = stmt.executeQuery("SELECT * FROM City");
			result.beforeFirst();

			List<City> cities = new ArrayList<>();

			while (result.next()) {
				cities.add(new City(result));
			}
			return cities;
		} catch (SQLException e) {

			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public List<City> findAllById(Connection con, int a) {

		try (PreparedStatement prepStmt = con.prepareStatement("SELECT * FROM City WHERE city_id IN (?)")) {

			prepStmt.setInt(1, a);

			ResultSet result = prepStmt.executeQuery();
			result.beforeFirst();

			List<City> cities = new ArrayList<>();

			while (result.next()) {
				cities.add(new City(result));
			}
			return cities;
		} catch (SQLException e) {

			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public void createCity(Connection con, int id, String name, int countryId, Date date) {
		try (PreparedStatement prepStmt = con.prepareStatement("UPDATE City VALUES (?, ?, ?, ?)")) {
			con.setAutoCommit(false);
			prepStmt.setInt(1, id);
			prepStmt.setString(2, name);
			prepStmt.setInt(3, countryId);
			prepStmt.setDate(4, date);

			prepStmt.executeUpdate();

			con.commit();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void modifyCity(Connection con, int id, String name, int countryId, Date date, int whereId) {
		try (PreparedStatement prepStmt = con
				.prepareStatement("UPDATE City SET city_id = ?, city = ?, country_id = ?, last_update ? where city_id = ?")) {
			con.setAutoCommit(false);
			prepStmt.setInt(1, id);
			prepStmt.setString(2, name);
			prepStmt.setInt(3, countryId);
			prepStmt.setDate(4, date);
			prepStmt.setInt(id, whereId);

			prepStmt.executeUpdate();

			con.commit();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void deleteCity(Connection con, int idWhere) {
		try (PreparedStatement prepStmt = con.prepareStatement("DELETE from Category WHERE city_id = ?")) {
			con.setAutoCommit(false);
			prepStmt.setInt(1, idWhere);

			prepStmt.executeUpdate();

			con.commit();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
