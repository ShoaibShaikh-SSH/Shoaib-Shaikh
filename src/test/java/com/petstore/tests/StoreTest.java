package com.petstore.tests;

import ObjectModel.StorePojo;
import com.jayway.jsonpath.JsonPath;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StoreTest extends TestBase
{
    StorePojo store = new StorePojo();

    StoreTest() { super.TestBase("/store"); }

    @Feature("Stores endpoint")
    @Story("Fetching all orders from inventory by given status")
    @Test
    @DisplayName("Fetch the inventory status")
    public void getInventoryStatus()
    {
        response =
                given()
                .when()
                .get("/inventory");
        response.prettyPrint();

        validatableResponse=
                response
                .then()
                .statusCode(200);
    }

    @Feature("Stores endpoint")
    @Story("Place a new order")
    @Test
    @Order(1)
    @DisplayName("Place a new order")
    public void placeAnOrder()
    {
        super.TestBase("/store/order");

        store.setId(fake.number().numberBetween(12,999));
        store.setPetID(fake.idNumber().valid());
        store.setQuantity(fake.number().randomDigit());
        store.setShipDate("2021-03-14T12:39:37.622Z");
        store.setStatus("approved");
        store.setComplete(fake.bool().bool());

        response=
        given()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body(store)
                .post();

        response.prettyPrint();

        validatableResponse =
                response
                .then()
                .statusCode(200);

        String responseString = response.asString();

        createdOrderID = JsonPath.read(responseString,"$.id");
        createdOrderIDString = "/"+ String.valueOf(createdOrderID);
    }

    @Feature("Stores endpoint")
    @Story("Fetching the order by given ID")
    @Test
    @Order(2)
    @DisplayName("Fetch the given order by ID")
    public void getOrderByID()
    {
        super.TestBase("/store/order");

        Response response =
                given()
                .when()
                .get(createdOrderIDString);
        response.prettyPrint();

        validatableResponse=
                response
                .then()
                .statusCode(200);
    }

    @Feature("Stores endpoint")
    @Story("Delete the order created as part of previous test")
    @Test
    @Order(3)
    @DisplayName("Delete an newly created order")
    public void DeleteTheCreatedOrder()
    {

        super.TestBase("/store/order");

        Response response =
                given()
                .when()
                .delete(createdOrderIDString);

        response.prettyPrint();

        ValidatableResponse validatableResponse =
                response
                .then()
                .statusCode(200);
    }


}
