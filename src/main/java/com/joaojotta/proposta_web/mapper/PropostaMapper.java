package com.joaojotta.proposta_web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.joaojotta.proposta_web.dto.PropostaRequestDTO;
import com.joaojotta.proposta_web.entities.Proposta;

@Mapper
public interface PropostaMapper {

	@Mapping(target = "usuario.nome", source = "nome")
	@Mapping(target = "usuario.sobrenome", source = "sobrenome")
	@Mapping(target = "usuario.cpf", source = "cpf")
	@Mapping(target = "usuario.telefone", source = "telefone")
	@Mapping(target = "usuario.renda", source = "renda")
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "aprovada", ignore = true)
	@Mapping(target = "integrada", ignore = true)
	@Mapping(target = "observacao", ignore = true)
	Proposta convertDtoToProposta(PropostaRequestDTO propostaRequestDto);
}
