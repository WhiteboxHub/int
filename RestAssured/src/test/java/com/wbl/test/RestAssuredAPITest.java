package com.wbl.test;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import com.wbl.base.BaseAPITest;



public class RestAssuredAPITest extends BaseAPITest {
	
	
	//String Endpoint=endpoint;
	
	int post_subjectid=0;
	
	
	//Json Object under the Json Array-----------
	
	// 
	@Test(priority=1)
	public void get()
	{
		
		given().when().get(endpoint).then().statusCode(200)
		.body("[1].id",equalTo(3))
		.body("[1].name",equalTo("Python"));
		System.out.println("========="+given().when().get("https://api.qa.talentscreen.io/v1/subjects/").asString());		
	}
		
	
	
	
@Test(priority=2)
	public void get2()
	{
		Response response;
		response=
		given().when().get(endpoint+"/5").then().statusCode(200).extract().response();
		Assert.assertEquals( response.path("name"), "Scala");
		int id = response.path("id");
		System.out.println("get 2====="+id);
		
		System.out.println("========="+given().when().get("https://api.qa.talentscreen.io/v1/subjects/168").asString());		
		
	}
	
	

	
	@Test(priority=3)
	  public void postString () {
	    
		Response response;
		response=
	    given().contentType (ContentType.JSON).body ("{\"categoryid\":\"1\","
	    	    +"\"name\":\"Hello Rest9.5\","
	    	    +"\"icon_class\":\"RESTASSURED1\"}")
	    .when ()
	  
	    .post (endpoint+"?authentication=false").then().statusCode(201).extract().response();
		
		
		//int id=response.then().extract().jsonPath().param("id", id);
		post_subjectid = response.path("id");
		
		System.out.println("-------"+post_subjectid);
		
		
		
		String jsonAsStatuscode = response.body().asString();
		
		
		System.out.println("response "+jsonAsStatuscode);
		Assert.assertEquals( response.path("categoryid"), "1");
		
	      
	  }
	
	
	
	@Test(priority=4,dependsOnMethods="postString")
	  public void putString () {
	    
		 Response response;
		response=
	    given().contentType (ContentType.JSON).body ("{\"categoryid\":\"1\","
	    	    +"\"name\":\"Hello Rest3_Renameed\","
	    	    +"\"icon_class\":\"RESTASSURED1\"}")
	    .when ()
	  
	    .put (endpoint+"/"+post_subjectid+"?authentication=false").then().statusCode(200).extract().response();
		String jsonAsStatuscode = response.body().asString();
		System.out.println("response "+jsonAsStatuscode);
		//Assert.assertEquals( response.path("status message"), "OK");
		
	      
	  }
	
	
	@Test(priority=5,dependsOnMethods="postString")
	  public void DeleteString () {
	    
		Response response;
		response=
	    given().contentType (ContentType.JSON).body ("")
	    .when ()
	  
	    .delete(endpoint+"/"+post_subjectid+"?authentication=false").then().statusCode(204).extract().response();
		String jsonAsStatuscode = response.body().asString();
		System.out.println("response "+jsonAsStatuscode);
		System.out.println("for delete---"+response.getStatusCode());
		//Assert.assertEquals( response.path("status message"), "OK");
		
	      
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	
	@Test
    public void aCarGoesIntoTheGarage() {
		String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1OTFhZjIyMTVhMTlhMjM1NGNlMTZjYWMiLCJsYXN0bW9kZGF0ZXRpbWUiOiIyMDE3LTEwLTA5VDA1OjI3OjU1LjU1MloiLCJfX3YiOjAsImxhc3Rtb2R1c2VyaWQiOiI1OTFhZjIyMTVhMTlhMjM1NGNlMTZjYWMiLCJhdXRoX2RldGFpbHMiOnsicmVnaXN0ZXJlZGRhdGV0aW1lIjoiMjAxNy0wNS0xNlQxMjozNTo0NS4wMDBaIiwibGFzdF92ZXJpZmljYXRpb25fY29kZSI6ImM2bnFoMzNxIiwiZmlyc3RfbG9naW5fY29tcGxldGVkIjoiWSIsImlzX3VzZXJfdmVyaWZpZWQiOiJZIiwiaXNfc3VwZXIiOnRydWV9LCJlbXBsb3llcl9kZXRhaWxzIjp7ImpvYl90aXRsZSI6IkVuZ2luZWVyaW5nIE1hbmFnZXIiLCJjb21wYW55X3NpemUiOiI1MDAwKyIsImNvdW50cnlfbmFtZSI6IlVuaXRlZCBTdGF0ZXMiLCJjb21wYW55X25hbWUiOiJHb29nbGUifSwic291cmNlX2RldGFpbHMiOnsidXNlcm5hbWUiOiJrdW1hckB3aGl0ZWJveC1sZWFybmluZy5jb20iLCJwYXNzd29yZCI6IjE2YTIxNzRhYTAwOTkwNDdhYWVmZDYzODUzNTE2ZDdjIiwic291cmNlIjoidGFsZW50c2NyZWVuIn0sInVzZXJfcHJvZmlsZSI6eyJlbWFpbCI6Imt1bWFyQHdoaXRlYm94LWxlYXJuaW5nLmNvbSIsIm5hbWUiOiJLdW1hciB2ZWx1cHVsYSIsInBob25lIjoiKzE5MjU0MjQ3NDExIn0sInJvbGUiOiJlbXBsb3llZSIsImlhdCI6MTUxMzAxMzkxOSwiZXhwIjoxNTE2NjEzOTE5fQ.A7bJs-l6h1cngrdGPd9c-seEm3bYwAFJelM_5DURh3k";
        Map<String,String> car = new HashMap<>();
        car.put("name", "C# ................5");
        car.put("icon_class", "C# ................5");
       Response response;
       response=given()
        .contentType("application/json")
        .body(car)
        .when().post("https://api.qa.talentscreen.io/v1/subjects?authentication=false").then()
        .statusCode(201).extract().response();
       System.out.println("response--" +response.asString());
    }
	*/

	
	
	
/*	@Test
	  public void putString () {
	    
		Response response;
		response=
	    given().body ("{\"categoryid\":\"1\","
	    +"\"name\":\"Hello_RESTASSURED25\","
	    +"\"icon_class\":\"RESTASSURED1\","
	    +"\"template\":\"RESTASSURED1\","
	    +"\"codemirror_theme\":\"StaffWriter\","
	    +"\"description\":\"StaffWriter-------rest\","
	    +"}")
	    .when ()
	    .contentType (ContentType.JSON)
	    .post ("https://api.qa.talentscreen.io/v1/subjects/").then().statusCode(200).extract().response();
		int jsonAsStatuscode = response.statusCode();
		System.out.println("----------response "+jsonAsStatuscode);
	      
	  }*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@Test
	public void get()
	{
		
		given().when().get("https://api.qa.talentscreen.io/v1/subjects").  then().
        contentType(ContentType.JSON).  // check that the content type return from the API is JSON
    extract().response(); // extract the response

// We convert the JSON response to a string, and save it in a variable called 'jsonAsString'
jsonAs
		
		
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
