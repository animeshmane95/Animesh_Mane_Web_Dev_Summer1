package com.example.myApp.webdev.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.myApp.webdev.models.User;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
public interface UserRepository extends CrudRepository<User, Integer> {
	@Query ("Select p from User p where p.username = :username")
	public List<User>findUserbyUserName(@Param("username") String username);
}
