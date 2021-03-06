package fpdualdb.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

import fpdualdb.conector.Conector;
import fpdualdb.manager.ActorManager;
import fpdualdb.manager.CategoryManager;
import fpdualdb.manager.CityManager;
import fpdualdb.manager.CountryManager;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = new Conector().getMySQLConnection();
		try {
			Timestamp ts=new Timestamp(System.currentTimeMillis());
			Date time = new Date(ts.getTime());
			
			
			//Funciones ActorManager 
//Lista completa
			new ActorManager().findAll(con).forEach(actor -> System.out.println(actor));
//Lista por Id
			//new ActorManager().findAllById(con).forEach(actor -> System.out.println(actor));
//Crear actor
			//new ActorManager().createActor(con, 600,  "CARLOS", "PEREZ", time);
			
//Modificar actor
			//new ActorManager().modifyActor(con, 550, "PEPITO", "PEREZ", time, 600);
//Delete actor
			//new ActorManager().deleteActor(con, 3);

			/* Funciones CategoryManager 
//Lista completa
			new CategoryManager().findAll(con).forEach(category -> System.out.println(category));
//Lista por Id
			new CategoryManager().findAllById(con, 5).forEach(category -> System.out.println(category));
//Crear category
			new CategoryManager().createCategory(con, 821, "manga", time);
//Modificar category 
			new CategoryManager().modifyCategory(con, 4, "pokemon", time, 4);
//Delete category
			new CategoryManager().deleteCategory(con, 4);

			/* Funciones CityManager 
//Lista completa
			new CityManager().findAll(con).forEach(category -> System.out.println(category));
//Lista por Id
			new CityManager().findAllById(con, 5).forEach(city -> System.out.println(city));
//Crear city
			new CityManager().createCity(con, 821, "manga", 90, time);
//Modificar city 
			new CityManager().modifyCity(con, 4, "pokemon", 90, time, 4);
//Delete city
			new CityManager().deleteCity(con, 4);

			/* Funciones CountryManager 
//Lista completa
			new CountryManager().findAll(con).forEach(country -> System.out.println(country));
//Lista por Id
			new CountryManager().findAllById(con, 5).forEach(country -> System.out.println(country));
//Crear country
			new CountryManager().createCountry(con, 821, "Ejpa?ita", time);
//Modificar country
			new CountryManager().modifyCountry(con, 4, "France", time, 4);
//Delete country
			new CountryManager().deleteCountry(con, 4);

			/* Funciones LanguageManager */
//Lista completa
			//new LanguageManager().findAll(con).forEach(language -> System.out.println(language));
//Lista por Id
			//new LanguageManager().findAllById(con, 5).forEach(language -> System.out.println(language));
//Crear language
			//new LanguageManager().createLanguage(con, 821, "Ejpa?ol", time);
//Modificar language 
			//new LanguageManager().modifyLanguage(con, 4, "frenchoso", time, 4);
//Delete language
			//new LanguageManager().deleteLanguage(con, 4);

		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
