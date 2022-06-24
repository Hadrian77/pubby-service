package io.pubby.models;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Session {
	
	@Id
	String id;
	
	Date timeStamp;
	
	List<Question> questionDeck;	
	
	

	public Session() {
		
		this.timeStamp = new Timestamp(System.currentTimeMillis());
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public Date getTimeStamp() {
		return timeStamp;
	}

	


	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}



	public List<Question> getQuestionDeck() {
		return questionDeck;
	}



	public void setQuestionDeck(List<Question> questionDeck) {
		this.questionDeck = questionDeck;
	}


	@Override
	public String toString() {
		return "Session [id=" + id + ", timeStamp=" + timeStamp + ", questionDeck=" + questionDeck + "]";
	}
	
	

}
