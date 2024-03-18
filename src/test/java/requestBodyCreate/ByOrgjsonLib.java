package requestBodyCreate;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class ByOrgjsonLib {
	
	@Test
	void usingOrgJsonLib() {
		JSONObject data = new JSONObject();
		data.put("name", "Manish");
		data.put("job", "QA");
		
		String skillsArr[] = {"selenium","java","sql"};
		data.put("skills", skillsArr);
		
		
		given().contentType("application/json").body(data)
		.when().post("https://reqres.in/api/users")
		.then().statusCode(201)
			.body("name", equalTo("Manish"))
			.body("job", equalTo("QA"))
			.body("skills[0]", equalTo("selenium"))
			.log().all();
	}
}
