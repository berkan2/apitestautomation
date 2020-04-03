package com.app.tests.Pojos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.Test;

public class PojosExamples {

    @Test
    public void test(){

        //serialization example
        Person person=new Person();
        person.setName("Jake");
        person.setSurname("OConnor");
        person.setGender("male");
        person.setRegion("United States");

        System.out.println("printing person java object: "+person);

        Gson gson =new Gson();

        String json=gson.toJson(person);
        System.out.println("printing json object: "+json);

        //deserialization
        //taking json object and converting into java object

        String myJsonString="{\"name\":\"Maria\"," +
                            "\"surname\":\"OConnor\"," +
                            "\"gender\":\"female\"," +
                            "\"region\":\"United States\"}";

        Person myPerson=gson.fromJson(myJsonString,Person.class);
        System.out.println("printing new person java object: "+myPerson);
    }

    @Test
    public void test2() throws JsonProcessingException {
        //jacksondatabind example with ObjectMapper
        //serialization example
        Person person=new Person();
        person.setName("Jake");
        person.setSurname("OConnor");
        person.setGender("male");
        person.setRegion("United States");

        System.out.println("printing person java object: "+person);
        //converting java object into json
        ObjectMapper objectMapper=new ObjectMapper();
        String json=objectMapper.writeValueAsString(person);
        System.out.println("printing my json string: "+json);

        //deserialization-->converting json object into java
        String myJsonString="{\"name\":\"Jake\"," +
                            "\"surname\":\"OConnor\"," +
                            "\"gender\":\"male\"," +
                            "\"region\":\"United States\"}";
        Person myPerson=objectMapper.readValue(myJsonString,Person.class);
        System.out.println("printing java person object: "+myPerson);

    }
}
