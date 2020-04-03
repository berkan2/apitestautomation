package com.app.tests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class QueryParamExample {

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI="https://uinames.com/api/";
    }

    @Test
    public void uiNamesbyAmount(){
        given().
                queryParam("amount","3").
                when().
                get().prettyPrint();
    }

    @Test
    public void uiNamesbyRegion(){

        given().
                queryParam("region","England").
                when().
                get().
                prettyPrint();
    }

    @Test
    public void uiNamesbyAmountRegion(){

        given().
                queryParam("amount","5").
                queryParam("region", "France").
                when().
                get().
                prettyPrint();
    }

    @Test
    public void uiNamesByAmountGenderRegion(){

        given().
                queryParam("amount","5").
                queryParam("region", "France").
                queryParam("gender", "female").
                when().
                get().prettyPrint();
    }


}
