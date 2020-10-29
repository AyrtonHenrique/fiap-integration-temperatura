package br.com.fiap.integrationmicroservice.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;




/**
 * Classe de configuração para conexão com o RabbitMQ AMQP 
 * @author Sara Regina Pires 
 *              
 *              
 **/

@Configuration
public class Configuracao {

	private static final Logger logger = LoggerFactory.getLogger(Configuracao.class);
	
	@Autowired
	private static Environment environment;

	
	public Configuracao(Environment environment) {
		this.environment = environment;
	}
	
	public static String getHostname() {
		return environment.getProperty("spring.rabbitmq.host");
	}
	public static String getUsername() {
		return environment.getProperty("spring.rabbitmq.username");
	}
	public static String getPassword() {
		return environment.getProperty("spring.rabbitmq.password");
	}
	public static String getVirtualhost() {
		return environment.getProperty("spring.rabbitmq.virtual-host");
	}

	private static CachingConnectionFactory connectionFactory;
	
    public static CachingConnectionFactory getConnection() throws Exception{

        if(connectionFactory == null){
            connectionFactory = new CachingConnectionFactory(Configuracao.getHostname());
            connectionFactory.setUsername(Configuracao.getUsername());
            connectionFactory.setPassword(Configuracao.getPassword());
            connectionFactory.setVirtualHost(Configuracao.getVirtualhost());

            //Recommended settings
            connectionFactory.setRequestedHeartBeat(Integer.valueOf(environment.getProperty("spring.rabbitmq.requested-heartbeat")));
            connectionFactory.setConnectionTimeout(Integer.valueOf(environment.getProperty("spring.rabbitmq.connection-timeout")));
        }

        return connectionFactory;
    }
}
