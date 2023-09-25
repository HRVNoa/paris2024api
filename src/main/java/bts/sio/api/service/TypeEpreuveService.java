package bts.sio.api.service;

import bts.sio.api.model.Epreuve;
import bts.sio.api.model.TypeEpreuve;
import bts.sio.api.repository.EpreuveRepository;
import bts.sio.api.repository.TypeEpreuveRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class TypeEpreuveService {
    @Autowired
    private TypeEpreuveRepository typeEpreuveRepository;

    public Optional<TypeEpreuve> getTypeEpreuve(final Long id) {
        return typeEpreuveRepository.findById(id);
    }

    public Iterable<TypeEpreuve> getTypeEpreuves() {
        return typeEpreuveRepository.findAll();
    }

    public void deleteTypeEpreuve(final Long id) {
        typeEpreuveRepository.deleteById(id);
    }

    public TypeEpreuve saveTypeEpreuve(TypeEpreuve typeepreuve) {
        TypeEpreuve savedTypeEpreuve = typeEpreuveRepository.save(typeepreuve);
        return savedTypeEpreuve;
    }
}

