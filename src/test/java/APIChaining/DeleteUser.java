package APIChaining;
import static io.restassured.RestAssured.given;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteUser {
	
	@Test
	public void testDeleteuser(ITestContext context) {
		int id = (Integer) context.getSuite().getAttribute("user_id");	
		String token= (String) context.getSuite().getAttribute("bearer_token");
     	given()
		.headers("Authorization","Bearer "+token)
		.pathParam("id",id)
		.when()
		.delete("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.statusCode(204)
		.log().all();
	}

}

/*

How to remove unwanted imports? select import pkg, select organize it will remove unwanted imports pkgs..
When to use application.json and application/json:- if pass in headers use application.json , if pass in content-type use application/json
How to pass id in other classes as request :- 
1)pass testng parameter ITestContext context in create method  
2)context.setAttribute("user_id", id);
3)Add int id = (Integer) context.getAttribute("user_id");	in other class to get id ..

Note: to run all test classes together use testng.xml and arrange classes accordingly and run it..

Note:- setAttribute is applicable only for test scope , if all classes are under same test name under testng.xml, then will get pass otherwise fail..

Note:- to run all classes separately, use context.getSuite().setAttribute("user_id", id); (add getSuite()) and create another testng2.xml and run it

Note:after adding context.getSuite().setAttribute("user_id", id); we can run both testng.xml and testng2.xml ..
*/