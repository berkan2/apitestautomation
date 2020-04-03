package com.app.tests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PathParamExample {

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI="https://api.got.show";
    }

    @Test
    public void getAnimalByHabitat(){
        //given() will prepare our request
       // given().pathParam("habitat","Jungles").when().get("/api/show/animals/byHabitat/{habitat}").prettyPrint();

        given().
                //setting the path parameter
                pathParam("habitat", "Jungles").
                //sending the request
                when().
                //get() request
                get("/api/show/animals/byHabitat/{habitat}").
                //printing your response
                prettyPrint();
    }

    @Test
    public void getAnimalByName(){

        given().
                pathParam("name","Manticores").
                when().
                get("/api/show/animals/{name}").prettyPrint();

    }


}
