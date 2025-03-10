package com.jotta.proposta_app.services;

import com.jotta.proposta_app.dto.PropostaResponseDto;
import com.jotta.proposta_app.entities.Proposta;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate; //cria Bean automaticamente com o Spring amqp
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class NotificacaoService {

    private RabbitTemplate rabbitTemplate;


    public void notificar(Proposta proposta, String exchange){
        rabbitTemplate.convertAndSend(exchange,"", proposta);
    }

}
