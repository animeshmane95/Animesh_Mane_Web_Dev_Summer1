package com.example.myApp.webdev.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.myApp.webdev.models.Question;

public interface QuestionRepository extends CrudRepository<Question, Integer> {

}
