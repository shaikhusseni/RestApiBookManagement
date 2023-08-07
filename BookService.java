package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Book;

public interface BookService {
	

	
	Book createBook(Book book);
	Book getBookById(int bookId);
	
	List<Book> getAllBooks();
	
	Book updateBook(Book book);
	
	void deleteBook(int bookId);





}
