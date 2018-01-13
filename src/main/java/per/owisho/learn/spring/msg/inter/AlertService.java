package per.owisho.learn.spring.msg.inter;

import per.owisho.learn.spring.msg.domain.Spittle;

public interface AlertService {

	void sendSpittleAlert(Spittle spittle);
	
}
