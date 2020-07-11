package com.restassured.get;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;

public class UpdateRequest {
	public static ReadWriteExcel readExcel=new ReadWriteExcel();	
	public static HashMap map= new HashMap();
	static int empid= 719;
	
	@BeforeClass
	public static void postdata() throws Exception
	{
		readExcel.readPath();
		System.out.println("First value: "+readExcel.getStringData(0,1,3));
		System.out.println("First value: "+readExcel.getStringData(0,1,4));
		System.out.println("First value: "+readExcel.getStringData(0,1,5));
		map.put("name",readExcel.getStringData(0,1,3));
		map.put("salary",readExcel.getStringData(0,1,4));
		map.put("age",readExcel.getStringData(0,1,5));
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/update/"+ empid;
		
		
	}
	@Test
	public void testdata()
	{
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.post()
		.then()
			.statusCode(200)
			.and()
			.body("status", equalTo("success"));

	}

}
