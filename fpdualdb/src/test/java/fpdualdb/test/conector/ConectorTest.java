package fpdualdb.test.conector;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import fpdualdb.conector.Conector;
import fpdualdb.conector.MySQLConstants;
@RunWith(JUnitPlatform.class)
public class ConectorTest {
	
	private Conector conector;
	
	@BeforeEach
	public void init() {
		conector = new Conector();
	}
	
	@Test
	 void testGetConnection_ok() throws SQLException, ClassNotFoundException {
        Connection con = conector.getMySQLConnection();
        assertNotNull(con);
        assertTrue(con.isValid(0));
        con.close();
    }
	
	@Test
	 void testGetConnection_ko() throws SQLException {
		conector.getProp().put(MySQLConstants.URL_SCHEMA, ".");
		assertThrows(SQLException.class, () -> conector.getMySQLConnection());
   }
}
