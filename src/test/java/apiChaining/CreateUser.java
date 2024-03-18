package apiChaining;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class CreateUser {
	@Test
	void testCreateuser(ITestContext context) {
		
		Faker f = new Faker();
		JSONObject data = new JSONObject();
		data.put("name",f.name().fullName());
		data.put("gender", "Male");
		data.put("email", f.internet().emailAddress());
		data.put("status", "inactive");
		
		String bearerToken = "b68648b22579dd1f89edc7ca89db93f2d83d5a474b64399ba06ea297654d9ce2";
		int id = given().headers("Authorization", "Bearer "+bearerToken)
				.contentType("application/json")
				.body(data.toString())
		.when().post("https://gorest.co.in/public/v2/users")
				.jsonPath().getInt("id");
		System.out.println("Generated id : "+id);
		//context.setAttribute("user_id", id);
		context.getSuite().setAttribute("user_id", id);
	}
}
