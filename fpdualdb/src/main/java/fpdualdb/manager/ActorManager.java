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
import java.util.Scanner;

import fpdualdb.dao.Actor;

public class ActorManager {

	public List<Actor> findAll(Connection con) {
		try (Statement stmt = con.createStatement()) {
			ResultSet result = stmt.executeQuery("SELECT * FROM Actor");
			result.beforeFirst();

			List<Actor> countries = new ArrayList<>();

			while (result.next()) {
				countries.add(new Actor(result));
			}
			return countries;
		} catch (SQLException e) {

			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public List<Actor> findAllById(Connection con) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Escriba la Id del actor que desea buscar:");
		int actorId = sc.nextInt();
		sc.close();

		try (Statement stmt = con.createStatement()) {
			ResultSet result = stmt.executeQuery("SELECT * FROM Actor WHERE actor_id = " + actorId);
			result.beforeFirst();

			List<Actor> countries = new ArrayList<>();

			while (result.next()) {
				countries.add(new Actor(result));
			}
			return countries;
		} catch (SQLException e) {

			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public void createActor(Connection con, Date date) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Inserte [id] de su nuevo actor: ");
		int id = sc.nextInt();

		System.out.println("Inserte [first_name] de su nuevo actor: ");
		String firstName = sc.next();

		System.out.println("Inserte [last_name] de su nuevo actor: ");
		String lastName = sc.next();
		sc.close();
		try(PreparedStatement prepStmt = con.prepareStatement("INSERT INTO Actor VALUES ("+id+","+firstName+","+lastName+"?)")){
			con.setAutoCommit(false);
			prepStmt.setDate(1, date);
			
			prepStmt.executeUpdate();
			
			con.commit();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	public void modifyActor(Connection con, int id, String firstName, String lastName, Date date, int idWhere) {
		try(PreparedStatement prepStmt = con.prepareStatement("UPDATE Actor SET actor_id = ?, first_name = ?, last_name = ?, last_update ? WHERE actor_id ?")) {
			con.setAutoCommit(false);
			prepStmt.setInt(1, id);
			prepStmt.setString(2, firstName);
			prepStmt.setString(3, lastName);
			prepStmt.setDate(4, date);
			prepStmt.setInt(5, idWhere);
			
			prepStmt.executeUpdate();
			
			con.commit();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public void deleteActor(Connection con, int prefix) {
		try (PreparedStatement prepStmt = con.prepareStatement("DELETE FROM Actor WHERE actor_id = ?")) {
			con.setAutoCommit(false);
			prepStmt.setInt(1, prefix);
			prepStmt.executeUpdate();

			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
}
