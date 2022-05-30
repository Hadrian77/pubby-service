package io.pubby.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class AnswerRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String answer;
	
	@ManyToOne
	Question question;
	
	@ManyToOne
	Player player;
	
	@ManyToOne
	Session session;
	
	Boolean isChildQuestion;
	
	

	public AnswerRecord() {
		super();
	}

	public AnswerRecord(String answer, Question question, Player player,Session session, Boolean isChildQuestion) {
		super();
		this.answer = answer;
		this.question = question;
		this.player = player;
		this.session = session;
		this.isChildQuestion = isChildQuestion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	

	public Boolean getIsChildQuestion() {
		return isChildQuestion;
	}

	public void setIsChildQuestion(Boolean isChildQuestion) {
		this.isChildQuestion = isChildQuestion;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public String toString() {
		return "AnswerRecord [id=" + id + ", answer=" + answer + ", question=" + question + ", player=" + player
				+ ", session=" + session + ", isChildQuestion=" + isChildQuestion + "]";
	}

	
	
	
	
	
	

}
