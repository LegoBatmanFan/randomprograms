/************************************************************************************
 * LegoBatmanFan									9 January 2018
 * 
 * SimpleWeatherTest.java
 * API testing with RestAssured using the wunderground API
 * http://api.wunderground.com
 * 1. getWeather: GET request for weather information about Winston-Salem, NC
 * 2. getWeatherUsingCoordinates: GET request for weather info about NYC using GPs coordinates
 * 3. getWeatherIcon: GET request for obtaining the weather icon for San Francisco, CA. Obtains other information too.
 * 4. getAllHeaders: get the values of every header.
 * 5. getAlert: GET request for obtaining a weather alert for Winston-Salem, NC.
 * 6. getResponseCodeForWeatherConditions: GET request for weather data (San Francisco, CA) and get the status code from the response.
 * 7. getResponseCodeForAlert: GET request for weather alert data (Winston-Salem, NC, CA) and get the status code from the response.
 * 
 * Add the following dependencies in the pom.xml file:
 * 	<!-- https://mvnrepository.com/artifact/org.hamcrest/hamcrest-all -->
		<dependency>
			<groupId>org.hamcrest</groupId>
			<artifactId>hamcrest-all</artifactId>
			<version>1.1</version>
			<scope>test</scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.codehaus.groovy/groovy-all -->
		<dependency>
			<groupId>org.codehaus.groovy</groupId>
			<artifactId>groovy-all</artifactId>
			<version>2.4.5</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.jayway.restassured/rest-assured -->
		<dependency>
			<groupId>com.jayway.restassured</groupId>
			<artifactId>rest-assured</artifactId>
			<version>2.9.0</version>
			<scope>test</scope>
		</dependency>
 * -----------------------------------------------------------------------------
 * Modification History
 * Date					Author				Description
 * ----------------------------------------------------------------------------
 * 9 January 2018		LegoBatmanFan		Created
 ************************************************************************************/

package ScratchTest;

import java.io.File;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;




public class SimpleWeatherTest {

	private static final String NULL = null;
	private static String API_KEY = null;

	@BeforeTest
	public void setBaseUri() throws IOException{
		RestAssured.baseURI = "http://api.wunderground.com";
		
		List<String> lines = FileUtils.readLines(new File("//Users//lenahorsley//Documents//Lena//TestingNotes//WeatherUndergroundAPI.txt"), "utf-8");
		API_KEY = lines.get(0);
	}
	
	@Test
	public void getWeather(){
		String state = "NC";
		String city = "Winston-Salem";
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("TEST getWeather");
		RequestSpecification httpRequest = RestAssured.given();
		Response getCityInformationResponse = httpRequest.request(Method.GET, "/api/"+ API_KEY +"/conditions/q/"+ state +"/" + city + ".json");
		String getCityInformationResponseBody = getCityInformationResponse.getBody().asString();
		System.out.println("Response Body is ==> " + getCityInformationResponseBody);
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
	@Test
	public void getWeatherUsingCoordinates(){
		String myCoordinates = "40.705086,-74.018715";
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("TEST getWeatherUsingCoordinates");
		RequestSpecification httpRequest = RestAssured.given();
		Response getCityInformationResponse = httpRequest.request(Method.GET, "/api/"+ API_KEY +"/conditions/q/"+ myCoordinates + ".json");
		String getCityInformationResponseBody = getCityInformationResponse.getBody().asString();
		System.out.println("Response Body is ==> " + getCityInformationResponseBody);
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
	@Test
	public void getWeatherIcon(){
		//String myCoordinates = "40.705086,-74.018715"; 	//New York City
		//String myCoordinates = "25.7617,-80.1918";     	//Miami, FL
		//String myCoordinates = "38.9072,-77.0369";		//Washington, DC
		String myCoordinates = "37.7749,-122.4194";			//San Francisco
		String cityTerm = "";
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("TEST getWeatherIcon");
		RequestSpecification httpRequest = RestAssured.given();
		Response getCityInfoResponse = httpRequest.request(Method.GET, "/api/"+ API_KEY +"/conditions/q/"+ myCoordinates + ".json");
		ResponseBody myResponseBody = getCityInfoResponse.getBody();
		String weatherCondition = myResponseBody.jsonPath().get("current_observation.icon");
		String myCity = myResponseBody.jsonPath().get("current_observation.display_location.city");
		String myState = myResponseBody.jsonPath().get("current_observation.display_location.state");
		String myStateName = myResponseBody.jsonPath().get("current_observation.display_location.state_name");
		String myCountry = myResponseBody.jsonPath().get("current_observation.display_location.country");
		String myZip = myResponseBody.jsonPath().get("current_observation.display_location.zip");
		System.out.println("weather condition: " + weatherCondition.toUpperCase());
		System.out.println("City, State: " + myCity + ", " + myState);
		System.out.println("Full state name " + myStateName);
		System.out.println("Zip Code " + myZip);
		System.out.println("Country: " + myCountry);
		
		if(myCity.contains(" ")){
			cityTerm = myCity.replace(" ", "_");
		} else{
			cityTerm = myCity;
		}
		System.out.println("City term: " + cityTerm);
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
	}
	
	@Test
	public void getAllHeaders(){
		String state = "NC";
		String city = "Laurinburg";
		
		/*
		 * Headers for wunderground api
		 	Key: Accept-Ranges Value: bytes
Key: 		Access-Control-Allow-Credentials Value: true
Key: 		Access-Control-Allow-Origin Value: *
Key: 		Content-Encoding Value: gzip
Key: 		Content-Type Value: application/json; charset=UTF-8
Key: 		Last-Modified Value: Fri, 12 Jan 2018 19:04:34 GMT
Key: 		Server Value: Apache/2.2.15 (CentOS)
Key: 		X-Cacheable Value: YES
Key: 		X-CreationTime Value: 0.137
Key: 		X-Varnish Value: 1328422436
Key: 		Content-Length Value: 1052
Key: 		Vary Value: Accept-Encoding
Key: 		Expires Value: Fri, 12 Jan 2018 19:04:34 GMT
Key: 		Cache-Control Value: max-age=0, no-cache
Key: 		Pragma Value: no-cache
Key: 		Date Value: Fri, 12 Jan 2018 19:04:34 GMT
Key: 		Connection Value: keep-alive
		 */
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("TEST getAllHeaders");
		RequestSpecification httpRequest = RestAssured.given();
		Response getCityInfoResponse = httpRequest.request(Method.GET, "/api/"+ API_KEY +"/conditions/q/"+ state +"/" + city + ".json");
		
		Headers allHeaders = getCityInfoResponse.headers();
		
		for(Header header : allHeaders){
			System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		}
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
	@Test
	public void getAlert(){
		String state = "NC";
		String city = "Winston-Salem";
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("TEST getAlert");
		RequestSpecification httpRequest = RestAssured.given();
		Response alertResponseBody = httpRequest.request(Method.GET, "/api/"+ API_KEY +"/alerts/q/"+ state + "/" + city + ".json");
		
		String getAlertResponseBody = alertResponseBody.getBody().asString();
		System.out.println("the alert response: " + getAlertResponseBody);
		
		System.out.println("==========================================================");
		JSONObject JsonObj = new JSONObject(getAlertResponseBody); 
		if (JsonObj.has("alerts")) { 
			String alertDescription = alertResponseBody.jsonPath().get("alerts[0].description");
			if (alertDescription != NULL){
				System.out.println("Here is the alert: ");
				System.out.println(alertDescription);
				
			} else {
				System.out.println("There are no warnings at this time");
			}
		} else{
			System.out.println("There are no alerts in the JSON");
		}	
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
	@Test
	public void getResponseCodeForWeatherConditions(){
		
		String myCoordinates = "37.7749,-122.4194";			//San Francisco
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("TEST getResponseCodeForWeatherConditions");
		RequestSpecification httpRequest = RestAssured.given();
		Response getCityInfoResponse = httpRequest.request(Method.GET, "/api/"+ API_KEY +"/conditions/q/"+ myCoordinates + ".json");
		int myResponseCode = getCityInfoResponse.getStatusCode();
		
		System.out.println("Here is the response code: " + myResponseCode);
		if(myResponseCode == 200){
			System.out.println("Success!!");
		}
		else{
			System.out.println("Something has gone wrong. Please check your data and try again...");
		}
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
	}
	
	@Test
	public void getResponseCodeForAlert(){
		
		String state = "NC";
		String city = "Winston-Salem";
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("TEST getResponseCodeForAlert");
		RequestSpecification httpRequest = RestAssured.given();
		Response alertResponseBody = httpRequest.request(Method.GET, "/api/"+ API_KEY +"/alerts/q/"+ state + "/" + city + ".json");
		int myResponseCode = alertResponseBody.getStatusCode();
		
		System.out.println("Here is the response code: " + myResponseCode);
		if(myResponseCode == 200){
			System.out.println("Success!!");
		}
		else{
			System.out.println("Something has gone wrong. Please check your data and try again...");
		}
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
	}
}
