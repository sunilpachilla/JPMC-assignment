package com.sunil.library.library.controller;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunil.library.library.Exceptions.ResourceNotFoundException;
import com.sunil.library.library.service.StudentService;
import com.sunil.library.library.uiModel.Student;


@RestController
@RequestMapping("student")
public class StudentController {
	
	org.slf4j.Logger log = LoggerFactory.getLogger(StudentController.class);

	@Autowired	
    private StudentService studSer;
	
	@PutMapping(value="/myStudent",produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> saveStudent(@RequestBody Student student)  {
		
		try {
			studSer.save(student);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
	
	@GetMapping(value="/allstudents",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Student>> getStudents(
			@RequestParam(defaultValue="0") Integer pageNo,
			@RequestParam(defaultValue="3") Integer pageSize,
			@RequestParam(defaultValue="id") String sortBy)
			
			 throws ResourceNotFoundException{
		
		List<Student> students = studSer.getStudents(pageNo, pageSize, sortBy);
		
		return new ResponseEntity<List<Student>>(students, new HttpHeaders(),HttpStatus.OK);
		
	}
	
	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> getStudentById(@PathVariable int id) throws ResourceNotFoundException{
		
		                
	Student	student = studSer.getStudentById(id).orElseThrow(()-> new ResourceNotFoundException("Student resource not found"));
	
		return new ResponseEntity<Student>(student,HttpStatus.OK);
		
	}
	
	@PostMapping(value="/upstudent/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> updateStudent(@PathVariable int id ,@RequestBody Student student){
		
		Optional<Student> latStudent = studSer.getStudentById(id);
		
	     latStudent.get().setName(student.getName());
		
		studSer.save(latStudent.get());
		
	
		log.info("Student object was updating....");
		return new ResponseEntity<Student>(latStudent.get(), HttpStatus.OK);
		
	}

}
