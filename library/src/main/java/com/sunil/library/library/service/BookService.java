package com.sunil.library.library.service;

import java.util.List;
import java.util.Optional;

import com.sunil.library.library.uiModel.Book;

public interface BookService {
	
	public List<Book> findBooks();
	
	public Optional<Book> findById(int id);
	
	public void save(Book book);
	
		

}
