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
	
	String questionId;
	
	String sessionId;
	
	List<PlayerResponse> playerResponses;
	
	Boolean isChildQuestion;
	

	public AnswerRecord() {
	
	}

	

	public AnswerRecord(String questionId, String sessionId, List<PlayerResponse> playerResponses,
			Boolean isChildQuestion) {
		super();
		this.questionId = questionId;
		this.sessionId = sessionId;
		this.playerResponses = playerResponses;
		this.isChildQuestion = isChildQuestion;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public String getQuestionId() {
		return questionId;
	}



	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}



	public String getSessionId() {
		return sessionId;
	}



	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
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
		return "AnswerRecord [id=" + id + ", questionId=" + questionId + ", sessionId=" + sessionId
				+ ", playerResponses=" + playerResponses + ", isChildQuestion=" + isChildQuestion + "]";
	}

	
	

}
