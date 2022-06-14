package com.sunil.library.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunil.library.library.Repository.CourseRepository;

import com.sunil.library.library.uiModel.Course;

@Service
public class CourserServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courserep;
	@Override
	public void save(Course course) {
		// TODO Auto-generated method stub
		courserep.save(course);
		
	}
	public List<Course> getCourses() {
		List<Course> courses = courserep.findAll();
		return courses;
	}
	@Override
	public Optional<Course> getCourseById(int id) {
		// TODO Auto-generated method stub
	
		return courserep.findById(id);
	}
	
}
