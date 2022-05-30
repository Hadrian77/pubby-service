package io.pubby.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String name;
	
	String secretName;
	
	@ManyToOne
	Session session;
	
	
	

	public Player() {
		super();
	}

	public Player(String name, String secretName) {
		super();
		this.name = name;
		this.secretName = secretName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Session getSession() {
		return session;
	}

	public void setSession(Session sessionId) {
		this.session = sessionId;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", secretName=" + secretName + ", session=" + session + "]";
	}

	
	
	
}
