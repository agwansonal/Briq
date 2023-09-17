package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Config.ConfigReader;

public class CommonMethods extends ConfigReader {

	
	public static WebDriver d;
	
	public static void initiateBrowser() {
		if(getBrowser().equalsIgnoreCase("Chrome")) {
			d=new ChromeDriver();}
		else if(getBrowser().equalsIgnoreCase("Edge")) {
			String edgeBrowserpath=System.getProperty("user.dir")+"\\\\src\\\\main\\\\java\\\\config\\Drivers\\msedgedriver.exe";
			System.setProperty("webdriver.edge.driver", edgeBrowserpath);
			d=new EdgeDriver();
		}
		d.get(getApplicationUrl());
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(getImplicitlyWait()));
		d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		d.manage().window().maximize();
		
		
	}
	
	public static void closeBrowser() {
		d.quit();
	}
	
}
