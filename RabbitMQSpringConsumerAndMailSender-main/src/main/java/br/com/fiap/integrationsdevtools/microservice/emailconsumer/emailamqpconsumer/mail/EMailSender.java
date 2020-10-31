package br.com.fiap.integrationsdevtools.microservice.emailconsumer.emailamqpconsumer.mail;

import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * Classe que envia um email com o Spring Mail
 * @author Carlos Eduardo Roque da Silva
 *
 */
public class EMailSender {
	
	private JavaMailSender javaMailSender;
	private Environment env;
	
	public EMailSender(JavaMailSender javaMailSender, Environment env) {
		this.javaMailSender = javaMailSender;
		this.env = env;
	}
	
	public void sendEmail(MailToSend mailToSend) {
        SimpleMailMessage msg = new SimpleMailMessage();
        StringBuilder builder = new StringBuilder();
        String emailDestinoNotificacao = env.getProperty("spring.mail.properties.mail.to");
        
        builder.append("************    NOTIFICAÇÃO DE TEMPERATURA E HUMIDADE    ************");
        builder.append("************          Drone Reading Alarm Mail           ************");
        builder.append("Drone ID: ").append(mailToSend.getDroneId()).append("\n");
        builder.append("Drone Temperature:").append(mailToSend.getDroneTemperatureReading()).append("\n");
        builder.append("Drone Humidity:").append(mailToSend.getDroneHumidityReading()).append("\n");
        
        msg.setTo(emailDestinoNotificacao);
        msg.setSubject("Drone Reading Alarm Mail");
        msg.setText(builder.toString());
        javaMailSender.send(msg);
    }
	
}
