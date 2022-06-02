package io.pubby.models;



import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ChildQuestion extends Question {
	

	private Question parentQuestion;
	
	

	public Question getParentQuestion() {
		return parentQuestion;
	}

	public void setParentQuestion(Question parentQuestion) {
		this.parentQuestion = parentQuestion;
	}

	@Override
	public String toString() {
		return "=ChildQuestion [parentQuestion=" + parentQuestion + ", id=" + id + ", type=" + type + ", description="
				+ description + ", pack=" + pack + ", keywords=" + keywords + ", tags=" + tags + "]";
	}

	
	
	

}