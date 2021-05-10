package fpdualdb.test.manager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assume.assumeNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import fpdualdb.conector.Conector;
import fpdualdb.dao.Actor;
import fpdualdb.manager.ActorManager;
@RunWith(JUnitPlatform.class)
public class ActorManagerTest {
	
	private Connection con;
	private int idMasAlto;
	private String name = "testeo";
	
	@BeforeEach
	public void setUp() throws SQLException, ClassNotFoundException {
		con = new Conector().getMySQLConnection();
		con.createStatement().execute("use sakila");
		ResultSet result = con.createStatement().executeQuery("SELECT max(actor_id) idMasAlto FROM Actor");
		result.beforeFirst();
		result.next();
		idMasAlto = result.getInt("idMasAlto");

		for (int i = 0; i < 5; i++) {
			try {
				Timestamp ts=new Timestamp(System.currentTimeMillis());
				Date time = new Date(ts.getTime());
				con.createStatement()
						.executeUpdate("INSERT INTO Actor (actor_id, first_name, last_name, last_update) VALUES ((select max(args.actor_id)+1 from actor args),'"+name+"', '"+name+"', "+time+")");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void findAll_ValidarLength_ok() {
		// Validate if connection is not null
		assumeNotNull(con);

		// Search for data
		List<Actor> actores = new ActorManager().findAll(con);

		// Validates city list size
		assertEquals(idMasAlto + 5, actores.size());
		assertThat(actores.size(), is(idMasAlto+5));
	}
	@Test
	public void findAll_ko() {
		assertThrows(NullPointerException.class, () -> new ActorManager().findAll(null));
	}
	
	
	@AfterEach
	public void tearDown() throws SQLException {
		con.createStatement().execute("use sakila");
		con.createStatement().executeUpdate("DELETE from Actor where actor_id >" + idMasAlto);
		con.close();
	}
	
}
