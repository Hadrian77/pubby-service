package io.pubby.models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Session {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	Timestamp timeStamp;
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Timestamp getTimeStamp() {
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
