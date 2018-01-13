package per.owisho.learn.spring.msg.impl;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.JmsUtils;

import per.owisho.learn.spring.msg.domain.Spittle;
import per.owisho.learn.spring.msg.inter.AlertService;

public class AlertServiceImpl implements AlertService{

	static ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
	
	private static JmsTemplate jmsTemplate;
	
	static{
		jmsTemplate = context.getBean(JmsTemplate.class);
	}
	
	public void sendSpittleAlert(final Spittle spittle) {
		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(spittle);
			}
		});
	}

	public Spittle getSpittleAlert(){
		try {
			ObjectMessage recivedMessage=(ObjectMessage)jmsTemplate.receive();
			return (Spittle)recivedMessage.getObject();
		} catch (JMSException e) {
			throw JmsUtils.convertJmsAccessException(e);
		}
	}
	
	public static void main(String[] args) {
		Spittle spittle = new Spittle("json");
		AlertServiceImpl impl = new AlertServiceImpl();
		impl.sendSpittleAlert(spittle);
		Spittle recive = impl.getSpittleAlert();
		System.out.println(recive);
	}
	
}
