package ejemplojbdc.edu.fpdual.main;

import java.sql.Connection;
import java.sql.SQLException;

import ejemplojdbc.edu.fpdual.conector.Conector;
import ejemplojdbc.edu.fpdual.dao.City;
import ejemplojdbc.edu.fpdual.manager.CityManager;
import ejemplojdbc.edu.fpdual.manager.CountryManager;

public class Main {

	public static void main(String[] args) {
		//Connects to the DB
		Connection con =  new Conector().getMySQLConnection();
		try {
			//Looks for all the cities in the DB and prints them.
/*Lista todas las ciudades*/
			//new CityManager().findAll(con).forEach(city ->System.out.println(city));		
/*Lista ciudades por Id dada en consola*/
			//new CityManager().findAllById(con).forEach(city ->System.out.println(city));
/*Lista ciudades por Nombre dada en consola*/
			//new CityManager().findAllByNameStartingWith(con, "Madridista").forEach(city -> System.out.println(city));
/*Modifica una ciudad buscada por su nombre*/
			//new CityManager().modifyCityByName(con, "");
/*Añadimos una nueva ciudad*/		
			//new CityManager().createCity(con);
/*Borra una ciudad por su nombre*/
			//new CityManager().deleteCityByName(con, "Frigiliana");		
			
			/*Funciones de Country*/
/*Lista todos los paises*/	
			//new CountryManager().findAll(con).forEach(country -> System.out.println(country));
/*Modifica un pais de manera diferente a la funcion en City*/
			new CountryManager().modifyCountryByName(con, "Israel");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
