package requestBodyCreate;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class ByPojoClass {
	@Test
	void testusingPojo() {
		
		PojoPostClass data = new PojoPostClass();
		data.setName("ManishJha");
		data.setJob("QA");
		String skillsArr[] = {"java", "selenium", "sql"};
		data.setSkills(skillsArr);
		
		given().contentType("application/json").body(data)
		.when().post("https://reqres.in/api/users")
		.then().statusCode(201).log().all();
		
	}
}
