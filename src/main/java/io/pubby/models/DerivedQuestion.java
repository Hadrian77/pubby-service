package io.pubby.models;



import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DerivedQuestion extends Question {
	

	private Question parentQuestion;
	
	

	public Question getParentQuestion() {
		return parentQuestion;
	}

	public void setParentQuestion(Question parentQuestion) {
		this.parentQuestion = parentQuestion;
	}

	@Override
	public String toString() {
		return "DerivedQuestion [parentQuestion=" + parentQuestion + ", id=" + id + ", type=" + type + ", description="
				+ description + ", pack=" + pack + ", keywords=" + keywords + ", tags=" + tags + "]";
	}

	
	
	

}
