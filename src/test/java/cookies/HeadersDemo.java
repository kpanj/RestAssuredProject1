package cookies;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersDemo {
	
	@Test
	void testHeader() {
		given()
		.when().get("https://www.google.com/")
		.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.header("Content-Encoding", "gzip")
			.header("Server", "gws").log().headers();
	}
	//@Test
	void getHeaders() {
		Response res = given()
		.when().get("https://www.google.com/");
		
		//get single header info
//		String headerValue = res.getHeader("Content-Type");
//		System.out.println("Value of content type header is :"+headerValue);
		
		//get all headers info
		Headers myHeaders = res.getHeaders();
		for( Header hd:myHeaders) {
			System.out.println(hd.getName()+"   "+hd.getValue());
		}
	}
}
