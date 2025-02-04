package com.jotta.proposta_app.services;

import com.jotta.proposta_app.dto.PropostaRequestDto;
import com.jotta.proposta_app.dto.PropostaResponseDto;
import com.jotta.proposta_app.entities.Proposta;
import com.jotta.proposta_app.mapper.PropostaMapper;
import com.jotta.proposta_app.repositories.PropostaRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropostaService {

    private PropostaRepository propostaRepository;

    private NotificacaoService notificacaoService;

    private String exchange;

    public PropostaService(PropostaRepository propostaRepository,
                           NotificacaoService notificacaoService,
                           @Value("${rabbitmq.propostapendente.exchange}") String exchange) {
        this.propostaRepository = propostaRepository;
        this.notificacaoService = notificacaoService;
        this.exchange = exchange;
    }

    public PropostaResponseDto criar(PropostaRequestDto requestDto){
        Proposta proposta = PropostaMapper.INSTANCE.convertDtoToProposta(requestDto);
        propostaRepository.save(proposta); // salva no BD

        notificarRabbitMQ(proposta);//notifica a exchange proposta-pendente

        return PropostaMapper.INSTANCE.convertEntityToDto(proposta);
    }

    private void notificarRabbitMQ(Proposta proposta){
        try{
            notificacaoService.notificar(proposta, exchange);
        }catch(RuntimeException ex){
            proposta.setIntegrada(false);
            propostaRepository.save(proposta);
        }
    }

    public List<PropostaResponseDto> obterProposta() {
        return PropostaMapper.INSTANCE.convertListEntityToListDto(propostaRepository.findAll());
    }
}
