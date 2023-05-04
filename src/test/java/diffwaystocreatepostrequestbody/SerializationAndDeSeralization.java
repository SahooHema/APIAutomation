package diffwaystocreatepostrequestbody;
import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializationAndDeSeralization {
 
    @Test
	public void convertPojoToJson() throws JsonProcessingException {
		
//created java object with pojo class
		StudentPojo pj=new StudentPojo();
		pj.setName("Mohini");
		pj.setLocation("germany");
		pj.setPhone("62223");		
		String coursearr[]= {"php","kotlin"};
		pj.setCourses(coursearr);

//convert java object to json object is c/d serialization
		ObjectMapper om=new ObjectMapper();
	String jsondata= om.writerWithDefaultPrettyPrinter().writeValueAsString(pj);
		System.out.println(jsondata);
		
}
	
	
	//@Test
	public void convertJsonToPojo() throws JsonProcessingException {

		String jsonData= "{\r\n"
				+ "  \"name\" : \"Mohini\",\r\n"
				+ "  \"location\" : \"germany\",\r\n"
				+ "  \"phone\" : \"62223\",\r\n"
				+ "  \"courses\" : [ \"php\", \"kotlin\" ]\r\n"
				+ "}";
		ObjectMapper om=new ObjectMapper();
	     StudentPojo stu=om.readValue(jsonData, StudentPojo.class);
		System.out.println(stu.getLocation());
		System.out.println(stu.getName());
		System.out.println(stu.getPhone());
		System.out.println(stu.getCourses()[0]);
		System.out.println(stu.getCourses()[1]);
		
		}
		
}
/*
Interview questions:- serialization -> convert pojo to json
De-serialization-> convert json to pojo 
Note:- used jackson binding package along with object mapper to convert pojo to json and vice-versa..














*/