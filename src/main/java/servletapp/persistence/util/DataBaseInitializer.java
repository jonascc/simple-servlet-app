package servletapp.persistence.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class DataBaseInitializer {

	public String sqlScriptToString(String file) {

		ClassLoader classLoader = this.getClass().getClassLoader();
		// Getting resource(File) from class loader
		File configFile = new File(classLoader.getResource("scripts/" + file).getFile());

		String str = null;
		try (InputStream inputStream = new FileInputStream(configFile)) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			str = reader.lines().collect(Collectors.joining());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return str;
	}

}
