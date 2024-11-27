/*
package com.example.pets.tests;

import com.example.pets.models.Pet;
import com.example.pets.api.PetApi;
import com.example.pets.utils.PetUtils;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Epic("Pet Store API Tests")
@Feature("Pet Management")
public class PetTests234 {

    private static final Logger logger = LoggerFactory.getLogger(PetTests234.class);

    private PetApi petApi;
    private Pet newPet;

    @BeforeClass
    public void setup() {
        petApi = new PetApi();
    }

    @BeforeMethod
    public void beforeEach() {
        newPet = createRandomPetForTest();
    }

    @Test(description = "Test creating a new pet and retrieving it")
    @Description("This test creates a new pet and verifies it can be retrieved successfully.")
    public void testCreateAndRetrievePet() {
        Pet createdPet = createAndVerifyPet();
        retrieveAndVerifyPet(createdPet);
    }

    @Test(description = "Test updating an existing pet")
    @Description("This test updates the name of an existing pet and verifies the change.")
    public void testUpdatePet() {
        String updatedName = "UpdatedName";
        updateAndVerifyPet(newPet, updatedName);
    }

    @Test(description = "Test deleting an existing pet")
    @Description("This test deletes a pet and verifies that it no longer exists.")
    public void testDeletePet() {
        deleteAndVerifyPet(newPet);
    }

    @Step("Create a random pet for testing")
    private Pet createRandomPetForTest() {
        logger.info("Creating a random pet for test setup...");
        Pet pet = PetUtils.createRandomPet();
        Response response = petApi.createPet(pet);
        assertEquals(response.getStatusCode(), 200, "Failed to create a pet during setup.");
        logger.info("Random pet created with ID: {}", pet.getId());
        return pet;
    }

    @Step("Create and verify a new pet")
    private Pet createAndVerifyPet() {
        logger.info("Starting the process of creating a new pet...");
        Pet pet = PetUtils.createRandomPet();
        Response response = petApi.createPet(pet);
        assertEquals(response.getStatusCode(), 200, "Pet creation failed.");
        logger.info("Pet created successfully with ID: {}", pet.getId());
        return pet;
    }

    @Step("Retrieve and verify the pet with ID: {pet.id}")
    private void retrieveAndVerifyPet(Pet pet) {
        logger.info("Retrieving pet with ID: {}", pet.getId());
        Response response = petApi.getPetById(pet.getId());
        assertEquals(response.getStatusCode(), 200, "Failed to retrieve the pet.");
        Pet retrievedPet = response.as(Pet.class);
        assertEquals(retrievedPet.getId(), pet.getId(), "Pet ID mismatch.");
        assertEquals(retrievedPet.getName(), pet.getName(), "Pet name mismatch.");
        logger.info("Pet retrieved and verified successfully: {}", retrievedPet.getName());
    }

    @Step("Update and verify the pet's name")
    private void updateAndVerifyPet(Pet pet, String newName) {
        logger.info("Updating pet with ID: {} to new name: {}", pet.getId(), newName);
        pet.setName(newName);
        Response response = petApi.updatePet(pet);
        assertEquals(response.getStatusCode(), 200, "Failed to update the pet.");
        Response getResponse = petApi.getPetById(pet.getId());
        Pet updatedPet = getResponse.as(Pet.class);
        assertEquals(updatedPet.getName(), newName, "Pet name was not updated.");
        logger.info("Pet updated successfully. New name: {}", updatedPet.getName());
    }

    @Step("Delete and verify the pet with ID: {pet.id}")
    private void deleteAndVerifyPet(Pet pet) {
        logger.info("Deleting pet with ID: {}", pet.getId());
        Response deleteResponse = petApi.deletePet(pet.getId());
        assertEquals(deleteResponse.getStatusCode(), 200, "Failed to delete the pet.");
        Response getResponse = petApi.getPetById(pet.getId());
        assertEquals(getResponse.getStatusCode(), 404, "Deleted pet still exists.");
        logger.info("Pet deleted successfully and verified as non-existent.");
    }
}
*/