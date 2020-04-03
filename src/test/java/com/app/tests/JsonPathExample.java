package com.app.tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

public class JsonPathExample {

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI="https://petstore.swagger.io/v2/";
    }

    @Test
    public void test(){

        Response response= RestAssured.given().pathParam("orderId","2").
                                        get("store/order/{orderId}");

        response.then().log().all().assertThat().statusCode(200);
/*
{
    "id": 2,
    "petId": 6,
    "quantity": 1,
    "shipDate": "2019-12-12T22:05:28.788+0000",
    "status": "placed",
    "complete": true
}
 */
        JsonPath jsonPath=response.jsonPath();
        int id=jsonPath.get("id");
        System.out.println("printing pet order id "+id);

        String shipDate=jsonPath.get("shipDate");
        System.out.println("printing ship date : "+shipDate);



    }
}
