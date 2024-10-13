package com.jotta.proposta_app.repositories;

import com.jotta.proposta_app.entities.Proposta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropostaRepository extends CrudRepository<Proposta, Long> {
}
