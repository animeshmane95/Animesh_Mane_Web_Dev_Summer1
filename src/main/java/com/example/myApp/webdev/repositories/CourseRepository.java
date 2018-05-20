package com.example.myApp.webdev.repositories;
import org.springframework.data.repository.CrudRepository;

import com.example.myApp.webdev.models.Course;

public interface CourseRepository extends CrudRepository<Course, Integer> {

}
