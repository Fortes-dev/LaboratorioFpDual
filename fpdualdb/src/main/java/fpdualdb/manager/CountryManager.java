package fpdualdb.manager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fpdualdb.dao.Country;

public class CountryManager {

		public List<Country> findAll(Connection con) {
			try (Statement stmt = con.createStatement()) {
				ResultSet result = stmt.executeQuery("SELECT * FROM Country");
				result.beforeFirst();

				List<Country> countries = new ArrayList<>();

				while (result.next()) {
					countries.add(new Country(result));
				}
				return countries;
			} catch (SQLException e) {

				e.printStackTrace();
				return Collections.emptyList();
			}
		}
		
		public List<Country> findAllById(Connection con, int a) {


			try (PreparedStatement prepStmt = con.prepareStatement("SELECT * FROM Country WHERE country_id IN (?)")) {
				
				prepStmt.setInt(1, a);
				
				ResultSet result = prepStmt.executeQuery();
				result.beforeFirst();
				
				List<Country> countries = new ArrayList<>();

				while (result.next()) {
					countries.add(new Country(result));
				}
				return countries;
			} catch (SQLException e) {

				e.printStackTrace();
				return Collections.emptyList();
			}
		}
		
		public void createCountry(Connection con, int id, String name,  Date date) {
			try(PreparedStatement prepStmt = con.prepareStatement("UPDATE Country VALUES (?, ?, ?)")) {
				con.setAutoCommit(false);
				prepStmt.setInt(1, id);
				prepStmt.setString(2, name);
				prepStmt.setDate(3, date);
		
				
				prepStmt.executeUpdate();
				
				con.commit();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		public void modifyCountry(Connection con, int id, String name,  Date date, int idWhere) {
			try(PreparedStatement prepStmt = con.prepareStatement("UPDATE Country SET country_id = ?, country = ?, last_update = ?, WHERE country_id = ?")) {
				con.setAutoCommit(false);
				prepStmt.setInt(1, id);
				prepStmt.setString(2, name);
				prepStmt.setDate(3, date);
				prepStmt.setInt(4, idWhere);
				
				prepStmt.executeUpdate();
				
				con.commit();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		public void deleteCountry(Connection con, int idWhere) {
			try(PreparedStatement prepStmt = con.prepareStatement("DELETE from Country WHERE country_id ?")) {
				con.setAutoCommit(false);
				prepStmt.setInt(1, idWhere);
				
				prepStmt.executeUpdate();
				
				con.commit();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
}
