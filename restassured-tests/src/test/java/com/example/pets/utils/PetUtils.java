/*
package com.example.pets.utils;

import com.example.pets.models.Pet;

public class PetUtils {

    public static Pet createRandomPet() {
        Pet pet = new Pet();
        pet.setId(System.currentTimeMillis()); // Use timestamp as a unique ID
        pet.setName("Pet-" + pet.getId());
        pet.setStatus("available");
        return pet;
    }
}
*/
package com.example.pets.utils;
import com.example.pets.models.Pet;
import java.util.Collections;
import java.util.List;

public class PetUtils {

    public static Pet createRandomPet() {
        return new Pet.Builder()
                .id(System.currentTimeMillis())
                .name("Pet-" + System.currentTimeMillis())
                .status("available")
                .photoUrls(Collections.singletonList("http://example.com/photo.jpg"))
                .tags(List.of())
                .build();
    }

}

