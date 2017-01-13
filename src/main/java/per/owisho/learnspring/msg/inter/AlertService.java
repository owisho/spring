package per.owisho.learnspring.msg.inter;

import per.owisho.learnspring.msg.domain.Spittle;

public interface AlertService {

	void sendSpittleAlert(Spittle spittle);
	
}
