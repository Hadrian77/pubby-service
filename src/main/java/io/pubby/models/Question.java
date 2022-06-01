package io.pubby.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Question {
	
	@Id
	String id;
	
	String type;
	
	String description;
	
	String pack;
	
	List<String> keywords;
	
	List<String> tags;

	public Question(String type, String description, String pack, List<String> keywords, List<String> tags) {
		super();
		this.type = type;
		this.description = description;
		this.pack = pack;
		this.keywords = keywords;
		this.tags = tags;
	}

	public Question() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPack() {
		return pack;
	}

	public void setPack(String pack) {
		this.pack = pack;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", type=" + type + ", description=" + description + ", pack=" + pack
				+ ", keywords=" + keywords + ", tags=" + tags + "]";
	}
	
	
	
	

	
	
	

}
