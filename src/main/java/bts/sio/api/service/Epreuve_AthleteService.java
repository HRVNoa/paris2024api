package bts.sio.api.service;

import bts.sio.api.model.Epreuve_Athlete;
import bts.sio.api.repository.Epreuve_AthleteRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class Epreuve_AthleteService {
    @Autowired
    private Epreuve_AthleteRepository epreuveAthleteRepository;

    public Optional<Epreuve_Athlete> getEpreuve_Athlete(final Long id) {
        return epreuveAthleteRepository.findById(id);
    }

    public Iterable<Epreuve_Athlete> getEpreuves_Athletes() {
        return epreuveAthleteRepository.findAll();
    }

    public void deleteEpreuve_Athlete(final Long id) {
        epreuveAthleteRepository.deleteById(id);
    }

    public Epreuve_Athlete saveEpreuve_Athlete(Epreuve_Athlete epreuveAthlete) {
        Epreuve_Athlete savedEpreuve_Athlete = epreuveAthleteRepository.save(epreuveAthlete);
        return savedEpreuve_Athlete;
    }
}
