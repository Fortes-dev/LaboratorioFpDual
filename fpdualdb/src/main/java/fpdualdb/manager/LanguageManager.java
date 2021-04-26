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

import fpdualdb.dao.Language;

public class LanguageManager {
	public List<Language> findAll(Connection con) {
		try (Statement stmt = con.createStatement()) {
			ResultSet result = stmt.executeQuery("SELECT * FROM Language");
			result.beforeFirst();

			List<Language> languages = new ArrayList<>();

			while (result.next()) {
				languages.add(new Language(result));
			}
			return languages;
		} catch (SQLException e) {

			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public List<Language> findAllById(Connection con, int a) {

		try (PreparedStatement prepStmt = con.prepareStatement("SELECT * FROM Language WHERE language_id IN (?)")) {

			prepStmt.setInt(1, a);

			ResultSet result = prepStmt.executeQuery();
			result.beforeFirst();

			List<Language> languages = new ArrayList<>();

			while (result.next()) {
				languages.add(new Language(result));
			}
			return languages;
		} catch (SQLException e) {

			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public void createLanguage(Connection con, int id, String name, Date date) {
		try (PreparedStatement prepStmt = con.prepareStatement("UPDATE Language VALUES (?, ?, ?)")) {
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

	public void modifyLanguage(Connection con, int id, String name, Date date, int idWhere) {
		try (PreparedStatement prepStmt = con.prepareStatement(
				"UPDATE Language SET language_id = ?, name = ?, last_update = ?, WHERE language_id = ?")) {
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

	public void deleteLanguage(Connection con, int idWhere) {
		try (PreparedStatement prepStmt = con.prepareStatement("DELETE from Language WHERE language_id = ?")) {
			con.setAutoCommit(false);
			prepStmt.setInt(1, idWhere);

			prepStmt.executeUpdate();

			con.commit();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
