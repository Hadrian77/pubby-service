package io.pubby.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class DerivedQuestion extends Question {
	
	@ManyToOne
	private Question parentQuestion;
	
	

	public Question getParentQuestion() {
		return parentQuestion;
	}

	public void setParentQuestion(Question parentQuestion) {
		this.parentQuestion = parentQuestion;
	}

	@Override
	public String toString() {
		return "DerivedQuestion [parentQuestion=" + parentQuestion + ", id=" + id + ", name=" + name + ", type=" + type
				+ ", description=" + description + "]";
	}
	
	

}
