package APITesting;


import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API {

	@Test(enabled=false)
	public void getResponseCode() {
		//Response resp= RestAssured.get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b5e88fa7972254124");
	Response resp= RestAssured.get("http://localhost:3000/posts");
                     int code=resp.getStatusCode();
				String data=resp.toString();
				String s=resp.getBody().asString();
				System.out.println("status code is "+ code);
				System.out.println("body  is "+ data);
				System.out.println("body formatted "+s);
				Assert.assertEquals(code, 200);
	}
	
	@Test(enabled=false)
	public void deleteResponseCode() {
		//Response resp= RestAssured.get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b5e88fa7972254124");

		RequestSpecification r=RestAssured.given();
		Response resp= r.delete("http://localhost:3000/posts/john Watson");
                     int code=resp.getStatusCode();
				String s=resp.getBody().asString();
				System.out.println("status code is "+ code);
				System.out.println("body formatted "+s);
				//Assert.assertEquals(code, 200);
	}

	@Test(enabled=true)
	public void putMethod() {
		RequestSpecification r=RestAssured.given();
		r.header("Content-Type","application/json");
		JSONObject json=new JSONObject();
		json.put("id", "555555589");
		json.put("name", "Sherlock");
		json.put("designation", "Team lead");
		 r.body(json.toJSONString());
		 
			Response resp= r.put("http://localhost:3000/posts/555555589");
			int code=resp.getStatusCode();
			String data=resp.getBody().asString();
			System.out.println("status code is "+ code);
			System.out.println("body  is "+ data);


	}

@Test(enabled=false)
public void postMethod() {
	RequestSpecification r=RestAssured.given();
	r.header("Content-Type","application/json");
	JSONObject json=new JSONObject();
	json.put("id", "555555589");
	json.put("name", "Nikhil");
	json.put("designation", "Team lead");
	 r.body(json.toJSONString());
	 
		Response resp= r.post("http://localhost:3000/posts/");
		int code=resp.getStatusCode();
		String data=resp.getBody().asString();
		System.out.println("status code is "+ code);
		System.out.println("body  is "+ data);


}


}
