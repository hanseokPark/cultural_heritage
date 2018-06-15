package com.dgit.domain;

public class ManagerVO {
	private String id;
	private String man_pass;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMan_pass() {
		return man_pass;
	}
	public void setMan_pass(String man_pass) {
		this.man_pass = man_pass;
	}
	@Override
	public String toString() {
		return "ManagerVO [id=" + id + ", man_pass=" + man_pass + "]";
	}
	
	
}
