package bts.sio.api.controller;

import bts.sio.api.model.Epreuve_Athlete;
import bts.sio.api.service.Epreuve_AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
@RestController
public class Epreuve_AthleteController {

    @Autowired
    private Epreuve_AthleteService epreuveAthleteService;

    @PostMapping("/epreuve_athlete")
    public Epreuve_Athlete createEpreuve_Athlete(@RequestBody Epreuve_Athlete epreuveAthlete) { return epreuveAthleteService.saveEpreuve_Athlete(epreuveAthlete);}


    @GetMapping("/epreuve_athlete/{id}")
    public Epreuve_Athlete getSport(@PathVariable("id")final Long id){
        Optional<Epreuve_Athlete> epreuveAthlete = epreuveAthleteService.getEpreuve_Athlete(id);
        if(epreuveAthlete.isPresent()) {
            return epreuveAthlete.get();
        } else {
            return null;
        }
    }
    @GetMapping("/epreuves_athletes")
    public Iterable<Epreuve_Athlete> getEpreuves_Athletes() { return epreuveAthleteService.getEpreuves_Athletes();}

    @PutMapping("/epreuve_athlete/{id}")
    public Epreuve_Athlete updateEpreuve_Athlete(@PathVariable("id") final Long id, @RequestBody Epreuve_Athlete epreuveAthlete) {
        Optional<Epreuve_Athlete> e = epreuveAthleteService.getEpreuve_Athlete(id);
        if(e.isPresent()) {
            Epreuve_Athlete currentEpreuve_Athlete = e.get();

            String place = epreuveAthlete.getPlace();
            if(place != null) {
                currentEpreuve_Athlete.setPlace(place);
            }
            epreuveAthleteService.saveEpreuve_Athlete(currentEpreuve_Athlete);
            return currentEpreuve_Athlete;
        } else {
            return null;
        }
    }
    @DeleteMapping("/epreuve_Athlete/{id}")
    public void deleteEpreuve_Athlete(@PathVariable("id") final Long id) {
        epreuveAthleteService.deleteEpreuve_Athlete(id);
    }



}
