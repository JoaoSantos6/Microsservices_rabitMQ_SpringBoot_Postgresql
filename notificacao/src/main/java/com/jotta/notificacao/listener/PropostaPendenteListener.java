package com.jotta.notificacao.listener;

import com.jotta.notificacao.constante.MensagemConstante;
import com.jotta.notificacao.domain.Proposta;
import com.jotta.notificacao.service.NotificacaoSnsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Classe "ouvinte". Tudo que entra na fila, esta classe estara ouvindo
//Nao eh o RabbitMq que envia para a classe, mas eh a classe que esta
//numa fila e busca tudo de novo que acontece dentro desta fila
@Component
public class PropostaPendenteListener {

    private static final Logger log = LoggerFactory.getLogger(PropostaPendenteListener.class);

    @Autowired
    private NotificacaoSnsService notificacaoSnsService;

    @RabbitListener(queues= "${rabbitmq.queue.proposta.pendente}")
    public void propostaPendente(Proposta proposta){
        log.info("Recebida mensagem: {}", proposta);
        if (proposta == null) {
            log.error("A mensagem recebida é nula!");
            return;
        }
        String mensagem = String.format(MensagemConstante.PROPOSTA_EM_ANALISE, proposta.getUsuario().getNome());
        notificacaoSnsService.notificar(proposta.getUsuario().getTelefone(), mensagem);
    }
}
