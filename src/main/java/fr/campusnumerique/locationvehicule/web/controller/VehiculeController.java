package fr.campusnumerique.locationvehicule.web.controller;

import fr.campusnumerique.locationvehicule.model.Vehicule;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehiculeController {
    @RequestMapping(value="/Vehicules", method = RequestMethod.GET)
    public String listeVehicules() {
        return "EXEMPLE DE VEHICULES";
    }

    @GetMapping(value = "/Vehicules/{id}")
    public Vehicule afficherUnVehicule(@PathVariable int id) {
        Vehicule vehicule = new Vehicule(id, new String("Classe A AMG"), new String("Mercedes"), 35000);
        return vehicule;
    }

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(value = { "/personList" }, method = RequestMethod.GET)
    public String personList(Model model) {

        model.addAttribute("persons", persons);

        return "personList";
    }

    @RequestMapping(value = { "/addPerson" }, method = RequestMethod.GET)
    public String showAddPersonPage(Model model) {

        PersonForm personForm = new PersonForm();
        model.addAttribute("personForm", personForm);

        return "addPerson";
    }
}
