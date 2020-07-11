package com.restassured.get;


import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;



public class DeleteReq {
	
	static int empid= 719;
	
	@Test
	public void getEmployeeData()
	{
		
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/update/"+ empid;
		
		given()
		.when()
			.delete()
		.then()
			.statusCode(200);
		
	}

}
