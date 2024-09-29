package com.joaojotta.proposta_web.services;

import org.springframework.stereotype.Service;

import com.joaojotta.proposta_web.dto.PropostaRequestDTO;
import com.joaojotta.proposta_web.dto.PropostaResponseDTO;
import com.joaojotta.proposta_web.entities.Proposta;
import com.joaojotta.proposta_web.repositories.PropostaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PropostaService {
	
	private PropostaRepository propostaRepository;

	public PropostaResponseDTO criar(PropostaRequestDTO requestDto) {
		propostaRepository.save(new Proposta());
		return null;
	}
}
