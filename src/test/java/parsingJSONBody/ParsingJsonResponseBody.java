package parsingJSONBody;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ParsingJsonResponseBody {
	//@Test(priority = 1)
	void testJsonResponse() {
		//approach 1
		given().contentType("ContentType.JSON")
		.when().get("https://reqres.in/api/users?page=1")
		.then().statusCode(200).body("data[5].email", equalTo("tracey.ramos@reqres.in"));
	}
	//Approach 2
	@Test
	void testJsonResponseBody2() {
		Response res = given().contentType("appication/json")//ContentType.JSON
		.when().get("https://reqres.in/api/users?page=1");
		Assert.assertEquals(res.getStatusCode(), 200);//validation 1
		Assert.assertEquals(res.getHeader("Content-Type"), "application/json; charset=utf-8");
		String fName = res.jsonPath().get("data[4].first_name").toString();
		Assert.assertEquals(fName, "Charles");
	}
}
