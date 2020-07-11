package com.restassured.get;

import org.testng.annotations.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo_GetRequest {
	
	public static String URL = "http://dummy.restapiexample.com/api/v1/employees";
	@Test
	public void getEmployeeData()
	{
		given()
		.when()
			.get(URL)
		.then()
			.statusCode(200)
			.assertThat().body("status", equalTo("success"))
			.header("Content-Type", "application/json;charset=utf-8")
			;
		
	}

}
