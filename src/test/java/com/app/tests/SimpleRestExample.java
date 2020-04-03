package com.app.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class SimpleRestExample {

    @Test
    public void test1() {
        //RestAssured library will prepare and set the url
        Response response = RestAssured.get("https://uinames.com/api/");

        //to print the response
        response.prettyPrint();

        //asString-->will convert our object into String
        String responseAsString = response.asString();

        Assert.assertTrue(responseAsString.contains("name"));
        Assert.assertTrue(responseAsString.contains("surname"));

        int actualStatusCode = response.statusCode();
        Assert.assertEquals(200, actualStatusCode);
    }

    @Test
    public void headersTest() {

        Response response = RestAssured.get("https://uinames.com/api/");

        String actualContentType = response.contentType();

        System.out.println(actualContentType);

        Assert.assertEquals("application/json; charset=utf-8", actualContentType);

    }

    @Test
    public void statusLineTest() {

        Response response = RestAssured.get("https://uinames.com/api/");

        String statusLine=response.statusLine();
        String statusLine2=response.getStatusLine();
        System.out.println(statusLine);
        System.out.println(statusLine2);

        Assert.assertTrue(statusLine.contains("200"));
        Assert.assertTrue(statusLine.contains("OK"));

    }

}
