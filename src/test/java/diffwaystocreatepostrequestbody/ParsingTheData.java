package diffwaystocreatepostrequestbody;
import static io.restassured.RestAssured.*;


import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.*;
import org.json.JSONObject;
import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class ParsingTheData {
	//1)Approach
//@Test(priority=1)
//		public void testJsonResponse() {
//		
//	   given()
//		.contentType(ContentType.JSON)
//		
//		.when()
//		.get("https://reqres.in/api/users/2")
//		
//		.then()
//	.statusCode(200)
// .header("Content-Type","application/json; charset=utf-8")
//	.body("data.last_name",equalTo("Weaver"));//without json reponse
//}
	
//2)Approach
@Test(priority=2)
public void testJsonResponseData() {
	Response response=  
			   given()
			.contentType(ContentType.JSON)
		
		.when()
		.get("https://reqres.in/api/users?page=2");
//Assert.assertEquals(res.getStatusCode(),200);
//Assert.assertEquals(res.header("content-Type"),"application/json; charset=utf-8");
//	String lastname= res.jsonPath().get("data.last_name").toString();
//	System.out.println(lastname);
//Assert.assertEquals(lastname, "Weaver");//with json response
/////////////////////////////////////////////////
JSONObject jo = new JSONObject(response.asString());//convert response to json object
//	for(int i=0;i<jo.getJSONArray("data").length();i++) {
//	String email=jo.getJSONArray("data").getJSONObject(i).get("email").toString();
//	System.out.println(email);//get all names in json response
/////////////////////////////////////////////////////////
//	boolean status=false;
//			for(int i=0;i<jo.getJSONArray("data").length();i++) {
//			String email=jo.getJSONArray("data").getJSONObject(i).get("email").toString();			
//			if(email.equals("byron.fields@reqres.in")) {
//				status=true;
//				break;
//			}
//	
//	}
//			Assert.assertEquals(status, true);
///////////////////////////////////////////////
double totalprice=0;
for(int i=0;i<jo.getJSONArray("book").length();i++) {
String price=jo.getJSONArray("book").getJSONObject(i).get("price").toString();
totalprice=totalprice+Double.parseDouble(price);
}
Assert.assertEquals(totalprice,53.92);
}
}
	
//Note: if email position changes then we cannot use first approach instead use second approach i.e. dynamic approach.
//now, if we want particular name in json response then use if condition...
//interview question:- how to parse data using JSONObject class..

//If response starts with JSON Array?
//JSONArray arr=new JSONArray(response.asString());
//String courses_data=arr.getJSONObject(0).getJSONArray("courses").get(1).toString();












