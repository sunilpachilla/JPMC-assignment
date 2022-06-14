package com.sunil.library.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.sunil.library.library.Exceptions.ResourceNotFoundException;
import com.sunil.library.library.service.CourseService;
import com.sunil.library.library.uiModel.Course;

@RestController
@RequestMapping("course")
public class CourseController {
	
	@Autowired
	private CourseService courseSer;
	
	
	@PostMapping(value="/saveCourse",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Course> saveCourse(@RequestBody Course course){
			courseSer.save(course);
		
		return new ResponseEntity<Course>(course,HttpStatus.OK);
	}
	
	
	@GetMapping(value="/myCourse",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Course>> getCourses(){
		
		List<Course> courses= courseSer.getCourses();
		
		return new ResponseEntity<List<Course>>(courses,HttpStatus.OK);
		
	}
	
	
	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Course> getCourseById(@PathVariable int id) throws ResourceNotFoundException{
		
	Course course = courseSer.getCourseById(id).orElseThrow(() -> new ResourceNotFoundException("Course mentioned not found"));
		
		return new ResponseEntity<Course>(course, HttpStatus.OK);
		
	}
	
	
	public ResponseEntity<Course> updateCourse(@PathVariable int id, @RequestBody Course course){
	Course tobeCourse = courseSer.getCourseById(id).get();
	
	tobeCourse.setName(course.getName());
	
	courseSer.save(tobeCourse);	
		return new ResponseEntity<Course>(tobeCourse,HttpStatus.OK);	
	}
	

}
