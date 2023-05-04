package APIChaining;
import static io.restassured.RestAssured.given;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

public class UpdateUser {

	@Test
	public void testUpdateuser(ITestContext context) {
		
		int id=(Integer) context.getSuite().getAttribute("user_id");
		Faker f=new Faker();
		JSONObject js=new JSONObject();
		js.put("name",f.name().firstName());
		js.put("gender","male");
		js.put("email",f.internet().emailAddress());
		js.put("status", "active");
		
		String token= (String) context.getSuite().getAttribute("bearer_token");
		
	given()
	.headers("Authorization","Bearer "+token)
	.pathParam("id",id)
	.contentType("application/json")
	.body(js.toString())		
		.when()
		.put("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.statusCode(200)
		.log().all();		
	}
}
