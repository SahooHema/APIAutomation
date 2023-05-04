package diffwaystocreatepostrequestbody;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.io.File;
import java.util.*;

public class UploadAndDownloadFiles {
	
	@Test(priority=1)
	public void fileUpload() {
		File myfile=new File("C:\\Users\\SUMIT\\AutomationProject\\File\\Test1.txt");
		given()
		.multiPart("file", myfile)
		.contentType("multipart/form-data")
		.when()
		.post("http://localhost:8080/uploadFile")
		.then()
		.statusCode(200)
		.body("fileName",equalTo("Test1.txt"))
		.log().all();
		
	}
	//@Test
	public void multipleFilesUpload() {
		File myfile1=new File("C:\\Users\\SUMIT\\AutomationProject\\File\\Test1.txt");
		File myfile2=new File("C:\\Users\\SUMIT\\AutomationProject\\File\\Test2.txt");
	//	File filearr[]= {myfile1,myfile2};
		given()
		.multiPart("files", myfile1)
		.multiPart("files",myfile2)
		.contentType("multipart/form-data")
		.when()
		.post("http://localhost:8080/uploadMultipleFiles")
		.then()
		.statusCode(200)
		.body("[0].fileName",equalTo( "Test1.txt"))
		.body("[1].fileName",equalTo( "Test2.txt"))
		.log().all();
	}
	
	@Test(priority=2)
	public void downloadFile() {
	     given()
		.when()
		.get("http://localhost:8080/downloadFile/Test1.txt")
	    .then()
	    .and().statusCode(200)
        .log().body();     
		
	}

}
/*
 download in ur system:-upload-file-restapi.jar-> open cmd-> go to file location->java -jar file-upload-RestAPI.jar->api will get started
 FileUpload:- post request->http://localhost:8080/uploadFile
 post->http://localhost:8080/uploadMultipleFiles
 Note: run api, it will create upload folder in "C" drive and file.txt under it

if there is array in response :- 
File myfile1=new File("C:\\Users\\SUMIT\\AutomationProject\\File\\Test1.txt");
File myfile2=new File("C:\\Users\\SUMIT\\AutomationProject\\File\\Test2.txt");
File filearr[]= {myfile1,myfile2};
.multiPart("files", filearr)
FileDownload:-





*/