package com.example.myApp.webdev.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.myApp.webdev.models.Module;



public interface ModuleRepository extends CrudRepository<Module,Integer>{
	@Query(value = "Select * from module where course_id =?1", nativeQuery = true)
	public List<Module>findAllModulesForCourse(@Param("courseid") int courseid);
	

}
