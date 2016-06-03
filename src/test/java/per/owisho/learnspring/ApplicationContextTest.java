package per.owisho.learnspring;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {

	@Test
	public void applicationContext(){
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		BeanFactory factory = context;
		App app = (App)factory.getBean("app");
		System.out.println(app);
		App.main(null);
	}
	
}
