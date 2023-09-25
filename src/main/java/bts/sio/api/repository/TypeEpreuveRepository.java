package bts.sio.api.repository;

import bts.sio.api.model.TypeEpreuve;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeEpreuveRepository extends CrudRepository<TypeEpreuve, Long> {
}

