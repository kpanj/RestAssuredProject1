package apiChaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class DeleteUser {
	
	@Test
	void testDeleteUser(ITestContext context) {
		
		//int id = (Integer) context.getAttribute("user_id");
		int id = (Integer) context.getSuite().getAttribute("user_id");
		
		String bearerToken = "b68648b22579dd1f89edc7ca89db93f2d83d5a474b64399ba06ea297654d9ce2";
		
				
		given().headers("Authorization", "Bearer "+bearerToken)
				.pathParam("id", id)
		.when().delete("https://gorest.co.in/public/v2/users/{id}")
		.then().statusCode(204).log().all();
		
		
		
		
	}
	
	
}
