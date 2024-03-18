package jsonSchemaValidation;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class JsconSchemaValidation {
	
	@Test
	void testJsonSchemaValidation() {
		given()
		.when().get("https://reqres.in/api/users?page=2")
		.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonschema.json"));
	}
}
