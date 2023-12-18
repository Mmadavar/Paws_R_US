package com.example.demo.repository;

import java.util.List;

public interface PetRepository {
    List<Pet> getPet();

    void addPet(Pet pet);

    void deleteID(long id);

    Pet getPetById(long id);

    void editPet(String name, String type, double weight, int age, Long id);




}
