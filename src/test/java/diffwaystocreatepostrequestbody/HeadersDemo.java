package diffwaystocreatepostrequestbody;
import static io.restassured.RestAssured.*;


import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.*;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class HeadersDemo {
	
@Test(priority=1)
		public void testHeaders() {
			
			given()
			.when()
			.get("https://www.google.com/")
			.then()
			.header("Content-Type","text/html; charset=ISO-8859-1")
			.and()
			.header("Content-Encoding", "gzip")
			.log().headers();
		}

//note:header content does not change.. 
//no need to use getheaders() instead use log().headers()		

@Test(priority=2)
public void getHeadersInfo() {
Response res=	given()
	.when()
	.get("https://www.google.com/");
//	String headervalue =res.getHeader("Content-Type");//single header
//	System.out.println("header value is:"+headervalue);

Headers  hd=res.getHeaders();
for(Header h:hd) {
	System.out.println(h.getName()+"      "+h.getValue());
}
}}