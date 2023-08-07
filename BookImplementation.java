package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Book;
import com.example.demo.Repository.BookRepository;
@Service
public class BookImplementation  implements BookService{
	@Autowired
	private BookRepository bookRepository;

	public BookImplementation(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
		
	}

	@Override
	public Book createBook(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}

	@Override
	public Book getBookById(int bookId) {
		// one correction
		// TODO Auto-generated method stub
		Optional<Book> optionalBook=bookRepository.findById(bookId);
		return optionalBook.get();
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	@Override
	public Book updateBook(Book book) {
		// TODO Auto-generated method stub
		
		Book existingBook =bookRepository.findById(book.getId()).get();
		existingBook.setTitle(book.getTitle());
		existingBook.setAuthor(book.getAuthor());
		existingBook.setTitle(book.getTitle());
		existingBook.setId(book.getId());
		
		
		Book updateBook=bookRepository.save(existingBook);
		
		return updateBook;
	}

	@Override
	public void deleteBook(int bookId) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(bookId);
		
	}

}
