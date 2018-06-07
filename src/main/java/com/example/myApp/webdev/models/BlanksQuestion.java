package com.example.myApp.webdev.models;

import javax.persistence.Entity;

@Entity
public class BlanksQuestion extends Question {
	private String blankQuestion;

	public String getBlankQuestion() {
		return blankQuestion;
	}

	public void setBlankQuestion(String blankQuestion) {
		this.blankQuestion = blankQuestion;
	}

}
