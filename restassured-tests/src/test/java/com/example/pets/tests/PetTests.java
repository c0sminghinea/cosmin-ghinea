package com.example.pets.tests;

import com.example.pets.models.Pet;
import com.example.pets.utils.PetUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.example.pets.tests.base.BaseTest;
import io.restassured.response.Response;


public class PetTests extends BaseTest {

    @Test(description = "Test creating a new pet and retrieving it")
    public void testCreateAndGetPet() {
        // Step 1: Create a random pet using PetUtils
        Pet pet = PetUtils.createRandomPet();

        // Step 2: Create the pet via API
        Response createResponse = petApi.createPet(pet);
        Assert.assertEquals(createResponse.statusCode(), 200, "Pet creation failed");

        // Step 3: Retrieve the created pet by its ID
        Response getResponse = petApi.getPetById(pet.getId());
        Assert.assertEquals(getResponse.statusCode(), 200, "Failed to retrieve pet");

        // Step 4: Assert that the pet ID matches
        Long expectedPetId = pet.getId();
        Long actualPetId = getResponse.jsonPath().getLong("id");
        Assert.assertEquals(actualPetId, expectedPetId, "Pet ID mismatch");
    }

    @Test(description = "Test updating an existing pet")
    public void testUpdatePet() {
        // Step 1: Create a pet
        Pet pet = PetUtils.createRandomPet();
        Response createResponse = petApi.createPet(pet);
        Assert.assertEquals(createResponse.statusCode(), 200, "Pet creation failed");

        // Step 2: Update the pet's name
        pet.setName("UpdatedName");
        Response updateResponse = petApi.updatePet(pet);
        Assert.assertEquals(updateResponse.statusCode(), 200, "Pet update failed");

        // Step 3: Verify the updated name
        Response getResponse = petApi.getPetById(pet.getId());
        Assert.assertEquals(getResponse.jsonPath().getString("name"), "UpdatedName", "Pet name mismatch");
    }

    @Test(description = "Test deleting an existing pet")
    public void testDeletePet() {
        // Step 1: Create a pet
        Pet pet = PetUtils.createRandomPet();
        Response createResponse = petApi.createPet(pet);
        Assert.assertEquals(createResponse.statusCode(), 200, "Pet creation failed");

        // Step 2: Delete the pet
        Response deleteResponse = petApi.deletePet(pet.getId());
        Assert.assertEquals(deleteResponse.statusCode(), 200, "Pet deletion failed");

        // Step 3: Try retrieving the pet to confirm deletion
        Response getResponse = petApi.getPetById(pet.getId());

        // Suppress 404 logs
        if (getResponse.statusCode() == 404) {
            // Optionally log this, or do nothing to suppress
            System.out.println("Pet successfully deleted");
        } else {
            // Handle any other responses if needed
            Assert.fail("Expected 404, but got: " + getResponse.statusCode());
        }
    }

}

