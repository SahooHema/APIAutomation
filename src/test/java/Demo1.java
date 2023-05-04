import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
public class Demo1 {	
	@Test
	public void parameters() throws JsonProcessingException {
		String token="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";
	given()
.auth().oauth2(token)
	.when()
	.get("https://api.github.com/users/repos")
	.then()
	.statusCode(200)
	.log().all();
}
}	