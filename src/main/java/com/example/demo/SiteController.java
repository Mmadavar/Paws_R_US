package com.example.demo;

import com.example.demo.repository.Pet;
import com.example.demo.repository.PetRepository;
import com.example.demo.repository.PetRepositoryImpl;
import com.example.demo.service.PetService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SiteController {

    @Autowired
    private PetService PetRepositoryImpl;

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping(value="/")
        public String home(Model model) {
        List<Pet> pets = PetRepositoryImpl.getPet();
        model.addAttribute("pets",pets);
        return "index";

    }

    @GetMapping("/pets/add")
    public String addWatchPage(Model model) {
        return "addpet";
    }

    @PostMapping("/pets/add")
    public String SubmitPage(Model model, @RequestParam String name, @RequestParam String type, @RequestParam Double weight, @RequestParam int age) {
        PetRepositoryImpl.addPet(name,type,weight,age);
        //Pet newpet = new Pet(null, name, type, weight, age);
        List<Pet> pet = PetRepositoryImpl.getPet();
        //PetRepositoryImpl.addpet(newpet);
        model.addAttribute("pets",pet);
        return "index";

    }

    @GetMapping("/pets/edit")
    public String editPage(Model model) {
        return "editPet";
    }


    @GetMapping("/pets/edit/{petId}")
    public String editPet(Model model, @PathVariable("petId") Long id) {
        //get watch from database
        Pet pet = PetRepositoryImpl.getPetById(id);
        model.addAttribute("pet",pet);
        return "editPet";

    }

    @PostMapping("/pets/edit")
    public String CompleteEditPet(Model model, @RequestParam String name, @RequestParam String type, @RequestParam Double weight, @RequestParam int age, @RequestParam Long id) {
        PetRepositoryImpl.editPet(name, type, weight, age, id);
        List<Pet> pet = PetRepositoryImpl.getPet();
        model.addAttribute("pets", pet);
        return "index";
    }


    @GetMapping("/pets/remove/{petId}")
    public String deletePet(Model model, @PathVariable("petId") Long id) {
        PetRepositoryImpl.deleteID(id);
        List<Pet> pets = PetRepositoryImpl.getPet();
        model.addAttribute("pets",pets);
        return "index";

    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/layout")
    public String layout() {
        return "layout";
    }

    @GetMapping("/layout1")
    public String layout1() {
        return "layout1";
    }

    @PostMapping("/contact")
    public String Contact() {
        return "contact";
    }

    //@PostMapping("/login")
    //public String thing() {
       // return "index";
    //}




    }






