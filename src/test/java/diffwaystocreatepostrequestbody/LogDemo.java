package diffwaystocreatepostrequestbody;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.*;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class LogDemo {	
	
	@Test
	public void testLogs() {
		
		given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		//.log().all()//print all headers, cookies, response body,status code
		//.log().body();//to print only response body
		.log().cookies() ;//to print only cookies
//		.log().headers();/to print only headers
		
	}

}
