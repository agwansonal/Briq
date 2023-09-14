package web;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HerokuappTest extends Herokuapp {

	@BeforeTest()
	void setUp() {
		initiateBrowser();
	}
	
	@Test
	void printWebTable() {
		readWebTable();
	}
	
	
	@AfterTest()
	void tearDown() {
		closeBrowser();
	}
	
}
