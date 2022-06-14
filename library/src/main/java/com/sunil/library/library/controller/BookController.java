package com.sunil.library.library.controller;

import java.util.ArrayList;
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
import com.sunil.library.library.service.BookService;
import com.sunil.library.library.uiModel.Book;

@RestController
@RequestMapping("book")
public class BookController {
	
	@Autowired
	private BookService bookser;
	
	
	@GetMapping(value="books", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Book>> getBooks(){
		
		List<Book> books = new ArrayList<Book>();
		
	books = bookser.findBooks();
		
	return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> getBookbyId (@PathVariable int id) throws ResourceNotFoundException{
		
		Book book = bookser.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book mentioned not found"));
		
    return new ResponseEntity<Book>(book,HttpStatus.OK);
			
	}
	@PostMapping(value="/mybook",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> saveBook(@RequestBody Book book){	
		bookser.save(book);

		//List<Book> booksresult =  bookser.findBooks();

		return new ResponseEntity<Book>(book,HttpStatus.OK);
		
	}
	
	
	}

