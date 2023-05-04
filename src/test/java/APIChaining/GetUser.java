package APIChaining;
import static io.restassured.RestAssured.given;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {
	
	@Test
	public void testGetuser(ITestContext context) {
		int id = (Integer) context.getSuite().getAttribute("user_id");
		
String token= (String) context.getSuite().getAttribute("bearer_token");
given()
.headers("Authorization","Bearer "+token)
.pathParam("id",id)
.when()
.get("https://gorest.co.in/public/v2/users/{id}")
.then()
.statusCode(200)
.log().all();
}
	
}