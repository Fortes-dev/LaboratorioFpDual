package ejemplojdbc.edu.fpdual.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CountryLanguage {

	Country country;
	String language;
	boolean isOficial;
	Double percentage;
	
}