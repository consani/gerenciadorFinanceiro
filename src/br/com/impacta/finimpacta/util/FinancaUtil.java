package br.com.impacta.finimpacta.util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class FinancaUtil {

	public static String get(String prop) {
		
		Properties propriedades = new Properties();
		String valorProp = null;
		
		try {
			propriedades.load(FinancaUtil.class.getResourceAsStream("/recursos/config.txt"));
			valorProp = propriedades.getProperty(prop);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return valorProp;
	}

	public static LocalDate parseDate(String dataAsString) {
		LocalDate data = LocalDate.parse(dataAsString,DateTimeFormatter.ofPattern(get("padraoDataMySql")));
		return data;
	}

}
