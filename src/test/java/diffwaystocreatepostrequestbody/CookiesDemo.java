package diffwaystocreatepostrequestbody;
import static io.restassured.RestAssured.*;



import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.*;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesDemo {
	
  //  @Test(priority=1)
	public void testCookies() {
		
		given()
		.when()
		.get("https://www.google.com/")
		.then()
		.cookie("AEC","AUEFqZeEWrdwTLPucqAs6F17SFpGsksnm-WKAWKnGUN9sKrH1VglVt-lcq4")
		.log().all();
	}

//note:- test case fails if cookies is generated different every time when request is send 

//@Test(priority=2)
public void getCookiesInfo() {
Response res=given()
	.when()
	.get("https://www.google.com/");
Map<String, String> cookie_value=res.getCookies();//get all cookies

System.out.println(cookie_value.keySet());
for(String k:cookie_value.keySet()) {
String cookie=res.getCookie(k);
System.out.println(k+"      "+cookie);
}

String cookie_value1=res.getCookie("AEC");//get single cookie details
System.out.println(cookie_value1);
}

}