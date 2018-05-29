package com.example.myApp.webdev.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.myApp.webdev.models.Widget;


public interface WidgetRepository extends CrudRepository<Widget,Integer> {

}
