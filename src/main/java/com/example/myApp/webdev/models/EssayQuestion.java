package com.example.myApp.webdev.models;

import javax.persistence.Entity;

@Entity

public class EssayQuestion extends Question {
private String essayQuestion;

public String getEssayQuestion() {
	return essayQuestion;
}

public void setEssayQuestion(String essayQuestion) {
	this.essayQuestion = essayQuestion;
}

}
