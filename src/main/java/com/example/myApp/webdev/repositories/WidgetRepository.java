package com.example.myApp.webdev.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.myApp.webdev.models.Topic;
import com.example.myApp.webdev.models.Widget;


public interface WidgetRepository extends CrudRepository<Widget,Integer> {
	@Query(value = "Select * from widget where topic_id =?1 order By widgetorder ", nativeQuery = true)
	public List<Widget>findAllWidgetsForTopic(@Param("topicid") int topicid);

}
