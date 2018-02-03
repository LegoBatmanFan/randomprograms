/************************************************************************************
 * LegoBatmanFan									9 January 2018
 * 
 * SimpleGetTest.java
 * API testing with RestAssured using the Google API
 * http://maps.googleapis.com
 * 1. getCityInformation: GET request for information about Greensboro, NC
 * 2. useGPSCoordinates: GET request for info about NYC using GPS coordinates
 * 3. getResponseCode: returns a response code and message (based upon the response code).
 * 4. getDifferentHeaderTypes: get values for the following headers: Content-Type, Server, 
 * 		and Content-Encoding
 * 5. getAllHeaders: get the values of every header
 * 6. validateResponseHeader: check to see if a header contains specific text
 * 7. checkForSpecificText: check the response body for specific text
 * 8. getNode: return specific node
 * 9. getAssertStatusCode: make an assertion about the status code
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

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class MySimpleGetTest {
	
	@BeforeTest
	public void setBaseUri(){
		RestAssured.baseURI = "http://maps.googleapis.com";
	}
	
	@Test
	public void getCityInformation(){
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("TEST getCityInformation");
		RequestSpecification httpRequest = RestAssured.given();
		Response getCityInformationResponse = httpRequest.request(Method.GET, "/maps/api/geocode/json?address=Greensboro");
		String getCityInformationResponseBody = getCityInformationResponse.getBody().asString();
		System.out.println("Response Body is ==> " + getCityInformationResponseBody);
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
	@Test
	public void useGPSCoordinates(){
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("TEST useGPSCoordinates");
		RequestSpecification httpRequest = RestAssured.given();
		Response getCityInformationResponse = httpRequest.request(Method.GET, "/maps/api/geocode/json?address=40.6892,-74.0445");
		String getCityInformationResponseBody = getCityInformationResponse.getBody().asString();
		System.out.println("Using GPS coordinates:");
		System.out.println("Response Body is ==> " + getCityInformationResponseBody);
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
	@Test
	public void getResponseCode(){
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("TEST getResponseCode");
		RequestSpecification httpRequest = RestAssured.given();
		//use goodStatus to get a response code of 200
		//use badStatus to get a response code of 400
		String goodStatus = "/maps/api/geocode/json?address=7779311";
		
		String badStatus = "/maps/api/geocode/pokemon?address=7779311";
		
		Response getCityInfoResponse = httpRequest.request(Method.GET, goodStatus);
		
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
	public void getDifferentHeaderTypes(){
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("TEST getDifferentHeaderTypes");
		RequestSpecification httpRequest = RestAssured.given();
		Response getCityInfoResponse = httpRequest.request(Method.GET, "/maps/api/geocode/json?address=Greensboro");
		
		String contentType = getCityInfoResponse.header("Content-Type");
		String serverType = getCityInfoResponse.header("Server");
		String languageType = getCityInfoResponse.header("Content-Encoding");
		
		System.out.println("Content-Type value: " + contentType);
		System.out.println("Server value: " + serverType);
		System.out.println("Content-Encoding: " + languageType);
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
	@Test
	public void getAllHeaders(){
		/* Different headers for http://maps.googleapis.com
		Key: Content-Type Value: application/json; charset=UTF-8
		Key: Date Value: Tue, 31 Oct 2017 18:16:01 GMT
		Key: Expires Value: Wed, 01 Nov 2017 18:16:01 GMT
		Key: Cache-Control Value: public, max-age=86400
		Key: Vary Value: Accept-Language
		Key: Access-Control-Allow-Origin Value: *
		Key: Content-Encoding Value: gzip
		Key: Server Value: mafe
		Key: Content-Length Value: 469
		Key: X-XSS-Protection Value: 1; mode=block
		Key: X-Frame-Options Value: SAMEORIGIN
		 */
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("TEST getAllHeaders");
		RequestSpecification httpRequest = RestAssured.given();
		Response getCityInfoResponse = httpRequest.request(Method.GET, "/maps/api/geocode/json?address=chapelhill");
		
		Headers allHeaders = getCityInfoResponse.headers();
		
		System.out.println("Here are the headers:");
		for(Header header : allHeaders){
			System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		}
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
	@Test
	public void validateResponseHeader(){
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("TEST validateResponseHeader");
		RequestSpecification httpRequest = RestAssured.given();
		Response getCityInfoResponse = httpRequest.request(Method.GET, "/maps/api/geocode/json?address=chapelhill");
		String testHeaderBadString = "bibbitty bobbitty boo";
		String testHeaderGoodString = "application/json; charset=UTF-8";
		String testContentType = getCityInfoResponse.header("Content-Type");
		
		if (testContentType.equalsIgnoreCase(testHeaderBadString)){
			System.out.println(testHeaderBadString + " is in the header");
		}
		else{
			System.out.println(testHeaderBadString + " is NOT in the header");
		}
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
	@Test
	public void checkForSpecificText(){
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("TEST checkForSpecificText");
		RequestSpecification httpRequest = RestAssured.given();
		Response getCityInfoResponse = httpRequest.request(Method.GET, "/maps/api/geocode/json?address=lumberton");
		String testResponseBadString = "Guilford";
		String testResponseGoodString = "North Carolina";
		
		ResponseBody myResponseBody = getCityInfoResponse.getBody();
		String myResponseBodyString = myResponseBody.asString();
		if(myResponseBodyString.contains(testResponseGoodString)){
			System.out.println(testResponseGoodString + " is in the response body");
		}
		else{
			System.out.println(testResponseGoodString + " is NOT in the response body");
		}
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
	@Test
	public void getNode(){
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("TEST getNode");
		RequestSpecification httpRequest = RestAssured.given();
		Response getCityInfoResponse = httpRequest.request(Method.GET, "/maps/api/geocode/json?address=Greensboro");
		ResponseBody myResponseBody = getCityInfoResponse.getBody();
		
		System.out.println("====================================");
		System.out.println(" ");
		String myStatus = myResponseBody.jsonPath().get("status");
		System.out.println("STATUS: " + myStatus);
		System.out.println(" ");
		System.out.println("====================================");
		
		String myPlaceID = myResponseBody.jsonPath().get("results.place_id[0]");
		System.out.println("place_id: " + myPlaceID);
		
		String myAddress = myResponseBody.jsonPath().get("results.formatted_address[0]");
		Float myLat = myResponseBody.jsonPath().get("results.geometry.location[0].lat");
		Float myLong = myResponseBody.jsonPath().get("results.geometry.location[0].lng");
		System.out.println("My address: " + myAddress);
		System.out.println("Latitude: " + myLat);
		System.out.println("Longitude: " + myLong);
		System.out.println("====================================");
		
		System.out.println(" ");
		String myLocationType = myResponseBody.jsonPath().get("results.geometry.location_type[0]");
		System.out.println("location_type: " + myLocationType);
			
		System.out.println("Here are the boundaries (northeast)...");
		Float myLatNortheast = myResponseBody.jsonPath().get("results.geometry.bounds.northeast[0].lat");
		Float myLongNortheast = myResponseBody.jsonPath().get("results.geometry.bounds.northeast[0].lng");
		System.out.println("Latitude: " + myLatNortheast);
		System.out.println("Longitude: " + myLongNortheast);
		
		System.out.println(" ");
		System.out.println("Here are the boundaries (southwest)...");
		Float myLatSouthwest = myResponseBody.jsonPath().get("results.geometry.bounds.southwest[0].lat");
		Float myLongSouthwest = myResponseBody.jsonPath().get("results.geometry.bounds.southwest[0].lng");
		System.out.println("Latitude: " + myLatSouthwest);
		System.out.println("Longitude: " + myLongSouthwest);
		
		System.out.println(" ");
		System.out.println("Here are the viewports (northeast)...");
		Float myLatViewNortheast = myResponseBody.jsonPath().get("results.geometry.viewport.northeast[0].lat");
		Float myLongViewNortheast = myResponseBody.jsonPath().get("results.geometry.viewport.northeast[0].lng");
		System.out.println("Latitude: " + myLatViewNortheast);
		System.out.println("Longitude: " + myLongViewNortheast);
		
		System.out.println(" ");
		System.out.println("Here are the viewports (southwest)...");
		Float myLatViewSouthwest = myResponseBody.jsonPath().get("results.geometry.viewport.southwest[0].lat");
		Float myLongViewSouthwest = myResponseBody.jsonPath().get("results.geometry.viewport.southwest[0].lng");
		System.out.println("Latitude: " + myLatViewSouthwest);
		System.out.println("Longitude: " + myLongViewSouthwest);
		
		System.out.println("====================================");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
	}
	
	@Test
	public void getAssertStatusCode() throws Exception{
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("TEST getAssertStatusCode");
		try{
			ValidatableResponse myResponseCode = RestAssured.given()
					.param("address","bruh")
					.when()
					.get("/maps/api/geocode/json")
					.then().assertThat().statusCode(200);
			System.out.println("There are no errors! Status code: 200!");
		}
		/*
		 * Throwable catches everything!!!
		 * https://stackoverflow.com/questions/1375113/java-exception-not-caught
		 */
		
		catch (Throwable e){
			System.out.println("Here is the error: \n" + e);
		}
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}

}
