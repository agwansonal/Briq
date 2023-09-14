package web;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;


public class Herokuapp extends CommonMethods {
	
	
	
	public static void readWebTable() {
		
				// Let's get header first
				
				List<WebElement> allHeadersEle = d.findElements(By.xpath("//table//tr/th"));
				List<String> allHeaderNames = new ArrayList<String>();
				for (WebElement header : allHeadersEle) {
					String headerName = header.getText();
					allHeaderNames.add(headerName);
				}
				
				
				
				
				// Each row will be a key value pair. So we will use LinkedHashMap so that order
				// can be retained.
				// All map will be added to a list.
				List<Map<String,String>> allTableData = new ArrayList<Map<String,String>>();

				// Get total rows count
				List<WebElement> allRowsEle = d.findElements(By.xpath("//table/tbody/tr"));
				
				// Starting from first row.
				for (int i = 1; i <= allRowsEle.size(); i++) {
					// Getting specific row with each iteration
					String specificRowLoc = "//table/tbody/tr["+i+"]";
					// Locating only cells of specific row.
					List<WebElement> allColumnsEle = d.findElement(By.xpath(specificRowLoc))
							.findElements(By.tagName("td"));
					
					
					// Creating a map to store key-value pair data. It will be created for each
					// iteration of row
					LinkedHashMap<String,String> eachRowData = new LinkedHashMap<String,String> ();
					// Iterating each cell
					for (int j = 0; j < allColumnsEle.size()-1; j++) {
						// Getting cell value
						String cellValue = allColumnsEle.get(j).getText();
						// We will put in to map with header name and value with iteration
						// Get jth index value from allHeaderNames and jth cell value of row
						eachRowData.put(allHeaderNames.get(j), cellValue);
					}
					// After iterating row completely, add in to list.
					allTableData.add(eachRowData);
				
							

				}
					
				//System.out.println(allTableData);
				
				// Printing Headers of table
				for(int k=0;k<allHeaderNames.size()-1;k++) {
			        System.out.printf("\t" + allHeaderNames.get(k));
			        System.out.printf("\t");
				}
				System.out.println();
				
				//Printing rows of table
				for (Map<String, String> map : allTableData) {
					
					 for (Map.Entry<String, String> entry : map.entrySet()) {
				        Object value = entry.getValue();
				        System.out.printf("\t" + value);
				       
				    }
				    System.out.println();
				}
				
				
			   
				
}
				
	
}
