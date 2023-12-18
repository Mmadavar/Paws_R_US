package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class PetRepositoryImpl implements PetRepository {
    private List<Pet> petList = new ArrayList<>();

    @Override
    public List<Pet> getPet() {
        return petList;
    }


    @Override
    public void addPet(Pet pet) {
        if (pet.id() == null) {
            var ID = petList.stream().map(Pet::id).mapToInt(Long::intValue).max();
            if (ID.isEmpty()) {
                pet = new Pet((long) 1, pet.name(), pet.type(), pet.weight(), pet.age());
            } else {
                pet = new Pet((long) (ID.getAsInt() + 1), pet.name(), pet.type(), pet.weight(), pet.age());
            }
            petList.add(pet);
        }
    }








    @Override
    public Pet getPetById(long id) {
        return petList.stream().filter(j -> Objects.equals(j.id(), id)).findFirst().orElse(null);
    }


    @Override
    public void deleteID(long id) {
        petList = petList.stream().filter(p -> !Objects.equals(p.id(), id)).collect(Collectors.toList());
    }

    @Override
    public void editPet(String name, String type, double weight, int age, Long id) {
        var pet = new Pet(id,name,type,weight,age);
        for (var i =0; i < petList.size(); i++) {
            if (Objects.equals(petList.get(i).id(), id)) {
                petList.set(i, pet);
            }
        }
    }



}
