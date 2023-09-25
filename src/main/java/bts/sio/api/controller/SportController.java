package bts.sio.api.controller;

import bts.sio.api.model.Athlete;
import bts.sio.api.model.Olympiade;
import bts.sio.api.model.Sport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import bts.sio.api.service.SportService;
import java.util.Optional;
@RestController
public class SportController {

    @Autowired
    private SportService sportService;



    @PostMapping("/sport")
    public Sport createSport(@RequestBody Sport sport) { return sportService.saveSport(sport);}


    @GetMapping("/sport/{id}")
    public Sport getSport(@PathVariable("id")final Long id){
        Optional<Sport> sport = sportService.getSport(id);
        if(sport.isPresent()) {
            return sport.get();
        } else {
            return null;
        }
    }
    @GetMapping("/sports")
    public Iterable<Sport> getSports() { return sportService.getSports();}

    @PutMapping("/sport/{id}")
    public Sport updateSport(@PathVariable("id") final Long id, @RequestBody Sport sport) {
        Optional<Sport> e = sportService.getSport(id);
        if(e.isPresent()) {
            Sport currentSport = e.get();

            String nom = sport.getNom();
            if(nom != null) {
                currentSport.setNom(nom);
            }
            String descriptif = sport.getDescriptif();
            if(descriptif != null) {
                currentSport.setDescriptif(descriptif);;
            }
            Olympiade olympiade = sport.getOlympiade();
            if(olympiade != null) {
                currentSport.setOlympiade(olympiade);;
            }
            sportService.saveSport(currentSport);
            return currentSport;
        } else {
            return null;
        }
    }
    @DeleteMapping("/sport/{id}")
    public void deleteSport(@PathVariable("id") final Long id) {
        sportService.deleteSport(id);
    }



}
