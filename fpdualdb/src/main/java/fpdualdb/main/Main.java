package fpdualdb.main;

import java.sql.Connection;
import java.sql.SQLException;

import fpdualdb.conector.Conector;
import fpdualdb.manager.ActorManager;
import fpdualdb.manager.CategoryManager;
import fpdualdb.manager.CityManager;
import fpdualdb.manager.CountryManager;
import fpdualdb.manager.LanguageManager;

public class Main {

	public static void main(String[] args) {
		Connection con = new Conector().getMySQLConnection();
		try {
		/*Funciones ActorManager*/
//Lista completa
		new ActorManager().findAll(con).forEach(actor -> System.out.println(actor));
//Lista por Id
		new ActorManager().findAllById(con).forEach(actor -> System.out.println(actor));
//Crear actor
		new ActorManager().createActor(con, null);
//Modificar actor
		new ActorManager().modifyActor(con, 3, "CARLOS", "PEREZ", null, 3);
//Delete actor
		new ActorManager().deleteActor(con, 3);
		
		/*Funciones CategoryManager*/
//Lista completa
		new CategoryManager().findAll(con).forEach(category -> System.out.println(category));
//Lista por Id
		new CategoryManager().findAllById(con, 5).forEach(category -> System.out.println(category));
//Crear category
		new CategoryManager().createCategory(con, 821, "manga", null);
//Modificar category 
		new CategoryManager().modifyCategory(con, 4, "pokemon", null, 4);
//Delete category
		new CategoryManager().deleteCategory(con, 4);
		
		/*Funciones CityManager*/
//Lista completa
		new CityManager().findAll(con).forEach(category -> System.out.println(category));
//Lista por Id
		new CityManager().findAllById(con, 5).forEach(city -> System.out.println(city));
//Crear city
		new CityManager().createCity(con, 821, "manga", 90, null);
//Modificar city 
		new CityManager().modifyCity(con, 4, "pokemon", 90, null);
//Delete city
		new CityManager().deleteCity(con, 4);
		
		/*Funciones CountryManager*/
//Lista completa
		new CountryManager().findAll(con).forEach(country -> System.out.println(country));
//Lista por Id
		new CountryManager().findAllById(con, 5).forEach(country -> System.out.println(country));
//Crear country
		new CountryManager().createCountry(con, 821, "Ejpañita", null);
//Modificar country
		new CountryManager().modifyCountry(con, 4, "France", null, 4);
//Delete country
		new CountryManager().deleteCountry(con, 4);
		
		/*Funciones LanguageManager*/
//Lista completa
		new LanguageManager().findAll(con).forEach(language -> System.out.println(language));
//Lista por Id
		new LanguageManager().findAllById(con, 5).forEach(language -> System.out.println(language));
//Crear language
		new LanguageManager().createLanguage(con, 821, "Ejpañol", null);
//Modificar language 
		new LanguageManager().modifyLanguage(con, 4, "frenchoso", null, 4);
//Delete language
		new LanguageManager().deleteLanguage(con, 4);
			
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
