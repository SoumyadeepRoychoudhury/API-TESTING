package Earthquakedata;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class USGSApi {

	public Response response;

	public USGSApi() {
		String uri = "/fdsnws/event/1/query?format=geojson&starttime=2021-08-01&minlatitude=10&maxlatitude=25&minlongitude=70&maxlongitude=80";

		RestAssured.baseURI = "https://earthquake.usgs.gov";
		response = RestAssured.given().contentType(ContentType.JSON).when().get(uri).then().extract().response();

	}

}
