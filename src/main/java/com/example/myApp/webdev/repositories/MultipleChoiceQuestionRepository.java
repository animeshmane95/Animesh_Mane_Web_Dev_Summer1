package com.example.myApp.webdev.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.myApp.webdev.models.MultipleChoiceQuestion;

public interface MultipleChoiceQuestionRepository extends CrudRepository<MultipleChoiceQuestion, Integer>{

}
