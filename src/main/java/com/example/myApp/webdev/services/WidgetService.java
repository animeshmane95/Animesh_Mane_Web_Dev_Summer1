package com.example.myApp.webdev.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.myApp.webdev.models.Topic;
import com.example.myApp.webdev.models.Widget;
import com.example.myApp.webdev.repositories.TopicRepository;
import com.example.myApp.webdev.repositories.WidgetRepository;

@RestController
@CrossOrigin("*")
public class WidgetService {
	
	@Autowired
	TopicRepository topicRepository;
	
	@Autowired
	WidgetRepository widgetRepository;
	
	@PostMapping("api/topic/{topicId}/widget")
	public List <Widget> createWidget(@RequestBody List <Widget>  widgets, @PathVariable("topicId") int id) {
		for (Widget widget: widgets) {
		Optional<Topic> topic = topicRepository.findById(id);
		widget.setTopic(topic.get());
		widgetRepository.save(widget);
		}
		return widgets;
		
	}
	
	@DeleteMapping("/api/delete/widget/{widgetId}")
	public void deleteTopic(@PathVariable("widgetId") int widgetId) {
		widgetRepository.deleteById(widgetId);	
	}	
	
	@GetMapping("api/widget")
	public List <Widget> findAllWidgets(){
		return (List<Widget>) widgetRepository.findAll();
	}

}
