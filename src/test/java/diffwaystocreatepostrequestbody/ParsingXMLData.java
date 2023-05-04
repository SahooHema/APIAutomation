package diffwaystocreatepostrequestbody;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.path.xml.XmlPath;
public class ParsingXMLData {
	
	//@Test(priority=1)
	public void testXmlRespone() {
		
//Approach1
		given()
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1")
		.then()
		.statusCode(200)
		.header("Content-Type", "application/xml; charset=utf-8")
		.body("TravelerinformationResponse.page",equalTo("1"))
		.body("TravelerinformationResponse.travelers.Travelerinformation[0].name",equalTo("Developer"));
		
//Approach2
	Response res=	given()
			.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1");
	Assert.assertEquals(res.getStatusCode(),200);
	Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
	String page=res.xmlPath().get("TravelerinformationResponse.page").toString();
	Assert.assertEquals(page,"1");	
	}

	
	@Test
	public void testXMLResponseData() {
	
		Response res=	given()
				.when()
				.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		 XmlPath xmlPath = new XmlPath(res.asString())	;
	//total number of travelers	
 List<String> travellers= xmlPath.getList("TravelerinformationResponse.travelers.Travelerinformation");
		Assert.assertEquals(travellers.size(), 10);
	//verify traveler name is present in response
List<String> traveller_names= xmlPath.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
boolean status=false;
		for(String names:traveller_names) {
			if(names.equals("Ashor")) {
				status=true;
				break;
			}
		}
		Assert.assertEquals(status, true);
	}
}
/*
 toString():- when convert data(TravelerinformationResponse.page) into string then use toString().
 asString():- when convert whole response into string then use asString().
 parsing:- traversing the xml response and  extract the data from response compare with expected value
 */
