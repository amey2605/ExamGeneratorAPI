package com.example.demo.Model;

public class Answer {
	
	private int qid;
	private String answer;
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Answer(int qid, String answer) {
		super();
		this.qid = qid;
		this.answer = answer;
	}
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Answer [qid=" + qid + ", answer=" + answer + "]";
	}
	
	
}
