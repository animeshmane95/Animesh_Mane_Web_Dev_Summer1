package com.example.myApp.webdev.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.myApp.webdev.models.Widget;
import com.example.myApp.webdev.models.Assignment;
import com.example.myApp.webdev.models.Lesson;

public interface AssignmentRepository extends CrudRepository<Assignment,Integer> {
	
	@Query(value = "Select * from widget where topic_id =?1 AND widget_type = assignment", nativeQuery = true)
	public List<Widget>findAllAssignmentsForTopic(@Param("topic_id") int topicid);

}
