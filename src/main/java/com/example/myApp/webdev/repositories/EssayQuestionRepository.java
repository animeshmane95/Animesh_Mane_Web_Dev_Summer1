package com.example.myApp.webdev.repositories;
import org.springframework.data.repository.CrudRepository;

import com.example.myApp.webdev.models.EssayQuestion;


public interface EssayQuestionRepository extends CrudRepository<EssayQuestion, Integer>{
}
