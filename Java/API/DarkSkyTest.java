/************************************************************************************
 * LegoBatmanFan									9 January 2018
 * 
 * SimpleWeatherTest.java
 * Original program: API testing with RestAssured using the wunderground API
 * http://api.wunderground.com
 * 1 May 2019 Update: Now using Dark Sky API
 * 1. checkFullResponse(): gets the full response from the API and checks if objects are null
 * 2. checkCurrentWeatherDataOnlyResponse(): gets the current data and checks if the each field is null
 * 3. checkDailyWeatherDataOnlyResponse(): gets the daily (week) data. Checks fields and an the size of an array
 * 
 * GPS coordinates and timezone are the only fields that are validated (these values do not change).
 * 
 * Add the following dependencies in the pom.xml file:
 * 	<!-- https://mvnrepository.com/artifact/org.hamcrest/hamcrest-all -->
 *		<dependency>
 *			<groupId>org.hamcrest</groupId>
 *			<artifactId>hamcrest-all</artifactId>
 *			<version>1.3</version>
 *			<scope>test</scope>
 *		</dependency>
 *
 * 
 * -----------------------------------------------------------------------------
 * Modification History
 * Date					Author				Description
 * ----------------------------------------------------------------------------
 * 9 January 2018		LegoBatmanFan		Created
 * 1 May 2019			LegoBatmanFan		Using new API and created new methods
 ************************************************************************************/

package com.legobatmanfan.api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class DarkSkyTest {

	private static String API_KEY = null;
	private static String FILE_DIRECTORY = System.getProperty("file.separator") + "Users"
			+ System.getProperty("file.separator") + "lenahorsley" + System.getProperty("file.separator") + "Documents"
			+ System.getProperty("file.separator") + "Lena" + System.getProperty("file.separator") + "TestingNotes"
			+ System.getProperty("file.separator");
	private static String API_CURRENTLY_QUERY_STRING = "?units=si&exclude=minutely,hourly,daily";
	private static String API_DAILY_QUERY_STRING = "?units=si&exclude=currently,minutely,hourly";
	private static float latitudeCoordinate = 40.705086f;
	private static float longitudeCoordinate = -74.018715f;
	private static String myCoordinates = latitudeCoordinate + "," + longitudeCoordinate;
	private static String timezone = "America/New_York";

	@BeforeTest
	public void setBaseUri() throws IOException {
		RestAssured.baseURI = "https://api.darksky.net";
		API_KEY = Files.readAllLines(Paths.get(FILE_DIRECTORY + "DarkSkyAPI.txt")).get(0);
		System.out.println("Powered by Dark Sky - https://darksky.net/poweredby/");
	}

	@Test
	public void checkFullResponse() {

		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("TEST getWeatherUsingCoordinates");
		RequestSpecification httpRequest = RestAssured.given();
		Response getFullResponse = httpRequest.request(Method.GET, "/forecast/" + API_KEY + "/" + myCoordinates);
		getFullResponse.then().log().ifError().statusCode(200).body("latitude", equalTo(latitudeCoordinate))
				.body("longitude", equalTo(longitudeCoordinate)).body("timezone", equalTo(timezone))
				.body("currently", notNullValue())
				.body("minutely", notNullValue())
				.body("hourly", notNullValue())
				.body("daily", notNullValue())
				.body("flags", notNullValue());
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}

	@Test
	public void checkCurrentWeatherDataOnlyResponse() {

		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("TEST getWeatherUsingCoordinates");
		RequestSpecification httpRequest = RestAssured.given();
		Response getFullResponse = httpRequest.request(Method.GET,
				"/forecast/" + API_KEY + "/" + myCoordinates + API_CURRENTLY_QUERY_STRING);
		getFullResponse.then().log().ifError().statusCode(200).body("latitude", equalTo(latitudeCoordinate))
				.body("longitude", equalTo(longitudeCoordinate)).body("timezone", equalTo(timezone))
				.body("currently.summary", notNullValue())
				.body("currently.icon", notNullValue())
				.body("currently.nearestStormDistance", notNullValue())
				.body("currently.nearestStormBearing", notNullValue())
				.body("currently.precipIntensity", notNullValue())
				.body("currently.precipProbability", notNullValue())
				.body("currently.temperature", notNullValue())
				.body("currently.apparentTemperature", notNullValue())
				.body("currently.dewPoint", notNullValue())
				.body("currently.humidity", notNullValue())
				.body("currently.pressure", notNullValue())
				.body("currently.windSpeed", notNullValue())
				.body("currently.windGust", notNullValue())
				.body("currently.windBearing", notNullValue())
				.body("currently.cloudCover", notNullValue())
				.body("currently.uvIndex", notNullValue())
				.body("currently.visibility", notNullValue())
				.body("currently.ozone", notNullValue())
				.body("flags.sources", notNullValue())
				.body("flags.nearest-station", notNullValue())
				.body("flags.units", notNullValue());
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}

	@Test
	public void checkDailyWeatherDataOnlyResponse() {

		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("TEST getWeatherUsingCoordinates");
		RequestSpecification httpRequest = RestAssured.given();
		Response getFullResponse = httpRequest.request(Method.GET,
				"/forecast/" + API_KEY + "/" + myCoordinates + API_DAILY_QUERY_STRING);
		getFullResponse.then().log().ifError().statusCode(200).body("latitude", equalTo(latitudeCoordinate))
				.body("longitude", equalTo(longitudeCoordinate)).body("timezone", equalTo(timezone))
				.body("daily.summary", notNullValue())
				.body("daily.icon", notNullValue())
				.body("daily.data", hasSize(8))
				.body("flags.sources", notNullValue())
				.body("flags.nearest-station", notNullValue())
				.body("flags.units", notNullValue());
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
}
