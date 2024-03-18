package authentication;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Authentication2 {
	
	//@Test(priority = 0)
	void testBearerTokenAuthentication() {
		String bearerToken = "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";
		given().headers("Authorization", "Bearer "+bearerToken)
		.when().get("https://api.github.com/user/repos")
		.then().statusCode(200).log().all();
	}
	//@Test
	void testOauth1Authentication() {
		
		given().auth().oauth("consumerKey", "consumerSecrat" ,"accessToken", "tokenSecrat")
		.when().get("url")
		.then().statusCode(200).log().all();
	}
	
	@Test(priority = 1)
		void testOauth2Authentication() {
			
			given().auth().oauth2("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")
			.when().get("https://api.github.com/user/repos")
			.then().statusCode(200).log().all();
		}
	//@Test(priority = 2)
	void testApiKeyAuthentication() {
		//method 1
		given().queryParam("appid", "c5948c78c7a3f87205f29297f7d1432d")//api key
		.when().get("https://api.openweathermap.org/data/2.5/forecast/daily?q=delhi&units=metric&cnt=7")
		.then().statusCode(200).log().all();
	}
	@Test
	void testApiKey2Authentication() {
		//method 1
		given().queryParam("appid", "c5948c78c7a3f87205f29297f7d1432d")//api key
			.pathParams("myPath", "data/2.5/forecast/daily")
			.queryParam("q", "delhi")
			.queryParam("units", "metric")
			.queryParam("cnt", "7")
		.when().get("https://api.openweathermap.org/{myPath}")
		.then().statusCode(200).log().all();
	}
	
}
