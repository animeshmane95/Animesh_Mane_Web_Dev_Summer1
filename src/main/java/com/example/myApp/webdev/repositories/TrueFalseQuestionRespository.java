package com.example.myApp.webdev.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.myApp.webdev.models.TrueFalseQuestion;

public interface TrueFalseQuestionRespository extends CrudRepository<TrueFalseQuestion, Integer> {

}
