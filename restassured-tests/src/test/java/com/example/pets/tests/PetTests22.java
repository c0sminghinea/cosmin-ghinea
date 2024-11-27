/*
package com.example.pets.tests;
import com.example.pets.models.Pet;
import com.example.pets.api.PetApi;
import com.example.pets.utils.PetUtils;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

import static org.testng.Assert.assertEquals;

@Epic("Pet Store API Tests")
@Feature("Pet Management")
public class PetTests22 {

    private PetApi petApi;
    private Pet newPet;

    @BeforeClass
    public void setup() {
        petApi = new PetApi();
    }
    @BeforeMethod
    public void beforeEach() {
        newPet = PetUtils.createRandomPet();
        petApi.createPet(newPet);
    }

    @Test
    public void testCreateAndRetrievePet() {
        // Create a pet
        Pet onePet = PetUtils.createRandomPet();
        Response createResponse = petApi.createPet(onePet);
        assertEquals(createResponse.getStatusCode(), 200);

        // Retrieve the pet by ID
        Response getResponse = petApi.getPetById(onePet.getId());
        assertEquals(getResponse.getStatusCode(), 200);
        Pet retrievedPet = getResponse.as(Pet.class);
        assertEquals(retrievedPet.getId(), onePet.getId());
        assertEquals(retrievedPet.getName(), onePet.getName());
    }


    @Test
    @Description("Create a new pet and verify it can be retrieved successfully")
    public void testCreateAndRetrievePet() {
    // Arrange: Prepare test data
    Pet testPet = PetUtils.createRandomPet();

    // Act: Create a new pet
    Response createResponse = petApi.createPet(testPet);

    // Assert: Verify response and pet details
    assertEquals(createResponse.getStatusCode(), 200, "Pet creation failed!");
    Pet createdPet = createResponse.as(Pet.class);
    assertEquals(createdPet.getName(), testPet.getName(), "Pet name mismatch!");
    assertEquals(createdPet.getStatus(), testPet.getStatus(), "Pet status mismatch!");

    // Act: Retrieve the created pet
    Response getResponse = petApi.getPetById(createdPet.getId());

    // Assert: Verify retrieved pet details
    assertEquals(getResponse.getStatusCode(), 200, "Failed to retrieve pet!");
    Pet retrievedPet = getResponse.as(Pet.class);
    assertEquals(retrievedPet.getId(), createdPet.getId(), "Pet ID mismatch!");
}

    @Test
    @Description("Create a new pet and update it")
    public void testUpdatePet() {

        // Update the pet's name
        newPet.setName("UpdatedName");
        Response updateResponse = petApi.updatePet(newPet);
        assertEquals(updateResponse.getStatusCode(), 200);

        // Verify the updated name
        Response getResponse = petApi.getPetById(newPet.getId());
        Pet updatedPet = getResponse.as(Pet.class);
        assertEquals(updatedPet.getName(), "UpdatedName");
    }

    @Test
    public void testDeletePet() {

        // Delete the pet
        Response deleteResponse = petApi.deletePet(newPet.getId());
        assertEquals(deleteResponse.getStatusCode(), 200);

        // Verify the pet no longer exists
        Response getResponse = petApi.getPetById(newPet.getId());
        assertEquals(getResponse.getStatusCode(), 404, "Expected 404 Not Found for deleted pet.");

    }
}
*/
