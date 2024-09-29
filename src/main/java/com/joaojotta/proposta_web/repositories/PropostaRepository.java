package com.joaojotta.proposta_web.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joaojotta.proposta_web.entities.Proposta;

@Repository
public interface PropostaRepository extends CrudRepository<Proposta, Long>{
	
}
