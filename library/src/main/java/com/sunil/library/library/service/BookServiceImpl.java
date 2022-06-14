package com.sunil.library.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunil.library.library.Repository.BookRepository;
import com.sunil.library.library.uiModel.Book;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookrep;
	
	
	
	@Override
	public List<Book> findBooks() {
		
		List<Book> books = new ArrayList<Book>();
		
		books = bookrep.findAll();
		return books;
	}

	

	@Override
	public void save(Book book) {
	bookrep.save(book);
		
	}



	@Override
	public Optional<Book> findById(int id) {
		// TODO Auto-generated method stub

		
	
		return bookrep.findById(id);
	}



}
