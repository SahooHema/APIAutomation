package diffwaystocreatepostrequestbody;
import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonAndXmlSchemaValidation {
	
	//@Test
	public void jsonSchemaValidation() {	
		given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("JsonSchema.json"));
	}


@Test
public void xmlSchemaValidator() {	
	given()
	.when()
	.get("http://restapi.adequateshop.com/api/Traveler?page=1")
	.then()
	.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("Xmlschema.xsd"));
}


}




























/*
Response :- we check response data
Schema:- we check response data type



















*/