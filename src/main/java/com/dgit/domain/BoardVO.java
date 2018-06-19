package com.dgit.domain;

import java.util.Date;

public class BoardVO {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private int ur_pass;
	private Date regdate;
	private int viewcnt;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getUr_pass() {
		return ur_pass;
	}
	public void setUr_pass(int ur_pass) {
		this.ur_pass = ur_pass;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	
	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", ur_pass="
				+ ur_pass + ", regdate=" + regdate + ", viewcnt=" + viewcnt + "]";
	}
	
}
