package ejemplojdbc.edu.fpdual.manager;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import ejemplojdbc.edu.fpdual.dao.City;
import ejemplojdbc.edu.fpdual.dao.Country;

/**
 * City DTO Manager.
 * 
 * Contains all the queries used to consult and manipulate Cities data.
 * 
 * @author jose.m.prieto.villar
 *
 */
public class CityManager {

	/**
	 * Finds all the cities in the DB
	 * 
	 * @param con DB connection
	 * @return a {@link List} of {@link City}
	 */
	public List<City> findAll(Connection con) {
		// Create general statement
		try (Statement stmt = con.createStatement()) {
			// Queries the DB
			ResultSet result = stmt.executeQuery("SELECT * FROM City");
			// Set before first registry before going through it.
			result.beforeFirst();

			// Initializes variables
			List<City> cities = new ArrayList<>();
			Map<Integer, String> countries = new HashMap();

			// Run through each result
			while (result.next()) {
				// Initializes a city per result
				cities.add(new City(result));
				// Groups the countried by city
				countries.put(result.getInt("ID"), result.getString("CountryCode"));
			}

			// Fills the country of each city
			fillCountries(con, countries, cities);

			return cities;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<City> findAllById(Connection con) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Escriba la Id que desea buscar:");
		int numeroId = sc.nextInt();

		// Create general statement
		try (Statement stmt = con.createStatement()) {
			// Queries the DB
			ResultSet result = stmt.executeQuery("SELECT * FROM City WHERE Id = " + numeroId);
			// Set before first registry before going through it.
			result.beforeFirst();

			// Initializes variables
			List<City> cities = new ArrayList<>();
			Map<Integer, String> countries = new HashMap();

			// Run through each result
			while (result.next()) {
				// Initializes a city per result
				cities.add(new City(result));
				// Groups the countried by city
				countries.put(result.getInt("ID"), result.getString("CountryCode"));
			}

			// Fills the country of each city
			fillCountries(con, countries, cities);

			return cities;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<City> findAllByNameStartingWith(Connection con, String prefix) {
		try (PreparedStatement prepStmt = con.prepareStatement("SELECT * FROM City WHERE name LIKE ?")) {

			prepStmt.setString(1, prefix + "%");
			ResultSet result = prepStmt.executeQuery();

			// Set before first registry before going through it.
			result.beforeFirst();

			List<City> cities = new ArrayList<>();

			while (result.next()) {
				cities.add(new City(result));
			}
			return cities;

		} catch (SQLException e) {

			e.printStackTrace();
			return Collections.emptyList(); // Es mejor poner esto en el catch que retornar Null.
		}
	}

	public void modifyCityByName(Connection con, String prefix) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Inserte nuevo [Id] para el parámetro a modificar: ");
		int id = sc.nextInt();

		System.out.println("Inserte nuevo [Name] para el parámetro a modificar: ");
		String name = sc.next();

		System.out.println("Inserte nuevo [CountryCode] para el parámetro a modificar: ");
		String countryCode = sc.next();

		System.out.println("Inserte nuevo [District] para el parámetro a modificar: ");
		String district = sc.next();

		System.out.println("Inserte nuevo [Population] para el parámetro a modificar: ");
		BigDecimal population = sc.nextBigDecimal();

		try (PreparedStatement prepStmt = con
				.prepareStatement("UPDATE City SET Id =" + id + ", Name = '" + name + "', CountryCode = '" + countryCode
						+ "', District = '" + district + "', Population = " + population + " WHERE name LIKE ?")) {
			con.setAutoCommit(false);
			prepStmt.setString(1, prefix + "%");
			prepStmt.executeUpdate();

			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	public void createCity(Connection con) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Inserte [id] de su nueva ciudad: ");
		int id = sc.nextInt();

		System.out.println("Inserte [Name] de su nueva ciudad: ");
		String name = sc.next();

		System.out.println("Inserte [CountryCode] de su nueva ciudad: ");
		String countryCode = sc.next();

		System.out.println("Inserte [District] de su nueva ciudad: ");
		String district = sc.next();

		System.out.println("Inserte [Population] de su nueva ciudad: ");
		BigDecimal population = sc.nextBigDecimal();

		try (PreparedStatement prepStmt = con
				.prepareStatement("INSERT INTO City (Id, Name, CountryCode, District, Population) VALUES ('" + id + "','"
						+ name + "','" + countryCode + "','" + district + "','" + population + "')")) {
			con.setAutoCommit(false);
			prepStmt.executeUpdate();

			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}
	
	public void deleteCityByName(Connection con, String prefix) {

		try (PreparedStatement prepStmt = con
				.prepareStatement("DELETE FROM City WHERE name = ?")) {
			con.setAutoCommit(false);
			prepStmt.setString(1, prefix);
			prepStmt.executeUpdate();

			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	/**
	 * Fills all the countries for each city.
	 * 
	 * @param con       the Db connection
	 * @param countries the map of cities and countries.
	 * @param cities    the list of cities to update.
	 */
	private void fillCountries(Connection con, Map<Integer, String> countries, List<City> cities) {
		// Obtains all the country codes to search
		Set<String> countryCodes = new HashSet<>(countries.values());

		// Looks for all countries and groups them by id.
		Map<String, Country> countriesMap = new CountryManager().findAllById(con, countryCodes).stream()
				.collect(Collectors.toMap(Country::getId, data -> data));

		// Associates the corresponding Country to each City
		cities.forEach(city -> {
			String countryCode = countries.get(city.getId());
			Country foundCountry = countriesMap.get(countryCode);
			city.setCountry(foundCountry);
		});

	}

}