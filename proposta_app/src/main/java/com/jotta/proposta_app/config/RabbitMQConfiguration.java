package com.jotta.proposta_app.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    @Bean
    public Queue criarFilaPropostaPendenteMsAnaliseCredito(){
        return QueueBuilder.durable("proposta-pendente.ms-analise-credito").build();
    }

    @Bean
    public Queue criarFilaPropostaPendenteMsNotificacao(){
        return QueueBuilder.durable("proposta-pendente.ms-notificacao").build();
    }

    @Bean
    public Queue criarFilaPropostaConcluidaMsProposta(){
        return QueueBuilder.durable("proposta-concluida.ms-proposta").build();
    }

    @Bean
    public Queue criarFilaPropostaConcluidaMsNotificacao(){
        return QueueBuilder.durable("proposta-concluida.ms-notificacao").build();
    }

    //classe responsavel pela permissao da aplicacao no rabbitMQ
    @Bean
    public RabbitAdmin criarRabbitAdmin(ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> inicializarAdmin(RabbitAdmin rabbitAdmin) {
        return event -> {
            System.out.println("Inicializando RabbitAdmin...");
            rabbitAdmin.initialize();
        };
    }
}
