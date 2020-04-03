package com.app.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class WarmUp {

    @Test
    public void warmUp(){

       // get(url) is sending a get request
        Response response=RestAssured.get("https://api.got.show/api/show/animals/");
        response.prettyPrint();

        String responseAsString=response.asString();
        Assert.assertTrue(responseAsString.contains("habitat"));

        int actualStatusCode=response.statusCode();
        Assert.assertEquals(200, actualStatusCode);

    }
}
