package com.example.pets.tests.base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import com.example.pets.api.PetApi;
import com.example.pets.utils.PetUtils;

@Listeners({io.qameta.allure.testng.AllureTestNg.class}) // Enable Allure Reporting
public class BaseTest {

    protected PetApi petApi;
    protected PetUtils petUtils;

    @BeforeMethod
    public void setUp() {
        // Initialize the PetApi for reuse in tests
        petApi = new PetApi();

        // Initialize PetUtils if you need to create random pets for tests
        petUtils = new PetUtils();

        // RestAssured configuration (common settings for all tests)
        RestAssured.baseURI = "https://petstore3.swagger.io/api/v3";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @AfterMethod
    public void tearDown() {
        // Clean up if necessary after each test
        System.out.println("Test completed.");
    }

    // You can add utility methods for logging or any other common functionality here
}
