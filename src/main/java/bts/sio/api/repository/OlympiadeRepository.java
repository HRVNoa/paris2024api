package bts.sio.api.repository;

import bts.sio.api.model.Olympiade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OlympiadeRepository extends CrudRepository<Olympiade, Long> {
}