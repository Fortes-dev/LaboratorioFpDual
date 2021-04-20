package ejemplojdbc.edu.fpdual.manager;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import ejemplojdbc.edu.fpdual.dao.Country;

/**
 * Country DTO Manager.
 * 
 * Contains all the queries used to consult and manipulate Countries data.
 * 
 * @author jose.m.prieto.villar
 *
 */
public class CountryManager {

	/**
	 * Finds all the cities in the DB based on a list of ids.
	 * 
	 * @param con DB connection
	 * @param ids Countries id set to search for.
	 * @return a {@link List} of {@link Country}
	 */

	// Select de todos los campos de la tabla country
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

	public List<Country> findAllById(Connection con, Set<String> ids) {
		// Creates the SQL command
		String sql = String.format("SELECT * FROM Country WHERE Code in (%s)",
				ids.stream().map(data -> "\"" + data + "\"").collect(Collectors.joining(", ")));

		// Create a prepared statement
		try (Statement stmt = con.createStatement()) {

			// Executes sql command
			ResultSet result = stmt.executeQuery(sql);
			// Set before first registry before going through it.
			result.beforeFirst();

			// Initializes variables
			List<Country> countries = new ArrayList<>();

			// Run through each result
			while (result.next()) {
				// Initializes a country per result
				countries.add(new Country(result));
			}

			return countries;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Country> findAllByNameStartingWith(Connection con, String prefix) {
		try (PreparedStatement prepStmt = con.prepareStatement("SELECT * FROM Country WHERE name LIKE ?")) {

			prepStmt.setString(1, prefix + "%");
			ResultSet result = prepStmt.executeQuery();

			// Set before first registry before going through it.
			result.beforeFirst();

			List<Country> countries = new ArrayList<>();

			while (result.next()) {
				countries.add(new Country(result));
			}
			return countries;

		} catch (SQLException e) {

			e.printStackTrace();
			return Collections.emptyList(); // Es mejor poner esto en el catch que retornar Null.
		}
	}

	public List<Country> findAllByNameContaining(Connection con, String prefix) {
		try (PreparedStatement prepStmt = con.prepareStatement("SELECT * FROM Country WHERE name LIKE ?")) {

			prepStmt.setString(1, "%" + prefix + "%");
			ResultSet result = prepStmt.executeQuery();

			// Set before first registry before going through it.
			result.beforeFirst();

			List<Country> countries = new ArrayList<>();

			while (result.next()) {
				countries.add(new Country(result));
			}
			return countries;

		} catch (SQLException e) {

			e.printStackTrace();
			return Collections.emptyList(); // Es mejor poner esto en el catch que retornar Null.
		}
	}

	public List<Country> findAllByNameEndingWith(Connection con, String prefix) {
		try (PreparedStatement prepStmt = con.prepareStatement("SELECT * FROM Country WHERE name LIKE ?")) {

			prepStmt.setString(1, "%" + prefix);
			ResultSet result = prepStmt.executeQuery();

			// Set before first registry before going through it.
			result.beforeFirst();

			List<Country> countries = new ArrayList<>();

			while (result.next()) {
				countries.add(new Country(result));
			}
			return countries;

		} catch (SQLException e) {

			e.printStackTrace();
			return Collections.emptyList(); // Es mejor poner esto en el catch que retornar Null.
		}
	}

	public void modifyCountryByName(Connection con, String prefix) {

		try (PreparedStatement prepStmt = con
				.prepareStatement("UPDATE Country SET Code = ?, Name = ?, Continent = ?, Region = ?, SurfaceArea = ?, IndepYear = ?, "
					+ "Population = ?, LifeExpectancy = ?, GNP = ?, GNPOld = ?, LocalName = ?, GovernmentForm = ?, HeadOfState = ?, Capital = ? WHERE Name LIKE ?"
						)) {
			con.setAutoCommit(false);
			
			
			prepStmt.setString(1, "PPP");
			prepStmt.setString(2, "Españistan");
			prepStmt.setString(3, "Europe");
			prepStmt.setString(4, "Andalucia");
			prepStmt.setBigDecimal(5, new BigDecimal(289377.00));
			prepStmt.setInt(6, 1893);
			prepStmt.setFloat(7, 12328917);
			prepStmt.setDouble(8, 78.0);
			prepStmt.setDouble(9, 19238.0);
			prepStmt.setDouble(10, 3333.0);
			prepStmt.setString(11, "nose");
			prepStmt.setString(12, "aa");
			prepStmt.setString(13, "arroz");
			prepStmt.setInt(14, 147);
			prepStmt.setString(15, "%"+prefix+"%");
			prepStmt.executeUpdate();

			con.commit();

		}catch(

	SQLException e)
	{
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
				.prepareStatement("INSERT INTO City (Id, Name, CountryCode, District, Population) VALUES ('" + id
						+ "','" + name + "','" + countryCode + "','" + district + "','" + population + "')")) {
			con.setAutoCommit(false);
			prepStmt.executeUpdate();

			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	public void deleteCityByName(Connection con, String prefix) {

		try (PreparedStatement prepStmt = con.prepareStatement("DELETE FROM City WHERE name = ?")) {
			con.setAutoCommit(false);
			prepStmt.setString(1, prefix);
			prepStmt.executeUpdate();

			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}
}