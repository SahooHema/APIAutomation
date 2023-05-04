import static io.restassured.RestAssured.given;


import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import org.testng.annotations.Test;
public class HTTPRequests {
	int id;

	@Test(priority=1)
	 void getUsers() {
		
		given()
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		.statusCode(200)
		.body("page",equalTo(2))
		.log().all();
	}
	 
	@Test(priority=2)
	 void createUser() {
		HashMap<String, String> data=new  HashMap<String, String>();
		data.put("name","hema");
		data.put("job","tester");
		 
		id= given()
		 .contentType("application/json")
		 .body(data)
		 .when()
		 .post("https://reqres.in/api/users")
		 .jsonPath().getInt("id");
//		 .then()
//		  .statusCode(201)
//		  .log().all()
//		  .extract()
	 }
	 
	 @Test(priority=3,dependsOnMethods= {"createUser"})
	 public void updateUser() {
		 HashMap<String, String> data=new  HashMap<String, String>();
			data.put("name","Rahul");
			data.put("job","tester");
		 given()
		 .contentType("application/json")
		 .body(data)
		 .when()
		 .put("https://reqres.in/api/users/"+id)
		 .then()
		  .statusCode(200)
		  .log().all(); 
		 }
	 
	 @Test(priority=4)
	 public void deleteUser() {
		 
		 given()
		 .when()
		 .delete("https://reqres.in/api/users/"+id)
		 .then()
		 .statusCode(200)
		 .log().all();
}}
/*
RestAssured path and query parameters:-
1) https://reqres.in/api/users?page=2
2) https://reqres.in/api/users?page=2&id=5
https://reqres.in->domain
/api/users->path
 ?page=2->query

cookies and headers:-
logs:-























 */
