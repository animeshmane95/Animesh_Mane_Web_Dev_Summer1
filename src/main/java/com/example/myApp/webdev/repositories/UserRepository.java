package com.example.myApp.webdev.repositories;
import org.springframework.data.repository.CrudRepository;

import com.example.myApp.webdev.models.User;

import org.springframework.data.jpa.repository.Query;
public interface UserRepository extends CrudRepository<User, Integer> {
}
