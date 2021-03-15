package com.petstore.tests;

import ObjectModel.UserPojo;
import com.jayway.jsonpath.JsonPath;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import javafx.scene.chart.ValueAxis;
import org.junit.jupiter.api.*;

import javax.print.DocFlavor;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTest extends TestBase
{
    UserPojo user = new UserPojo();
    UserTest()
    {
        super.TestBase("/user");
    }

    @Feature("User endpoint")
    @Story("Fetching details of a user by its username")
    @Test
    @DisplayName("Fetch user details by username")
    public void getUserByUsername()
    {
        response =
                given()
                .when()
                .get(createdUserName);

        response.prettyPrint();
        validatableResponse=
                response
                .then()
                .statusCode(200);
    }

    @Feature("User endpoint")
    @Story("Creating a new user")
    @Test
    @Order(1)
    @DisplayName("Create a new user")
    public void createAUser()
    {
       user.setId(fake.number().randomDigitNotZero());
       user.setUsername(fake.name().username());
       user.setFirstName(fake.name().firstName());
       user.setLastName(fake.name().lastName());
       user.setEmail(fake.internet().emailAddress());
       user.setPassword(fake.internet().password());
       user.setPhone(fake.phoneNumber().phoneNumber());
       user.setUserStatus("1");

       response =
                 given()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body(user)
                .post();

        validatableResponse =
                response
                .then()
                .statusCode(200);

        String responseString = response.asString();

        createdUserName = JsonPath.read(responseString,"$.username");
        createdUerPassword = JsonPath.read(responseString,"$.password");
        createdUserName = "/"+createdUserName;
    }

    @Feature("User endpoint")
    @Story("Log user into the system")
    @Test
    @Order(2)
    @DisplayName("Log the user into the system")
    public void LoginTheUser()
    {
        super.TestBase("/user/login");

        response =
                given()
                .when()
                .queryParam("username",createdUserName)
                .queryParam("password",createdUerPassword)
                .get();

        response.prettyPrint();
        validatableResponse =
                response
                .then()
                .statusCode(200);
    }

    @Feature("User endpoint")
    @Story("Logs out current active session")
    @Test
    @Order(3)
    @DisplayName("Log out the current active session")
    public void LogOutTheActiveUserSession()
    {
        super.TestBase("/user/logout");

        response =
                given()
                .when()
                .get();

        response.prettyPrint();

        validatableResponse =
                response
                .then()
                .statusCode(200);

    }
}
