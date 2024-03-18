package parsingJSONBody;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SomeOtherApproach {
	
	//JSONObject class
	@Test
	void testJsonResponseBodyData() {
		Response res = given().contentType(ContentType.JSON)//ContentType.JSON
		.when().get("https://reqres.in/api/users?page=1");
		
		JSONObject jo = new JSONObject(res.asString());//converting respose to json object type
		
		for(int i=0; i<jo.getJSONArray("data").length(); i++) {
			String first_name = jo.getJSONArray("data").getJSONObject(i).get("first_name").toString();
			System.out.println(first_name);
		}
		
		
		
	}
	//@Test
	void test() {
		Response res = given().contentType("application/json")
						.when().get("https://reqres.in/api/users?page=1");
        
        // Check if the request was successful
        if (res.getStatusCode() == 200) {
            JSONObject jo = new JSONObject(res.getBody().asString()); // Convert the response body to JSON

            for(int i = 0; i < jo.getJSONArray("data").length(); i++) {
                String first_name = jo.getJSONArray("data").getJSONObject(i).getString("first_name");
                System.out.println(first_name);
            }
        } else {
            System.out.println("Request failed with status code: " + res.getStatusCode());
        }
    }
	

}
