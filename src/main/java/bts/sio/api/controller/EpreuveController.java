package bts.sio.api.controller;

import bts.sio.api.model.Epreuve;
import bts.sio.api.service.EpreuveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
@RestController
public class EpreuveController {

    @Autowired
    private EpreuveService epreuveService;

    @PostMapping("/epreuve")
    public Epreuve createEpreuve(@RequestBody Epreuve epreuve) { return epreuveService.saveEpreuve(epreuve);}


    @GetMapping("/epreuve/{id}")
    public Epreuve getSport(@PathVariable("id")final Long id){
        Optional<Epreuve> epreuve = epreuveService.getEpreuve(id);
        if(epreuve.isPresent()) {
            return epreuve.get();
        } else {
            return null;
        }
    }
    @GetMapping("/epreuves")
    public Iterable<Epreuve> getEpreuves() { return epreuveService.getEpreuves();}

    @PutMapping("/epreuve/{id}")
    public Epreuve updateEpreuve(@PathVariable("id") final Long id, @RequestBody Epreuve epreuve) {
        Optional<Epreuve> e = epreuveService.getEpreuve(id);
        if(e.isPresent()) {
            Epreuve currentEpreuve = e.get();

            String nom = epreuve.getNom();
            if(nom != null) {
                currentEpreuve.setNom(nom);
            }
            epreuveService.saveEpreuve(currentEpreuve);
            return currentEpreuve;
        } else {
            return null;
        }
    }
    @DeleteMapping("/epreuve/{id}")
    public void deleteEpreuve(@PathVariable("id") final Long id) {
        epreuveService.deleteEpreuve(id);
    }



}
