/*
package com.example.pets.api;

import com.example.pets.models.Pet;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PetApi {

    private static final String BASE_URL = "https://petstore3.swagger.io/api/v3";

    public PetApi() {
        RestAssured.baseURI = BASE_URL;
    }

    public Response createPet(Pet pet) {
        return given()
                .contentType("application/json")
                .body(pet)
                .post("/pet");
    }

    public Response getPetById(long petId) {
        return given()
                .get("/pet/" + petId);
    }

    public Response updatePet(Pet pet) {
        return given()
                .contentType("application/json")
                .body(pet)
                .put("/pet");
    }

    public Response deletePet(long petId) {
        return given()
                .delete("/pet/" + petId);
    }
}
*/
package com.example.pets.api;

import com.example.pets.models.Pet;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class PetApi {

    private static final String BASE_URL = "https://petstore3.swagger.io/api/v3";

    public PetApi() {
        RestAssured.baseURI = BASE_URL;
    }

    // Reusable request spec
    private static io.restassured.specification.RequestSpecification requestSpec() {
        return RestAssured.given().contentType("application/json");
    }

    public Response createPet(Pet pet) {
        return requestSpec()
                .filter(new AllureRestAssured())
                .body(pet)
                .post("/pet")
                .then()
                .log().ifError() // Log errors for debugging
                .extract()
                .response();
    }

    public Response getPetById(long petId) {
        return requestSpec()
                .filter(new AllureRestAssured())
                .pathParam("id", petId)
                .get("/pet/{id}")
                .then()
                .log().ifError()
                .extract()
                .response();
    }

    public Response updatePet(Pet pet) {
        return requestSpec()
                .filter(new AllureRestAssured())
                .body(pet)
                .put("/pet")
                .then()
                .log().ifError()
                .extract()
                .response();
    }

    public Response deletePet(long petId) {
        return requestSpec()
                .filter(new AllureRestAssured())
                .pathParam("id", petId)
                .delete("/pet/{id}")
                .then()
                .log().ifError()
                .extract()
                .response();
    }
}
