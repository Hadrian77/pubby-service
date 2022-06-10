package io.pubby.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;



@Document
public class AnswerRecord {
	
	@Id
	String id;
	
	
	Question question;
	
	
	Session session;
	

	List<PlayerResponse> playerResponses;
	
	Boolean isChildQuestion;
	

	public AnswerRecord() {
		super();
	}

	public AnswerRecord(Question question, Session session, List<PlayerResponse> playerResponses, Boolean isChildQuestion) {
		super();
		this.question = question;
		this.session = session;
		this.playerResponses = playerResponses;
		this.isChildQuestion = isChildQuestion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public List<PlayerResponse> getPlayerResponses() {
		return playerResponses;
	}

	public void setPlayerResponses(List<PlayerResponse> playerResponses) {
		this.playerResponses = playerResponses;
	}

	public Boolean getIsChildQuestion() {
		return isChildQuestion;
	}

	public void setIsChildQuestion(Boolean isChildQuestion) {
		this.isChildQuestion = isChildQuestion;
	}

	@Override
	public String toString() {
		return "AnswerRecord [id=" + id + ", question=" + question + ", session=" + session + ", playerResponses="
				+ playerResponses + ", isChildQuestion=" + isChildQuestion + "]";
	}
	
	

}
