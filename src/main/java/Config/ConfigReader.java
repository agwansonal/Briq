package Config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	
	private static Properties properties;
	private final static String propertyFilePath= System.getProperty("user.dir")+"\\src\\main\\java\\config\\Configuration.properties";

	
	public static void ConfigFileReader(){
		BufferedReader reader;
		try {
			 reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	
	public static String getBrowser() {
		ConfigFileReader();
		String browser = properties.getProperty("Browser");
		if(browser != null) return browser;
		else throw new RuntimeException("browser not specified in the Configuration.properties file.");
	}
	
	public static long getImplicitlyWait() {		
		ConfigFileReader();
		String implicitlyWait = properties.getProperty("Implicitewait");
		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
	}
	
	public static String getApplicationUrl() {
		ConfigFileReader();
		String url = properties.getProperty("URL");
		System.out.println(url);

		if(url != null) return url;
		
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	
	
	
}
