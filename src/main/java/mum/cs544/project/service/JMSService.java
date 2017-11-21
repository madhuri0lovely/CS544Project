package mum.cs544.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@EnableJms
public class JMSService {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	/*@Bean
    public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        // This provides all boot's default to this factory, including the message converter
        configurer.configure(factory, connectionFactory);
        // You could still override some of Boot's default if necessary.
        return factory;
    }*/
	
	public void sendJMSMessage(String msg) {
		//jmsTemplate.convertAndSend("emailQ", msg);
		jmsTemplate.convertAndSend(msg);
	}
}
