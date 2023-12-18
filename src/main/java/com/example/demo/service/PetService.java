package com.example.demo.service;

import com.example.demo.repository.Pet;

import java.util.List;

public interface PetService {
    List<Pet> getPet();

    void addPet(String name, String type, Double weight, int age);

    void deleteID(Long id);

    Pet getPetById(long id);

    void editPet(String name, String type, double weight, int age, Long id);

}
