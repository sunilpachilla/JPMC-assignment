package com.sunil.library.library.service;

import java.util.List;
import java.util.Optional;

import com.sunil.library.library.uiModel.Course;

public interface CourseService {
	
	public void save(Course course);
	
	public List<Course> getCourses();
	
	public Optional<Course> getCourseById(int id);
}
