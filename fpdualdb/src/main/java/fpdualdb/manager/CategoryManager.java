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

import fpdualdb.dao.Category;

public class CategoryManager {

	public List<Category> findAll(Connection con) {
		try (Statement stmt = con.createStatement()) {
			ResultSet result = stmt.executeQuery("SELECT * FROM Category");
			result.beforeFirst();

			List<Category> countries = new ArrayList<>();

			while (result.next()) {
				countries.add(new Category(result));
			}
			return countries;
		} catch (SQLException e) {

			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public List<Category> findAllById(Connection con, int a) {

		try (PreparedStatement prepStmt = con.prepareStatement("SELECT * FROM Category WHERE category_id IN (?)")) {

			prepStmt.setInt(1, a);

			ResultSet result = prepStmt.executeQuery();
			result.beforeFirst();

			List<Category> category = new ArrayList<>();

			while (result.next()) {
				category.add(new Category(result));
			}
			return category;
		} catch (SQLException e) {

			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public void createCategory(Connection con, int id, String name, Date date) {
		try (PreparedStatement prepStmt = con.prepareStatement("UPDATE Category VALUES (?, '?', ?)")) {
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

	public void modifyCategory(Connection con, int id, String name, Date date, int idWhere) {
		try (PreparedStatement prepStmt = con.prepareStatement(
				"UPDATE Category SET category_id = ?, name = '?', last_update = ?, WHERE category_id in (?)")) {
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

	public void deleteCategory(Connection con, int idWhere) {
		try (PreparedStatement prepStmt = con.prepareStatement("DELETE from Category WHERE category_id = ?")) {
			con.setAutoCommit(false);
			prepStmt.setInt(1, idWhere);

			prepStmt.executeUpdate();

			con.commit();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
