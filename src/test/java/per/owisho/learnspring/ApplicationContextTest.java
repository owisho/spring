package per.owisho.learnspring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {

	@Test
	public void applicationContext(){
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		App app = (App)context.getBean("app");
		System.out.println(app);
		App.main(null);
		((AbstractApplicationContext) context).close();
	}
	
}
