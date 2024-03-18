package requestBodyCreate;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class Byhashmap {
	//Post request Body using hashmap
	
	int id;
	@Test(priority = 1)
	void testPostUsingHashap() {
		HashMap data = new HashMap();
//		data.put("email", "eve.holt@reqres.in");
//		data.put("password", "pistol");
		data.put("name", "Manish");
		data.put("job", "QA");
		
		String skillsArr[] = {"selenium","java","sql"};
		data.put("skills", skillsArr);
		
		HashMap data1 = new HashMap();
		data1.put("name", "Nehal");
		data1.put("job", "Automation QA Lead");
		
		String skillsArr1[] = {"selenium","java","sql","cypress"};
		data1.put("skills1", skillsArr1);
		
		given().contentType("application/json").body(data)
		.when().post("https://reqres.in/api/users")
		.then().statusCode(201)
			.body("name", equalTo("Manish"))
			.body("job", equalTo("QA"))
			.body("skills[0]", equalTo("selenium"))
			.log().all();
		
		id = given().contentType("application/json").body(data1)
		.when().post("https://reqres.in/api/users").jsonPath().getInt("id");
//		.then().statusCode(201)
//			.body("name", equalTo("Nehal"))
//			.body("job", equalTo("Automation QA Lead"))
//			.body("skills1[3]", equalTo("cypress"))
//			.log().all();	
	}
	@Test(priority = 2)
	void deleteUser() {
		given()
		.when().delete("https://reqres.in/api/users"+id)
		.then().statusCode(204).log().all();
	}
}
