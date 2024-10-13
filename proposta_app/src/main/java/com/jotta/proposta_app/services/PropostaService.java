package com.jotta.proposta_app.services;

import com.jotta.proposta_app.dto.PropostaRequestDto;
import com.jotta.proposta_app.dto.PropostaResponseDto;
import com.jotta.proposta_app.entities.Proposta;
import com.jotta.proposta_app.mapper.PropostaMapper;
import com.jotta.proposta_app.repositories.PropostaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PropostaService {

    private PropostaRepository propostaRepository;

    public PropostaResponseDto criar(PropostaRequestDto requestDto){
        Proposta proposta = PropostaMapper.INSTANCE.convertDtoToProposta(requestDto);
        propostaRepository.save(proposta);

        return PropostaMapper.INSTANCE.convertEntityToDto(proposta);
    }
}
