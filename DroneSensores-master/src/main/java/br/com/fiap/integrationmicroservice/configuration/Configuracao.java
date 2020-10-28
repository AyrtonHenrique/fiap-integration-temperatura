package br.com.fiap.integrationmicroservice.configuration;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.core.env.Environment;


/**
 * Classe de configuração para conexão com o RabbitMQ AMPQM 
 * @author Sara Regina Pires 
 *              
 *              
 **/
public class Configuracao {
	private static CachingConnectionFactory connectionFactory;
	private static Environment environment;

    public static CachingConnectionFactory getConnection(){
    	
        if(connectionFactory == null){
            connectionFactory = new CachingConnectionFactory(environment.getProperty("spring.rabbitmq.host"));//TODO add hostname
            connectionFactory.setUsername(environment.getProperty("spring.rabbitmq.username"));//TODO add username
            connectionFactory.setPassword(environment.getProperty("spring.rabbitmq.password"));//TODO add password
            connectionFactory.setVirtualHost(environment.getProperty("spring.rabbitmq.virtual-host"));//TODO add virtualhost

            //Recommended settings
            connectionFactory.setRequestedHeartBeat(Integer.valueOf(environment.getProperty("spring.rabbitmq.requested-heartbeat")));
            connectionFactory.setConnectionTimeout(Integer.valueOf(environment.getProperty("spring.rabbitmq.connection-timeout")));
        }

        return connectionFactory;
    }
}
