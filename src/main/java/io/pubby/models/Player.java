package io.pubby.models;


import javax.persistence.Id;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document
public class Player {
	
	@Id
	String id;
	
	String name;
	
	String secretName;
	
	
	String sessionId;
	

	public Player(String name, String secretName) {
		super();
		this.name = name;
		this.secretName = secretName;
	}
	

	public Player() {
		super();
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecretName() {
		return secretName;
	}

	public void setSecretName(String secretName) {
		this.secretName = secretName;
	}


	public String getSessionId() {
		return sessionId;
	}


	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}


	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", secretName=" + secretName + ", sessionId=" + sessionId + "]";
	}

	
	
	


	
	
	
}
