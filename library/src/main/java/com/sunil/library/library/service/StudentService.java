package com.sunil.library.library.service;

import java.util.List;
import java.util.Optional;

import com.sunil.library.library.uiModel.Student;

public interface StudentService {
	
	public void save(Student latStudent);
	
	public Optional<Student> getStudentById(int id);

	public List<Student> getStudents(Integer pageNo, Integer pageSize, String sortBy);

	

}
