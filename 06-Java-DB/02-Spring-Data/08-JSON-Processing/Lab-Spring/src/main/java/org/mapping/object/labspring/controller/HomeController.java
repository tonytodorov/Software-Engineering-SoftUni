package org.mapping.object.labspring.controller;

import org.mapping.object.labspring.entities.dtos.PersonDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

//    private final PersonService personService;
//
//    public HomeController(PersonService personService) {
//        this.personService = personService;
//    }

    @GetMapping("/handle")
    public void handle() {
        System.out.println("Handled");
    }

    @GetMapping(value = "/person")
    public PersonDTO getPerson() {
        return new PersonDTO("First", "Last", 20);
    }

    public void updatePerson(PersonDTO person) {

    }
}
