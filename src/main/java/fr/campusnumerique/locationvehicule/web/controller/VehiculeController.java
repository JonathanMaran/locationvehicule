package fr.campusnumerique.locationvehicule.web.controller;

import fr.campusnumerique.locationvehicule.model.Vehicule;
import fr.campusnumerique.locationvehicule.model.VehiculeForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class VehiculeController {

    private static List<Vehicule> vehicules = new ArrayList<Vehicule>();

    static {
        vehicules.add(new Vehicule(1, new String("Gallardo"), new String("Lamborghini"), 150000));
        vehicules.add(new Vehicule(2, new String("Classe A AMG"), new String("Mercedes"), 38000));
        vehicules.add(new Vehicule(3, new String("Multipla"), new String("Fiat"), 9999));
    }

    @RequestMapping(value = "/listesVehicules", method = RequestMethod.GET)
    public String listeVehicules(Model model) {
        model.addAttribute("vehicules", vehicules);

        return "listesVehicules";
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("vehicules", vehicules);

        return "index";
    }
    @RequestMapping(value = { "/ajouterVehicule" }, method = RequestMethod.GET)
    public String ajoutVehicule(Model model) {

        VehiculeForm vehiculeForm = new VehiculeForm();
        model.addAttribute("vehiculeForm", vehiculeForm);

        return "ajouterVehicule";
    }

    @RequestMapping(value = { "/ajouterVehicule" }, method = RequestMethod.POST)
    public String sauvegarderVehicule(Model model, //
                             @ModelAttribute("vehiculeForm") VehiculeForm vehiculeForm) {

        int id = vehiculeForm.getId();
        String modele = vehiculeForm.getModele();
        String marque = vehiculeForm.getMarque();
        int prix = vehiculeForm.getPrix();

        if (marque != null && marque.length() > 0 //
            && modele != null && modele.length() > 0) {
            Vehicule newVehicule = new Vehicule(id, modele, marque, prix);
            vehicules.add(newVehicule);
        }

        return "redirect:/listesVehicules";
    }
}



