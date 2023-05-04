package diffwaystocreatepostrequestbody;
import org.json.JSONObject;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.*;

public class POSTBody {
	

//1)post request body using hashmap	
	//@Test(priority=1)
	public void postByHashMap() {
		
	HashMap data=new HashMap();
	data.put("name", "Sameer");
	data.put("location", "Sanfrancisco");
	data.put("phone", "9078452359");
	
	String coursearray[]= {"python","ruby"};
	data.put("courses", coursearray);
	
   given()
	.contentType("application/json")
	.body(data)
	
	.when()
	.post("http://localhost:3000/students")
	
	.then()
	.statusCode(201)
	.body("name",equalTo("Anurag"))
	.body("location",equalTo("Sanfrancisco"))
	.body("phone",equalTo("9078452359"))
	.body("courses[0]", equalTo("python"))
	.body("courses[1]",equalTo("ruby"))
	.header("Content-Type","application/json; charset=utf-8")
	.log().all();
	}
	
//@Test(priority=2)
	public void dlt() {
		 given()
		.when()
		.delete("http://localhost:3000/students/ObNwRlM")
		.then()
		.statusCode(200);
	}
	
//2)post request body using org.json	library	
	
	//@Test(priority=1)
		public void testPostUsingJSONlib() {
			
			
	JSONObject js=new JSONObject();
	js.put("name", "Neha");
	js.put("location", "Indore");
	js.put("phone", "568931");
	
	String coursearray[]= {"perl","c++"};
	js.put("courses", coursearray);
	
	   given()
		.contentType("application/json")
		.body(js.toString())
		
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name",equalTo("Neha"))
		.body("location",equalTo("Indore"))
		.body("phone",equalTo("568931"))
		.body("courses[0]",equalTo("perl"))
		.body("courses[1]",equalTo("c++"))
		.header("Content-Type","application/json; charset=utf-8")
		.log().all();
		}
	//	@Test(priority=2)
		public void testDelete() {
			 given()
			.when()
			.delete("http://localhost:3000/students/MIDxwcd")
			.then()
			.statusCode(200);
		}
	
//3)post request body using  pojo(plain old java object) class	****imp***	
//note:we will use encapsulation i.e. getter and setter methods.create separate class for pojo in that declare variables and select variables and right click-> source->getter and setter option
	
		
		
		//@Test(priority=1)
		public void testPostUsingpojo() {			
			Pojopostrequest pj=new Pojopostrequest();
			pj.setName("Mohini");
			pj.setLocation("germany");
			pj.setPhone("62223");
			
			String coursearr[]= {"php","kotlin"};
			pj.setCourses(coursearr);
			
			   given()
				.contentType("application/json")
				.body(pj)
				
				.when()
				.post("http://localhost:3000/students")
				
				.then()
				.statusCode(201)
				.body("name",equalTo("Mohini"))
				.body("location",equalTo("germany"))
				.body("phone",equalTo("62223"))
				.body("courses[0]",equalTo("php"))
				.body("courses[1]",equalTo("kotlin"))
				.header("Content-Type","application/json; charset=utf-8")
				.log().all();
				}
	
	
	
		@Test(priority=2)
			public void testDlt() {
				 given()
				.when()
				.delete("http://localhost:3000/students/gT97aAk")
				.then()
				.statusCode(200);
			}
		
//By using external json file	
}
	
