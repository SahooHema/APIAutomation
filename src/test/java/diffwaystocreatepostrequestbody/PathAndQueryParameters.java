package diffwaystocreatepostrequestbody;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.*;

public class PathAndQueryParameters {
	
	@Test
	public void testPathQueryParam() {
		
		
		given()
		.pathParam("mypath","users")//path param will work as rooting the request
		.queryParam("page", 2)//query param will filter the data
		.queryParam("id", 5)
		.when()
		.get("https://reqres.in/api/{mypath}")
		.then()
		.statusCode(200)
		.log().all();
	}

}
