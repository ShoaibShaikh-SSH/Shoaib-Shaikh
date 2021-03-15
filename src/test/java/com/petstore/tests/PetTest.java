package com.petstore.tests;

import static io.restassured.RestAssured.*;

import ObjectModel.PetPojo;
import com.github.javafaker.Faker;
import com.jayway.jsonpath.JsonPath;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetTest extends TestBase
{
    PetTest()
    {
        super.TestBase("/pet");
    }

    public static PetPojo pet = new PetPojo();

    @Story("Fetching all pets by given status")
    @Feature("Pet endpoint")
    @Test
    @DisplayName("Fetch all pets by statuses")
    public void getPetsByStatus()
    {
        response =
                given()
                        .queryParam("status","available")
                    .when()
                        .get("/findByStatus");

        response.prettyPrint();

        validatableResponse =
                response
                .then()
                .statusCode(200);
    }

    @Story("Creating new pet")
    @Feature("Pet endpoint")
    @Test
    @Order(1)
    @DisplayName("Create a new pet")
    public void createPet()
    {
        HashMap<String,String> categoryMap = new HashMap<String, String>();
        categoryMap.put("id","1");
        categoryMap.put("name","Dogs");

        ArrayList<String> photoUrlList = new ArrayList<String>();
        photoUrlList.add("dummyPhotoURL");

        HashMap<String,String> tag = new HashMap<String, String>();
        tag.put("id","0");
        tag.put("name","dummyTagNAme");

        ArrayList<HashMap<String,String>> tags = new ArrayList<HashMap<String,String>>();
        tags.add(tag);

        pet.setId(fake.number().digit());
        pet.setName(fake.name().firstName());
        pet.setCategory(categoryMap);
        pet.setPhotoUrls(photoUrlList);
        pet.setTags(tags);
        pet.setStatus("available");

        response =
                 given()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body(pet)
                .post();

        validatableResponse =
                response
                .then()
                .statusCode(200);

        String responseString = response.asString();

       createdPetID = JsonPath.read(responseString,"$.id");
       createdPetIDString = "/"+ String.valueOf(createdPetID);
       pet=null;
    }

    @Story("Pet-Finding by given id")
    @Feature("Pet endpoint")
    @Test
    @DisplayName("Finding pet by given id")
    public void findPetByID()
    {
        response =
                given()
                .when()
                .get(createdPetIDString);

        response.prettyPrint();

        validatableResponse =
                response
                .then()
                .statusCode(200);
    }

    @Story("Pet-update pet by given id")
    @Feature("Pet endpoint")
    @Test
    @DisplayName("updating pet by given id")
    public void updateExistingPet()
    {
        pet = new PetPojo();
        HashMap<String,String> categoryMap = new HashMap<String, String>();
        categoryMap.put("id","1");
        categoryMap.put("name","Dogs");

        ArrayList<String> photoUrlList = new ArrayList<String>();
        photoUrlList.add("dummyPhotoURL");

        HashMap<String,String> tag = new HashMap<String, String>();
        tag.put("id","0");
        tag.put("name","dummyTagNAme");

        ArrayList<HashMap<String,String>> tags = new ArrayList<HashMap<String,String>>();
        tags.add(tag);

        pet.setId(String.valueOf(createdPetID));
        pet.setName(fake.name().firstName()+"Updated");
        pet.setCategory(categoryMap);
        pet.setPhotoUrls(photoUrlList);
        pet.setTags(tags);
        pet.setStatus("available");

        response =
                given()
                        .when()
                        .contentType(ContentType.JSON)
                        .when()
                        .body(pet)
                        .put();

        response.prettyPrint();

        validatableResponse =
                response
                .then()
                .statusCode(200);
        pet=null;
    }

    @Story("Update pet in store with form data")
    @Feature("Pet endpoint")
    @Test
    @DisplayName("updating pet by form data")
    public void updateExistingPetWithFormData()
    {
        pet = new PetPojo();
        HashMap<String,String> categoryMap = new HashMap<String, String>();
        categoryMap.put("id","1");
        categoryMap.put("name","Dogs");

        ArrayList<String> photoUrlList = new ArrayList<String>();
        photoUrlList.add("dummyPhotoURL");

        HashMap<String,String> tag = new HashMap<String, String>();
        tag.put("id","0");
        tag.put("name","dummyTagNAme");

        ArrayList<HashMap<String,String>> tags = new ArrayList<HashMap<String,String>>();
        tags.add(tag);

        pet.setId(String.valueOf(createdPetID));
        pet.setName("Updated"+fake.name().firstName());
        pet.setCategory(categoryMap);
        pet.setPhotoUrls(photoUrlList);
        pet.setTags(tags);
        pet.setStatus("available");

        response =
                given()
                        .when()
                        .contentType(ContentType.JSON)
                        .when()
                        .body(pet)
                        .post();

        validatableResponse =
                response
                .then()
                .statusCode(200);

        response.prettyPrint();
    }
}
