import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class DifferentTypesOfAuthorizations {
	
	//@Test(priority=1)
	public void testBasicAuthentication() {		
		given()
		.auth().basic("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
		
		
	}
	//@Test(priority=2)
	public void testDigestAuthentication() {
		
		given()
		.auth().digest("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
		
		
	}
	
//@Test(priority=3)
	public void testPreemptiveAuthentication() {
		
		given()
		.auth().preemptive().basic("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
	}

//@Test
public void testBearerTokenAuthentication() {
	
	String token="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";
	
	given()
	.headers("Authorization","Bearer "+ token)
	.when()
	.get("https://api.github.com/users/repos")
	.then()
	.statusCode(200)
    .log().all();
}

//@Test
public void testOauth1Authentication() {
	given()
	.auth().oauth("consumerKey","consumerSecret","accessToken","secretToken")//oAuth1.0
	.when()
	.get("url")
	.then()
	.statusCode(200)
	.body("authenticated",equalTo(true))
	.log().all();
}


@Test
public void testOauth2Authentication() {
	given()
	.auth().oauth2("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")
	.when()
	.get("https://api.github.com/users/repos")
	.then()
	.statusCode(200)
	.log().all();
}

}




























/*
Authentication:-to check user entered valid credentials or not..
Authorization:-credentials are valid but need permission or access privileges
https://postman-echo.com/basic-auth :- this api will support basic, digest and preemptive authentication coz only need to pass username and pwd..

Github-Token: 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
Note: go to github->settings->devloper-settings->token->generate token classic

clientsecret:- 97325f47d28d5eeed0366623c81f13cd3e1bac92
clientID:-  d83e519395f5c1a3946b
Note: go to github->settings->devloper- settings->oauthapps->create new application->client ID & Client secret..

How to use OAUTH2:- 2 steps involved to get access token
1)GET:-https://github.com/login/oauth/authorize?client_id=d83e519395f5c1a3946b.. 
Note: send this api and get code.. "https://www.homepage.com/?code=47937a0b2cbaf0a2c244"
Note: use this api in postman(to run it) and browser (to get code)
2)POST:- https://github.com/login/oauth/access_token?client_id=d83e519395f5c1a3946b&client_secret=97325f47d28d5eeed0366623c81f13cd3e1bac92&code=47937a0b2cbaf0a2c244
https://www.homepage.com/?code=36cef5280b27f80e148b
access_token=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&scope=&token_type=bearer
3)GET:- https://api.github.com/users/mojombo
Authorization->oauth2.0->pass access_token under token text-field and send request 

Interview questions:- what is swagger ? it is used to explore api's, how api's works , cannot do validations, report generate and show
What is postman:- used to do actual testing..

cURL(client url)-> request with headers
open cmd->curl -X GET "https://fakerestapi.azurewebsites.net/api/v1/Activities" -H  "accept: text/plain; v=1.0"
get response 

postman use curl:- import->raw-text->paste cURL request->continue->import
by-default request shows in postman with all details i.e. headers etc..

linkedin profile URL:-
https://www.linkedin.com/in/hema-sahoo-a2aa7b269

500000
1000000
*/