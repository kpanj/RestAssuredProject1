package parsingJSONBody;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ConditionBased {
	
	@Test
	void testResponseCondition() {
		Response res = given().contentType(ContentType.JSON)
		.when().get("https://reqres.in/api/users?page=1");
		
		JSONObject jo = new JSONObject(res.toString());
		boolean status = false;
		for(int i = 0;i<jo.getJSONArray("data").length();i++) {
			String email = jo.getJSONArray("data").getJSONObject(i).get("email").toString();
			if(email.equals("emma.wong@reqres.in")) {
				 status = true;
				 break;
			}
		}
		Assert.assertEquals(status, true);
	}
}
