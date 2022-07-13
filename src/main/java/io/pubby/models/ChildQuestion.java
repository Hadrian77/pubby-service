package io.pubby.models;



import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ChildQuestion extends Question {
	

	private String parentQuestionId;

	public String getParentQuestionId() {
		return parentQuestionId;
	}

	public void setParentQuestionId(String parentQuestionId) {
		this.parentQuestionId = parentQuestionId;
	}

	@Override
	public String toString() {
		return "ChildQuestion [parentQuestionId=" + parentQuestionId + ", id=" + id + ", type=" + type
				+ ", description=" + description + ", pack=" + pack + ", answers=" + answers + ", keywords=" + keywords
				+ ", tags=" + tags + "]";
	}
	
	
	
	
	

}
