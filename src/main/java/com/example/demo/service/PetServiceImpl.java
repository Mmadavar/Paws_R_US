package com.example.demo.service;

import com.example.demo.repository.Pet;
import com.example.demo.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepInter;

    @Override
    public List<Pet> getPet() {
        return petRepInter.getPet();
    }

    @Override
    public void addPet(String name, String type, Double weight, int age) {
        var newPet = new Pet(null,name,type,weight,age);
        petRepInter.addPet(newPet);

    }

    @Override
    public void deleteID(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("This pet ID is required");
        }
        petRepInter.deleteID(id);
    }

    @Override
    public Pet getPetById(long id) {
        return petRepInter.getPetById(id);
    }

    @Override
    public void editPet(String name, String type, double weight, int age, Long id) {
        petRepInter.editPet(name, type, weight, age,id);
    }

}
