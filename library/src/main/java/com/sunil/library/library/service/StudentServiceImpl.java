package com.sunil.library.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sunil.library.library.Repository.StudentRepository;
import com.sunil.library.library.uiModel.Student;


@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studRep;

	

	@Override
	public Optional<Student> getStudentById(int id) {
	
		return studRep.findById(id);
	}

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		studRep.save(student);	
	}

	@Override
	public List<Student> getStudents(Integer pageNo, Integer pageSize, String sortBy) {
		// TODO Auto-generated method stub
				Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
				
				Page<Student> pagedResult = studRep.findAll(paging);
				
				
				
				if(pagedResult.hasContent()) {
					return pagedResult.getContent();
				}else {
					return new ArrayList<Student>();
				}
	}


	
	
	
}

