package apiChaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class UpdateUser {
	
	@Test
	void testUpdateUser(ITestContext context) {
		
		Faker f = new Faker();
		JSONObject data = new JSONObject();
		data.put("name",f.name().fullName());
		data.put("gender", "Male");
		data.put("email", f.internet().emailAddress());
		data.put("status", "active");
		
		String bearerToken = "b68648b22579dd1f89edc7ca89db93f2d83d5a474b64399ba06ea297654d9ce2";
		//int id = (Integer) context.getAttribute("user_id");
		int id = (Integer) context.getSuite().getAttribute("user_id");
		given().headers("Authorization", "Bearer "+bearerToken)
				.contentType("application/json")
				.pathParam("id", id)
				.body(data.toString())
		.when().put("https://gorest.co.in/public/v2/users/{id}")
		.then().statusCode(200).log().all();
		
		
	}
}
