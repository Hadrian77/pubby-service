package io.pubby.models;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Session {
	
	@Id
	String id;
	
	Date timeStamp;
	
	
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public Date getTimeStamp() {
		return timeStamp;
	}



	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}



	@Override
	public String toString() {
		return "Session [id=" + id + ", timeStamp=" + timeStamp + "]";
	}
	

}
