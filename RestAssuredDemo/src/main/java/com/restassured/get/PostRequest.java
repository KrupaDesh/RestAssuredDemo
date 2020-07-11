package com.restassured.get;

import java.util.HashMap;

import io.restassured.RestAssured;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostRequest {
	
	public static ReadWriteExcel readExcel=new ReadWriteExcel();	
	public static HashMap map= new HashMap();
	
/*	@BeforeClass
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
		RestAssured.basePath="/create";
		
	}*/
	@Test(dataProvider = "userData")// using data provider we can execute this test as many times. We can 0 add 10K data in excel.
	public void testdata(String name,String salary, String age) throws Exception
	{
		
		readExcel.readPath();
		System.out.println("First value: "+readExcel.getStringData(0,1,3));
		System.out.println("First value: "+readExcel.getStringData(0,1,4));
		System.out.println("First value: "+readExcel.getStringData(0,1,5));
		map.put("name",name);
		map.put("salary",salary);
		map.put("age",age);
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/create";
		
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
	 @DataProvider(name="userData")
	    public Object[][] userFormData() throws Exception
	    {
	        Object[][] data = readExcel.gettestData();
	        return data;
	    }
}
