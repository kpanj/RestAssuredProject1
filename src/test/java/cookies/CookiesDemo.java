package cookies;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CookiesDemo {
	
	@Test
	void testCookies() {
		given()
		.when().get("https://www.google.com/")
		.then().statusCode(200)
			.cookie("AEC", "Ae3NU9OlUu3J0KWjKv31IHH_1GXBpDFk4nPtNhG2hDTHoFwG29fBzPdnjQ")
			.log().all();
			
	}
}
