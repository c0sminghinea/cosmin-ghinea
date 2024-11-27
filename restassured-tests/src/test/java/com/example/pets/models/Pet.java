/*
package com.example.pets.models;

import java.util.List;

public class Pet {
    private Long id;
    private String name;
    private String status;
    private List<String> photoUrls; // Add this
    private List<Tag> tags; // Add this, create a Tag class if necessary

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}

class Tag {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
*/
package com.example.pets.models;

import java.util.List;
public class Pet {
    private Long id;
    private String name;
    private String status;
    private List<Tag> tags;

    // Default constructor for easy instantiation
    public Pet() {}

    // Builder for easier test data creation
    public static class Builder {
        private final Pet pet;

        public Builder() {
            pet = new Pet();
        }

        public Builder id(Long id) {
            pet.setId(id);
            return this;
        }

        public Builder name(String name) {
            pet.setName(name);
            return this;
        }

        public Builder status(String status) {
            pet.setStatus(status);
            return this;
        }

        public Builder photoUrls(List<String> photoUrls) {
            pet.setPhotoUrls(photoUrls);
            return this;
        }

        public Builder tags(List<Tag> tags) {
            pet.setTags(tags);
            return this;
        }

        public Pet build() {
            return pet;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPhotoUrls(List<String> photoUrls) {
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}

