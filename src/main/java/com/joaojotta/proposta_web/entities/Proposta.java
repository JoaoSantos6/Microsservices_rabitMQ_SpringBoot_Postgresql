package com.joaojotta.proposta_web.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Proposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double valorSolicitado;
	private int prazoPagamento;
	private Boolean aprovada;
	private boolean integrada;
	private String observacao;
	
	@OneToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
}
