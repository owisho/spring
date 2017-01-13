package per.owisho.learnspring.msg.domain;

import java.io.Serializable;

public class Spittle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Spittle(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "spittle name="+name;
	}
	
}
