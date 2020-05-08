package fr.epita.quiz.datamodel;

import java.util.List;

public class MCQQuestion {
	private List<MCQChoice> choices;	
	private Question question;
	
	public List<MCQChoice> getChoices() {
		return choices;
	}
	public void setChoices(List<MCQChoice> choices) {
		this.choices = choices;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	
}
