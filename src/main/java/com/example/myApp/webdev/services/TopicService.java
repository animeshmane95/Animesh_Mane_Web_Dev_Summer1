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

import com.example.myApp.webdev.models.Lesson;
import com.example.myApp.webdev.models.Module;
import com.example.myApp.webdev.models.Topic;
import com.example.myApp.webdev.repositories.LessonRepository;
import com.example.myApp.webdev.repositories.TopicRepository;

@RestController
@CrossOrigin("*")
public class TopicService {
	@Autowired
	LessonRepository lessonRepository;
	
	@Autowired
	TopicRepository topicRepository;
	
	@GetMapping("/api/course/{cid}/module/{mid}/lesson/{lid}/topic")
	public List<Topic> findAllTopicsForLesson(@PathVariable("lid") int id) {
		
		return topicRepository.findAllTopicsForLesson(id);
	}
	
	@DeleteMapping("/api/delete/topic")
	public void deleteTopic(@RequestParam("topicId") int id) {
		topicRepository.deleteById(id);	
	}
	
	@PostMapping("/api/course/{cid}/module/{mid}/lesson/{lid}/topic")
	public Topic createTopic(@RequestBody Topic topic, @PathVariable("lid") int id) {
		Optional<Lesson> lesson = lessonRepository.findById(id);
		topic.setLesson(lesson.get());
		return topicRepository.save(topic);
	}
}
