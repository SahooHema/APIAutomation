package APIChaining;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;


public class CreateUser {
	
	
	@Test
	public void testCreateuser(ITestContext context) {
		
		Faker f=new Faker();
		JSONObject js=new JSONObject();
		js.put("name",f.name().firstName());
		js.put("gender","female");
		js.put("email",f.internet().emailAddress());
		js.put("status", "inactive");
		
		
		String token="6fddf1a178bd579f6e15bbe77560140ec51903406664b3d055d3982df4050ff2";
		
int id=		given()
	.headers("Authorization","Bearer "+token)
	.contentType("application/json")
	.body(js.toString())		
		.when()
		.post("https://gorest.co.in/public/v2/users")
		.jsonPath().getInt("id");
System.out.println(id);
context.getSuite().setAttribute("user_id", id);
context.getSuite().setAttribute("bearer_token",token);



//Response res=given()
//.headers("Authorization","Bearer "+token)
//.contentType("application/json")
//.body(js.toString())		
//	.when()
//	.post("https://gorest.co.in/public/v2/users");
//String name=	res.jsonPath().get("name").toString();
//System.out.println(name);	
		
	}

}
