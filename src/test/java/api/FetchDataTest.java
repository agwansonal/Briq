package api;

import java.io.IOException;

import org.testng.annotations.Test;

public class FetchDataTest extends FetchData{

	@Test()
	public void ConvertToCSV() throws IOException {
		getAPIData();
	}
	
	
	@Test
	public void getTime() {
		getCurrentTime();
	}
	
	@Test()
	public void PrintTable() throws IOException{
		getAPIData();
		PrintJSONasTable();
	}
	
	@Test
	public void findExperession() throws IOException {
		getAPIData();
		regExpression();
	}
	
}
