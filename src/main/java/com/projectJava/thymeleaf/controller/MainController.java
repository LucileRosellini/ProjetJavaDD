package com.projectJava.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import com.projectJava.thymeleaf.model.Personnage;
import com.projectJava.thymeleaf.form.PersonForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@Controller
public class MainController {

    private static List<Personnage> personnages = new ArrayList<Personnage>();

    /*static {
        persons.add(new Person("Bill", true));
        persons.add(new Person("Steve", "Jobs"));
    }*/

    // Injectez (inject) via application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    @GetMapping(value = { "/personList" })
    public String personList(Model model) {
        Personnage[] personnages =restTemplate.getForObject("http://localhost:8081/personnages", Personnage[].class);
        model.addAttribute("persons", personnages);

        return "personList";
    }

    @RequestMapping(value = { "/addPerson" }, method = RequestMethod.GET)
    public String showAddPersonPage(Model model) {

        PersonForm personForm = new PersonForm();
        model.addAttribute("personForm", personForm);

        return "addPerson";
    }

    @PostMapping(value = { "/addPerson" })
    public String savePerson(Model model, //
                             @ModelAttribute("personForm") PersonForm personForm) {

        String name = personForm.getName();
        String type = personForm.getType();
//toDo:generer ID
        if (name != null && name.length() > 0 )//
                {
            Personnage newPersonnage = new Personnage(name,0,type);
            personnages.add(newPersonnage);

            return "redirect:/personList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addPerson";
    }

}
