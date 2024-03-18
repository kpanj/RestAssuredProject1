package jsonSchemaValidation;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//pojo--serialize--JsonObject--de-serialize---pojo
public class SerializationDeserialization {
	//pojo---json
	//@Test
	void convertPojoToJson() throws JsonProcessingException {
		Student st = new Student();//pojo
		st.setName("Manish jha");
		st.setJob("Quality analyst");
		String skillsArr[] = {"java", "selenium", "as400"};
		st.setSkills(skillsArr);
		
		//convert java object to json object
		ObjectMapper om = new ObjectMapper();
		String jsonData = om.writerWithDefaultPrettyPrinter().writeValueAsString(st);
		System.out.println(jsonData);
	
	}
	//json--pojo===== de-serialization
	@Test
	void convertJson2Pojo() throws JsonProcessingException {
		
		String jsonData = "{\r\n"
				+ "  \"name\" : \"Manish jha\",\r\n"
				+ "  \"job\" : \"Quality analyst\",\r\n"
				+ "  \"skills\" : [ \"java\", \"selenium\", \"as400\" ]\r\n"
				+ "}\r\n"
				+ "";
		
		//convert json data -----pojo oject
		ObjectMapper om = new ObjectMapper();
		Student stu = om.readValue(jsonData, Student.class);
		System.out.println("name : "+stu.getName());
		System.out.println("job : "+stu.getJob());
		System.out.println("job : "+stu.getSkills()[1]);
		//stu.getSkills()[1]
		
		
		
	}
	
	
}
