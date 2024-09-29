package com.joaojotta.proposta_web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaojotta.proposta_web.dto.PropostaRequestDTO;
import com.joaojotta.proposta_web.dto.PropostaResponseDTO;
import com.joaojotta.proposta_web.services.PropostaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/proposta")
public class PropostaController {

	private PropostaService propostaService;
	
	@PostMapping
	public ResponseEntity criar(@RequestBody PropostaRequestDTO requestDto) {
		PropostaResponseDTO response = propostaService.criar(requestDto);
		return ResponseEntity.ok(response);
	}
}
