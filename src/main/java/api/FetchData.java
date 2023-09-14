package api;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.json.*;

public class FetchData {

	String jsonString;
	static JSONObject jsonObject;
	static String resp;

	public static void getAPIData() throws IOException {

		RestAssured.baseURI = "https://data.sfgov.org/resource/p4e4-a5a7.json";

		resp = given().header("Content-Type", "application/json").when().get().then().assertThat().statusCode(200)
				.extract().response().asString();

		// Fetching the JSON Array test
		// from the JSON Object
		JSONArray jsonArray = new JSONArray(resp);

		// Create a new CSV file using
		// the package java.io.File
		File file = new File(
				System.getProperty("user.dir") + "\\test-output\\CSV\\Data" + System.currentTimeMillis() + ".csv");

		// Produce a comma delimited text from
		// the JSONArray
		// and write the string to the newly created CSV
		// file

		String csvString = CDL.toString(jsonArray);
		FileUtils.writeStringToFile(file, csvString, "UTF-8");

	}

	public static void getCurrentTime() {

		SimpleDateFormat dateFormat = new SimpleDateFormat("MM.dd.yy.HH.mm.ss");
		String timestamp = dateFormat.format(new Date());
		System.out.println("Current Time in MM-DD-YY-HH-MI-SS format is: " + timestamp);

	}

	public static void PrintJSONasTable() {

		List<Map<String, Object>> allData = new ArrayList<Map<String, Object>>();
		Map<String, Object> jsonMap = null;
		JSONArray jsonArr = new JSONArray(resp);
		for (int i = 0; i < jsonArr.length(); i++) {
			JSONObject jsonobj = jsonArr.getJSONObject(i);
			jsonMap = jsonobj.toMap();
			allData.add(jsonMap);

			for (Map<String, Object> map : allData) {

				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Object value = entry.getValue();
					System.out.print("\t" + value);
					System.out.print("\t        ");

				}
				System.out.println();
			}

		}

	}

	public static void regExpression() {

		List<Map<String, Object>> allData = new ArrayList<Map<String, Object>>();
		Map<String, Object> jsonMap = null;
		JSONArray jsonArr = new JSONArray(resp);
		for (int i = 0; i < jsonArr.length(); i++) {
			JSONObject jsonobj = jsonArr.getJSONObject(i);
			jsonMap = jsonobj.toMap();
			allData.add(jsonMap);

			for (Map<String, Object> map : allData) {

				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Object value = entry.getValue();

					Pattern pattern = Pattern.compile("roof");
					Matcher matcher = pattern.matcher(value.toString());
					while (matcher.find()) {
						System.out.println("Line is: " + value);

					}

				}

			}

		}

	}

	

}
