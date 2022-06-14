package com.sunil.library.library.Repository;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunil.library.library.uiModel.Book;


@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book, Integer> {

	

}
